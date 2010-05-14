/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

/**
 * Numeric validator.<br />
 * Validates if a value is a number
 * @author ssoldatos
 */
public class NumericValidator extends SValidator {

  /**
   * Creates a default NumericValidator
   */
  public NumericValidator() {
    super();
    afterCreation();
  }

  /**
   * Creates a numeric validator with a {@link #value} and set {@link #allowEmpty}
   * @param value The value to validate
   * @param allowEmpty If empty value is allowed
   */
  public NumericValidator(String value, boolean allowEmpty) {
    super();
    this.value = value;
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
    try {
      Double.parseDouble(value);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  @Override
  protected void setErrorMessage() {
    errorMessage = "The value must be a number";
  }

  @Override
  public String getType() {
    return SValidator.NUMERIC;
  }
}

