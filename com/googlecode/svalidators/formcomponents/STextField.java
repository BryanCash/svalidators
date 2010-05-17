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
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.UIManager;
import com.googlecode.svalidators.exceptions.AttributeException;
import com.googlecode.svalidators.interfaces.FormComponentError;
import com.googlecode.svalidators.interfaces.FormComponentValidator;
import com.googlecode.svalidators.validators.NullValidator;
import com.googlecode.svalidators.validators.RequiredValidator;
import com.googlecode.svalidators.validators.SValidator;

/**
 * A text field component with the ability to add validators and validate its value.
 * @author ssoldatos
 */
public class STextField extends JTextField implements FormComponentError, FormComponentValidator {

  private static final long serialVersionUID = 23534646475L;
  private Image errorImage;
  private boolean error;
  private String errorMessage;
  private ValidatorList validators = new ValidatorList();

  /**
   * Called before every constructor to get the errorImage and set the size
   */
  {
    setPreferredSize(new Dimension(80, 20));
    URL url = FormComponentError.class.getResource(errorImageUrl);
    try {
      Image errorIm = ImageIO.read(url);
      errorImage = errorIm.getScaledInstance(errorIm.getWidth(this), getHeight() - 2, Image.SCALE_SMOOTH);
    } catch (IOException ex) {
    }

  }

  /**
   * Creates a default STextField
   */
  public STextField() {
    super();
    addValidator(new NullValidator());
  }

  /**
   * Creates an STextField with a validator
   * @param validator The validator to add
   */
  public STextField(SValidator validator) {
    super();
    addValidator(validator);
  }

  /**
   * Creates a STextField with initial text
   * @param value The initial text
   */
  public STextField(String value) {
    super();
    addValidator(new NullValidator());
    setText(value);
  }

  /**
   * Creates an STextField with a validator and a value
   * @param validator The validator to add
   * @param value The value
   */
  public STextField(SValidator validator, String value) {
    super();
    addValidator(validator);
    setText(value);

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (error) {
      int y = (getHeight() - errorImage.getHeight(this)) / 2;
      int x = getWidth() - errorImage.getWidth(this) - getInsets().right;
      g.drawImage(errorImage, x, y, this);
    }
  }

  @Override
  public void addError() {
    //setBackground(Color.PINK);
    error = true;
    setBorder(BorderFactory.createLineBorder(Color.RED));
    setToolTipText("<html>" + errorMessage);
    repaint();
  }

  @Override
  public void clearError() {
    error = false;
    setBorder(UIManager.getBorder("TextField.border"));
    setToolTipText("");
    repaint();
  }

  @Override
  public void setText(String t) {
    super.setText(t);
    validateValue();
  }

  @Override
  protected void processKeyEvent(KeyEvent e) {
    super.processKeyEvent(e);
    if (e.getID() == KeyEvent.KEY_RELEASED) {
      validateValue();
    }
  }

  @Override
  protected void processFocusEvent(FocusEvent e) {
    super.processFocusEvent(e);
    if (e.getID() == FocusEvent.FOCUS_LOST) {
      validateValue();
    }
  }

  @Override
  public boolean validateValue() {
    Collection<SValidator> c = validators.validators.values();
    Iterator<SValidator> it = c.iterator();
    this.errorMessage = "";
    clearError();
    while (it.hasNext()) {
      SValidator cValidator = it.next();
      cValidator.setValue(getText().trim());
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

  /**
   * @return the validators List
   */
  @Override
  public ValidatorList getValidatorsList() {
    return validators;
  }

  /**
   * @param validator the validator to set
   */
  @Override
  public void addValidator(SValidator validator) {
    this.validators.addValidator(validator);
    if (!validator.isAllowEmpty()) {
      this.validators.addValidator(new RequiredValidator());
    }
    validateValue();
  }

  @Override
  public String getErrorMessage() {
    String er = "";
    Collection<SValidator> c = validators.validators.values();
    Iterator<SValidator> it = c.iterator();
    while (it.hasNext()) {
      SValidator cValidator = it.next();
      cValidator.setValue(getText().trim());
      if (!cValidator.getErrorMessage().equals("")) {
        er += " - " + cValidator.getErrorMessage() + "<br />";
      }
    }
    return er;
  }

  @Override
  public void removeValidator(String type) {
    validators.removeValidator(type);
    validateValue();
  }

  @Override
  public void clearValidatorsList() {
    validators.clearValidators();
    validateValue();
  }

  @Override
  public int getValidatorsListSize() {
    return validators.getSize();
  }

  public SValidator getValidator(String type) {
    return validators.getValidator(type);
  }
}

