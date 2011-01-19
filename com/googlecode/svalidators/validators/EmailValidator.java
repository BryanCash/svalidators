/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

/**
 * Validates that a value is an email address
 * @author ssoldatos
 */
public class EmailValidator extends RegularExpressionValidator {

  /** The emails regular expression **/
  private final String EMAIL_REGEX = "\\b[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}\\b";

  /**
   * Creates a default EmailValidator
   */
  public EmailValidator() {
    super();
    setRegex(EMAIL_REGEX);
    afterCreation();
  }

  /**
   * Create an EmailValidator with a {@link #value} and set {@link #allowEmpty}
   * @param value The value to validate
   * @param allowEmpty If empty value is allowed
   */
  public EmailValidator(String value, boolean allowEmpty) {
    super();
    this.value = value;
    this.allowEmpty = allowEmpty;
    setRegex(EMAIL_REGEX);
    afterCreation();
  }

  @Override
  public boolean validate() {
    return super.validate();
  }

  @Override
  public void setErrorMessage() {
    errorMessage = "The value must be a valid email";
  }

  @Override
  public String getType() {
    return SValidator.EMAIL;
  }
}
