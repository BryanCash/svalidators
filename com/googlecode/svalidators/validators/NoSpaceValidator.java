/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

/**
 * NoSpaceValidator.Validates that a value includes no spaces
 * @author ssoldatos
 */
public class NoSpaceValidator extends SValidator {

  /**
   * Creates a default NoSpaceValidator
   */
  public NoSpaceValidator() {
    super();
    afterCreation();
  }

  /**
   * Creates a NoSpaceValidator with a {@link #value} and sets {@link #allowEmpty}
   * @param value The value to validate
   * @param allowEmpty If empty value is allowed
   */
  public NoSpaceValidator(String value, boolean allowEmpty) {
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
    if (value.indexOf(" ") > -1) {
      return false;
    } else {
      return true;
    }

  }

  @Override
  protected void setErrorMessage() {
    errorMessage = "The value must not contain spaces";
  }

  @Override
  public String getType() {
    return SValidator.NOSPACE;
  }
}
