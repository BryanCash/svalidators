/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

/**
 * Creates an integer validator to check if a given value is an integer
 * @author ssoldatos
 */
public class IntegerValidator extends NumericValidator {

  /**
   * Creates a default IntegerValidator
   */
  public IntegerValidator() {
    super();
    afterCreation();
  }

  /**
   * Creates an Integer validator with a {@link #value} and set {@link #allowEmpty}
   * @param value The value to check.
   * @param allowEmpty If empty value is allowed
   */
  public IntegerValidator(String value, boolean allowEmpty) {
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
    if (!super.validate()) {
      return false;
    }
    if (Double.parseDouble(value) == Long.parseLong(value)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  protected void setErrorMessage() {
    errorMessage = "The value must be a valid integer";
  }

  @Override
  public String getType() {
    return SValidator.INTEGER;
  }
}
