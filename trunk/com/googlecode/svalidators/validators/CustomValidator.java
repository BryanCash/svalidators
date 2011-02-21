/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

/**
 * CustomValidator. The validation is performed by the user and the result
 * is passed to the validator by the setValid(boolean valid) method;
 * @author ssoldatos
 */
public class CustomValidator extends SValidator {
  private boolean valid = false;

  /**
   * Creates a default NoSpaceValidator
   */
  public CustomValidator() {
    super();
    afterCreation();
  }

  /**
   * Creates a NoSpaceValidator with a {@link #value} and sets {@link #allowEmpty}
   * @param value The value to validate
   * @param allowEmpty If empty value is allowed
   */
  public CustomValidator(String value, boolean allowEmpty) {
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
    return valid;
  }

  @Override
  protected void setErrorMessage() {
    errorMessage = "";
  }

  @Override
  public void setErrorMessage(String message) {
    super.setErrorMessage(message);
  }



  @Override
  public String getType() {
    return SValidator.CUSTOM;
  }

  /**
   * @return the valid
   */
  public boolean isValid() {
    return valid;
  }

  /**
   * @param valid the valid to set
   */
  public void setValid(boolean valid) {
    this.valid = valid;
  }
}
