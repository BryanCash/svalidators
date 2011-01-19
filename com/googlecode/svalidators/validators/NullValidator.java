/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

/**
 * NullValidator.It always validates to true.
 * @author ssoldatos
 */
public class NullValidator extends SValidator {

  /**
   * Creates a NullValidator
   */
  public NullValidator() {
    super();
    setAllowEmpty(true);
    afterCreation();
  }

  @Override
  public boolean validate() {
    return true;
  }

  @Override
  public void setErrorMessage() {
    errorMessage = "";
  }

  @Override
  public String getType() {
    return SValidator.NULL;
  }
}
