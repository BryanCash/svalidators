/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

/**
 * PositiveNumberValidator.<br />
 * Validates if a value is a positive number
 * @author lordovol
 */
public class PositiveNumberValidator extends NumericValidator {

  /** If zero value is valid **/
  private boolean includeZero = false;

  /**
   * Creates a default PositiveNumberValidator
   */
  public PositiveNumberValidator() {
    super();
    afterCreation();
  }

  /**
   * Creates a PositiveNumberValidator with a {@link #value},
   * sets {@link #includeZero} and sets {@link #allowEmpty}
   * @param value The value to validate
   * @param includeZero If zero is a valid value
   * @param allowEmpty If empty value is allowed
   */
  public PositiveNumberValidator(String value, boolean includeZero, boolean allowEmpty) {
    super();
    this.value = value;
    this.allowEmpty = allowEmpty;
    this.includeZero = includeZero;
    afterCreation();
  }

  @Override
  public boolean validate() {
    if (!super.validate()) {
      return false;
    }
    Double dValue = Double.parseDouble(value);
    if (includeZero && dValue == 0) {
      return true;
    } else {
      if (dValue > 0) {
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
    return SValidator.POSITIVE;
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
