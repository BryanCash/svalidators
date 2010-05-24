/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.svalidators.validators;

import java.util.regex.Pattern;

/**
 * Creates a validator that doesn't allow certain chars in the value
 * @author ssoldatos
 */
public class ExcludeValidator extends SValidator{

  private String excludeChars;

  /**
   * Creates a default ExcludeValidator
   */
  public ExcludeValidator() {
    super();
    afterCreation();
  }

  /**
   * Creates a ExcludeValidator with a {@link #value}, {@link #excludeChars}
   * and sets {@link #allowEmpty}
   * @param value The value to validate
   * @param excludeChars The invalid chars
   * @param allowEmpty If empty value is allowed
   */
  public ExcludeValidator(String value, String excludeChars, boolean allowEmpty) {
    super();
    this.value = value;
    this.setExcludeChars(excludeChars);
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
     if(new RegularExpressionValidator(value, excludeChars, false, allowEmpty).validate()){
       return false;
     } else {
       return true;
     }
  }

  @Override
  protected void setErrorMessage() {
     errorMessage = "The value must not include any of these characters: " + getExcludeChars();
  }

  @Override
  public String getType() {
    return SValidator.EXCLUDE;
  }

  /**
   * @return the excludeChars
   */
  public String getExcludeChars() {
    return excludeChars;
  }

  /**
   * @param excludeChars the excludeChars to set
   */
  public void setExcludeChars(String excludeChars) {
    this.excludeChars = Pattern.quote(excludeChars);
  }

}
