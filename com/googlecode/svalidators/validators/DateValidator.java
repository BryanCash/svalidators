/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.googlecode.svalidators.exceptions.AttributeException;

/**
 * DateValidator.
 * Validates that a given string is a date
 * @author ssoldatos
 */
public class DateValidator extends SValidator {

  /** The date format to validate against **/
  private String dateFormat = "dd/MM/yyyy";

  /**
   * Creates a default DateValidator
   */
  public DateValidator() {
    super();
    setDateFormat(dateFormat);
    afterCreation();
  }

  /**
   * Creates a DateValidator with {@link #value}, {@link #dateFormat} and set
   * {@link #allowEmpty}
   * @param value The value to validate or null
   * @param dateFormat The dateFormat
   * @param allowEmpty If empty value is allowed
   */
  public DateValidator(String value, String dateFormat, boolean allowEmpty) {
    super();
    this.value = value;
    setDateFormat(dateFormat);
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
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(getDateFormat());
    try {
      Date testDate = simpleDateFormat.parse(value);
      if (!simpleDateFormat.format(testDate).equals(value)) {
        return false;
      }
      return true;
    } catch (ParseException ex) {
      return false;
    }
  }

  @Override
  protected void setErrorMessage() {
    errorMessage = "The value must be valid date with date format: " + dateFormat;
  }

  @Override
  public String getType() {
    return SValidator.DATE;
  }

  /**
   * Gets the validators {@link #dateFormat}
   * @return the dateFormat
   */
  public String getDateFormat() {
    return dateFormat;
  }

  /**
   * Sets the validators {@link #dateFormat}
   * @param dateFormat the dateFormat to set
   * @throws AttributeException
   */
  public void setDateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
    setErrorMessage();
  }
}
