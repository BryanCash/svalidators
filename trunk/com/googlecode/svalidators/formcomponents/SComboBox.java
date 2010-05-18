/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.formcomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.UIManager;
import com.googlecode.svalidators.exceptions.AttributeException;
import com.googlecode.svalidators.interfaces.FormComponentError;
import com.googlecode.svalidators.interfaces.FormComponentValidator;
import com.googlecode.svalidators.validators.NullValidator;
import com.googlecode.svalidators.validators.RequiredValidator;
import com.googlecode.svalidators.validators.SValidator;

/**
 * A combo box component with the ability to add validators and validate its value.
 * @author ssoldatos
 */
public class SComboBox extends JComboBox implements FormComponentError, FormComponentValidator {

  private static final long serialVersionUID = 346467346236435L;
  private boolean allowEmpty = true;
  private boolean error;
  private Image errorImage;
  private String errorMessage;
  private ValidatorList validators = new ValidatorList();

  /**
   * Called before every constructor to get the errorImage and set the components size
   */
  {
    URL url = FormComponentError.class.getResource(errorImageUrl);
    setPreferredSize(new Dimension(100, 20));
    try {
      Image errorIm = ImageIO.read(url);
      errorImage = errorIm.getScaledInstance(errorIm.getWidth(this), getHeight() - 2, Image.SCALE_SMOOTH);
    } catch (IOException ex) {
    }

  }

  /**
   * Creates a default SComboBox
   */
  public SComboBox() {
    super();
    addValidator(new NullValidator());
  }

  /**
   * Creates a SComboBox with a Validator
   * @param validator The validator to add to the component
   */
  public SComboBox(SValidator validator) {
    super();
    setAllowEmpty(allowEmpty);
    addValidator(validator);
  }

  /**
   * Creates a SComboBox with a Validator and setting if empty value is allowed
   * @param validator The validator to add to the component
   * @param allowEmpty If empty is allowed
   */
  public SComboBox(SValidator validator, boolean allowEmpty) {
    super();
    setAllowEmpty(allowEmpty);
    addValidator(validator);
  }

  @Override
  public void addError() {
    setBorder(BorderFactory.createLineBorder(Color.RED));
    setToolTipText("<html>" + errorMessage);
    error = true;
    repaint();
  }

  @Override
  public void clearError() {
    setBorder(UIManager.getBorder("ComboBox.border"));
    setToolTipText("");
    error = false;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (error) {
      setOpaque(false);
      JComponent comboEditor = (JComponent) getEditor().getEditorComponent();
      comboEditor.setOpaque(false);
      int y = (getHeight() - errorImage.getHeight(this)) / 2;
      int x = getWidth() - errorImage.getWidth(this) - getInsets().right;
      g.drawImage(errorImage, x - 20, y, this);
    }
  }

  @Override
  protected void processFocusEvent(FocusEvent e) {
    super.processFocusEvent(e);
    validateValue();
  }

  @Override
  public void processKeyEvent(KeyEvent e) {
    super.processKeyEvent(e);
    validateValue();
  }

  @Override
  protected void selectedItemChanged() {
    super.selectedItemChanged();
    validateValue();
  }

  @Override
  public void setEditable(boolean aFlag) {
    super.setEditable(aFlag);
    if (isEditable()) {
      getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

        @Override
        public void keyReleased(KeyEvent e) {
          validateValue();
        }
      });
    }
    validateValue();
  }

  @Override
  public void setModel(ComboBoxModel aModel) {
    super.setModel(aModel);
    validateValue();
  }

  @Override
  public boolean validateValue() {
    if (!isEditable()) {
      if (isAllowEmpty() || getSelectedIndex() > 0) {
        clearError();
        return true;
      } else {
        addError();
        this.errorMessage = " - Default value is not valid";
        return false;
      }
    }
    String val = String.valueOf(getEditor().getItem());
    Collection<SValidator> c = getValidators().validators.values();
    Iterator<SValidator> it = c.iterator();
    this.errorMessage = "";
    clearError();
    while (it.hasNext()) {
      SValidator cValidator = it.next();
      cValidator.setValue(val);
      try {
        if (!cValidator.validate()) {
          error = true;
          this.errorMessage += " - " + cValidator.getErrorMessage() + "<br />";
        }
      } catch (AttributeException ex) {
        error = true;
        addError();
        this.errorMessage += " - " + cValidator.getErrorMessage() + "<br />";
      }
    }
    if (error) {
      addError();
      return false;
    }
    clearError();
    return true;
  }

  @Override
  public String getErrorMessage() {
    String er = "";
    Collection<SValidator> c = getValidators().validators.values();
    Iterator<SValidator> it = c.iterator();
    while (it.hasNext()) {
      SValidator cValidator = it.next();
      cValidator.setValue(getSelectedItem().toString().trim());
      if (!cValidator.validate() && !cValidator.getErrorMessage().equals("")) {
        er += " - " + cValidator.getErrorMessage() + "<br />";
      }
    }
    return er;
  }

  @Override
  public void addValidator(SValidator validator) {
    getValidators().addValidator(validator);
    validateValue();
  }

  @Override
  public void removeValidator(String type) {
    getValidators().removeValidator(type);
    validateValue();
  }

  @Override
  public void clearValidatorsList() {
    getValidators().clearValidators();
    validateValue();
  }

  @Override
  public ValidatorList getValidatorsList() {
    return getValidators();
  }

  @Override
  public int getValidatorsListSize() {
    return getValidators().getSize();
  }

  /**
   * @return the allowEmpty
   */
  public boolean isAllowEmpty() {
    return allowEmpty;
  }

  /**
   * @param allowEmpty the allowEmpty to set
   */
  public void setAllowEmpty(boolean allowEmpty) {
    this.allowEmpty = allowEmpty;
    if (!allowEmpty) {
      addValidator(new RequiredValidator());
    }
  }

  /**
   * @return the validators
   */
  public ValidatorList getValidators() {
    return validators;
  }

  /**
   * @param validators the validators to set
   */
  public void setValidators(ValidatorList validators) {
    this.validators = validators;
    validateValue();
  }
}
