/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

/**
 * NegativeNumberValidator. Validates that a number is a negative one.
 * @author lordovol
 */
public class NegativeNumberValidator extends NumericValidator {

  /** If zero value is valid **/
  private boolean includeZero = false;

  /**
   * Creates a default NegativeNumberValidator
   */
  public NegativeNumberValidator() {
    super();
    afterCreation();
  }

  /**
   * Creates a NegativeNumberValidator with a {@link #value} , {@link #includeZero}
   * and set {@link #allowEmpty}
   * @param value The value to validate
   * @param includeZero If zero is valid
   * @param allowEmpty If empty value is allowed
   */
  public NegativeNumberValidator(String value, boolean includeZero, boolean allowEmpty) {
    super();
    this.value = value;
    this.includeZero = includeZero;
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
    if(!super.validate()){
      return false;
    }
    Double dValue = Double.parseDouble(value);
    if (isIncludeZero() && dValue == 0) {
      return true;
    } else {
      if (dValue < 0) {
        return true;
      }
    }
    return false;

  }

  @Override
  protected void setErrorMessage() {
    errorMessage = "The value must be a positive number";
  }

  @Override
  public String getType() {
    return SValidator.NEGATIVE;
  }

  /**
   * Gets {@link #includeZero}
   * @return the includeZero
   */
  public boolean isIncludeZero() {
    return includeZero;
  }

  /**
   * Sets {@link #includeZero}
   * @param includeZero the includeZero to set
   */
  public void setIncludeZero(boolean includeZero) {
    this.includeZero = includeZero;
  }
}
