/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.formcomponents;

import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import com.googlecode.svalidators.exceptions.ComponentException;

/**
 * A ValidationGroup consists of a list of components to be validated
 * @author ssoldatos
 */
public class ValidationGroup {

  /**
   * The list of components to validate
   */
  ArrayList<JComponent> components = new ArrayList<JComponent>();

  /**
   * Creates an empty ValidationGroup
   */
  public ValidationGroup() {
  }

  /**
   * Creates a ValidationGroup with a list of components to validate
   * @param components
   */
  public ValidationGroup(ArrayList<JComponent> components) {
    for (JComponent jComponent : components) {
      addComponent(jComponent);
    }
  }

  /**
   * Adds a component to the ValidationGroup
   * @param component The component to add. Must be {@link STextField} or
   * {@link SComboBox}
   * @throws ComponentException If the component is not {@link STextField} or
   * {@link SComboBox} 
   */
  public void addComponent(JComponent component) throws ComponentException {
    if (component instanceof SComboBox || component instanceof STextField) {
      components.add(component);
    } else {
      throw new ComponentException("Not valid component");
    }
  }

  /**
   * Removes a component from the {@link #components}
   * @param component
   */
  public void removeComponent(JComponent component) {
    components.remove(component);
  }

  /**
   * Clears the {@link #components} list
   */
  public void clear() {
    components.clear();
  }

  /**
   * Gets the number of components in {@link #components}
   * @return The number of components
   */
  public int getSize() {
    return components.size();
  }

  /**
   * Validate the components in {@link #components}
   * @return true if validation succeeds else false
   */
  public boolean validate() {
    for (JComponent jComponent : components) {
      if (jComponent instanceof SComboBox) {
        SComboBox combo = (SComboBox) jComponent;
        if (!combo.validateValue()) {
          return false;
        }
      } else if (jComponent instanceof STextField) {
        STextField textfield = (STextField) jComponent;
        if (!textfield.validateValue()) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Displays a message when validation fails
   */
  public void errorMessage() {
    JOptionPane.showMessageDialog(null, "The form validation failed.\nCheck the errors displayed in the form.", "Validation failed", JOptionPane.ERROR_MESSAGE);
  }

  /**
   * Displays a message when validation succeeds
   */
  public void successMessage() {
    JOptionPane.showMessageDialog(null, "Validation succeeded", "Success", JOptionPane.INFORMATION_MESSAGE);
  }
}
