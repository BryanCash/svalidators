/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

import java.util.ArrayList;
import java.util.Collection;
import com.googlecode.svalidators.exceptions.AttributeException;

/**
 * ListValidator
 * Check if a value is in a {@link #list}
 * @author ssoldatos
 */
public class ListValidator extends SValidator {

  /** The list to validate against **/
  private Collection<Object> list = new ArrayList<Object>();

  /**
   * Creates a default ListValidator
   */
  public ListValidator() {
    super();
    afterCreation();
  }

  /**
   * Creates a ListValidator with a {@link #value} the {@link #list} and set
   * {@link #allowEmpty}
   * @param value The value to validate
   * @param list The list of valid values
   * @param allowEmpty If empty value is allowed
   */
  public ListValidator(String value, Collection<Object> list, boolean allowEmpty) {
    super();
    this.value = value;
    this.list = list;
    this.allowEmpty = allowEmpty;
    afterCreation();
  }

  @Override
  public boolean validate() {
    int empty = validateEmpty();
    if (empty == SValidator.EMPTY_ALLOWED) {
      return true;
    } else if (empty == SValidator.EMPTY_NOTALLOWED) {
      return false;
    }
    for (Object ob : getList()) {
      if (ob.equals(value)) {
        return true;
      }
    }
    return false;
  }

  @Override
  protected void setErrorMessage() {

    errorMessage = "The value must be in the predefined list :<br />"+list.toString();
  }

  @Override
  public String getType() {
    return SValidator.LIST;
  }

  /**
   * Gets the {@link #list} of valid values
   * @return the list
   */
  public Collection<Object> getList() {
    return list;
  }

  /**
   * Sets the {@link #list} of valid values
   * @param list the list to set
   */
  public void setList(Collection<Object> list) {
    this.list = list;
    setErrorMessage();
  }
}
