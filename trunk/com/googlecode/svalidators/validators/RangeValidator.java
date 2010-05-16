/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

/**
 * Numeric range validator.
 * Checks if a valus is greater or equal to a min value, lesser or ewual to
 * a max value or both of them.
 * The attributes must be provided and should be one of min , max or both of them
 * @author ssoldatos
 */
public class RangeValidator extends NumericValidator {
  /** The range minimum value **/
  private double min = -Double.MAX_VALUE;
  /** The range maximum value **/
  private double max = Double.MAX_VALUE;

  /**
   * Creates a numeric range validator
   */
  public RangeValidator() {
    super();
    afterCreation();
  }

  /**
   * Creates a numeric range validator with a {@link #value} and set {@link #min},
   *  {@link #max} and  {@link #allowEmpty}
   * @param value The value to validate
   * @param min The minimum valid value.
   * @param max The maximum valid value.
   * @param allowEmpty If empty value is allowed
   */
  public RangeValidator(String value, double min, double max, boolean allowEmpty) {
    super();
    this.value = value;
    this.max = max;
    this.allowEmpty = allowEmpty;
    this.min = min;
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
    if (!super.validate()) {
      return false;
    }
    double doubleValue = Double.parseDouble(getValue());
    if (doubleValue <= getMax() && doubleValue >= getMin()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  protected void setErrorMessage() {
    if (getMin() != -Double.MAX_VALUE && getMax() != Double.MAX_VALUE) {
      errorMessage = "The value must be between " + getMin() + " and " + getMax();
    } else {
      errorMessage = "The value must be  " + (getMin() != -Double.MAX_VALUE ? "greater than " + getMin() : "lesser than " + getMax());
    }
  }

  @Override
  public String getType() {
    return SValidator.RANGE;
  }

  /**
   * Gets the {@link #min}
   * @return the min
   */
  public double getMin() {
    return min;
  }

  /**
   * Sets the {@link #min}
   * @param min the min to set
   */
  public void setMin(double min) {
    this.min = min;
    setErrorMessage();
  }

  /**
   * Gets the {@link #max}
   * @return the max
   */
  public double getMax() {
    return max;
  }

  /**
   * Sets the {@link #max}
   * @param max the max to set
   */
  public void setMax(double max) {
    this.max = max;
    setErrorMessage();
  }
}
