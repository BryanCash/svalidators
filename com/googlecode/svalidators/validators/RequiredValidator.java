/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

/**
 * Required validator.
 * Ensures that the value is not empty
 * @author ssoldatos
 */
public class RequiredValidator extends SValidator {
  
  
/**
 * Creates a default RequiredValidator
 */
  public RequiredValidator() {
    super();
    afterCreation();
  }

  /**
   * Creates the validator with a {@link #value}
   * @param value The value to check.
   */
  public RequiredValidator(String value) {
    super();
    this.value = value;
    afterCreation();
  }

  @Override
  public boolean validate() {
    return !value.equals("");
  }

 
  @Override
  protected void setErrorMessage() {
    errorMessage = "Empty value is not allowed";
  }

  @Override
  public String getType() {
    return SValidator.REQUIRED;
  }

}
