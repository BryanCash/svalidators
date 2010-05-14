/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

import com.googlecode.svalidators.exceptions.AttributeException;

/**
 *
 * @author lordovol
 */
public class NegativeNumberValidator extends NumericValidator {

  private boolean includeZero = false;

  /**
   * Creates a default NegativeNumberValidator
   */
  public NegativeNumberValidator() {
    super();
    afterCreation();
  }

  /**
   * Creates a NegativeNumberValidator with a value and set if empty is allowed
   * @param value The value to validate
   * @param includeZero
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
    if(!super.validate()){
      return false;
    }
    Double dValue = Double.parseDouble(value);
    if (includeZero && dValue == 0) {
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
}
