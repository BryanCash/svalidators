/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

import com.googlecode.svalidators.exceptions.AttributeException;
import java.util.Arrays;

/**
 * CompareValidator
 * Check if one value is equal, less, greater, less or equals and greater or
 * equals to another value.If values are both numbers a number comparison is
 * performed. If values are not numbers a string comparison is performed. If one
 * value is number and the other is string the validation returns false.
 * @author ssoldatos
 */
public class CompareValidator extends SValidator {

  /** The value to compare with **/
  private String valueToCompareWith;
  /** The comparing type : Must be one of{@link Type} **/
  private Type compareType;

  /**
   * The compare types :<br /> 
   * {@linkplain #LESS},<br />
   * {@linkplain #EQUALS},<br />
   * {@linkplain #GREATER},<br />
   * {@linkplain #LESS_OR_EQUAL},<br />
   * {@linkplain #GREATER_OR_EQUAL},<br />
   * {@linkplain #NOT_EQUAL}
   */
  public static enum Type {
    /** The {@link #value} must be less than the {@link #valueToCompareWith} **/
    LESS,
    /** The {@link #value} must be equal to the {@link #valueToCompareWith} **/
    EQUAL,
    /** The {@link #value} must be greater than the {@link #valueToCompareWith} **/
    GREATER,
    /** The {@link #value} must be less than or equal to the {@link #valueToCompareWith} **/
    LESS_OR_EQUAL,
    /** The {@link #value} must be greater than or equal to the {@link #valueToCompareWith} **/
    GREATER_OR_EQUAL,
    /** The {@link #value} must be not equal to the {@link #valueToCompareWith} **/
    NOT_EQUAL;
  };

  /**
   * Creates a default CompareValidator with value to compare = "" and type of
   * equals
   */
  public CompareValidator() {
    super();
    this.compareType = Type.EQUAL;
    this.valueToCompareWith = "";
    afterCreation();
  }

  /**
   * Creates a DateValidator with a value , a value to compare with, the compare type
   * and if empty value is allowed
   * @param value The value to validate
   * @param valueToCompare The value to compare with
   * @param compareType The compare type. Must be one of {@link Type}
   * @param allowEmpty If empty value is allowed
   */
  public CompareValidator(String value, String valueToCompare, Type compareType, boolean allowEmpty) {
    super();
    this.value = value;
    this.valueToCompareWith = valueToCompare;
    setCompareType(compareType);
    this.allowEmpty = allowEmpty;
    afterCreation();
  }

  @Override
  public boolean validate() {
    int empty = validateEmpty();
    int compareEmpty = new RequiredValidator(getValueToCompareWith()).validateEmpty();
    if ((empty == SValidator.EMPTY_ALLOWED) && (compareEmpty == SValidator.EMPTY_ALLOWED)) {
      return true;
    } else if (empty == SValidator.EMPTY_NOTALLOWED) {
      return false;
    }

    if (new NumericValidator(value, false).validate()
        && new NumericValidator(valueToCompareWith, false).validate()) {
      double dValue = Double.parseDouble(value);
      double dValueToCompareWith = Double.parseDouble(valueToCompareWith);
      if (compareType.equals(Type.EQUAL)) {
        return dValue == dValueToCompareWith;
      } else if (compareType.equals(Type.LESS)) {
        return dValue < dValueToCompareWith;
      } else if (compareType.equals(Type.GREATER)) {
        return dValue > dValueToCompareWith;
      } else if (compareType.equals(Type.LESS_OR_EQUAL)) {
        return dValue <= dValueToCompareWith;
      } else if (compareType.equals(Type.GREATER_OR_EQUAL)) {
        return dValue >= dValueToCompareWith;
      } else if (compareType.equals(Type.NOT_EQUAL)) {
        return dValue != dValueToCompareWith;
      }
    } else {
      if (new NumericValidator(value, false).validate()
        || new NumericValidator(valueToCompareWith, false).validate()) {
        return false;
      }
      if (compareType.equals(Type.EQUAL)) {
        return value.equals(valueToCompareWith);
      } else if (compareType.equals(Type.LESS)) {
        return value.compareTo(valueToCompareWith) < 0;
      } else if (compareType.equals(Type.GREATER)) {
        return value.compareTo(valueToCompareWith) > 0;
      } else if (compareType.equals(Type.LESS_OR_EQUAL)) {
        return value.compareTo(valueToCompareWith) <= 0;
      } else if (compareType.equals(Type.GREATER_OR_EQUAL)) {
        return value.compareTo(valueToCompareWith) >= 0;
      } else if (compareType.equals(Type.NOT_EQUAL)) {
        return value.compareTo(valueToCompareWith) != 0;
      }
    }
    return false;
  }

  @Override
  protected void setErrorMessage() {
    errorMessage = "The value must be"
        + (compareType.equals(Type.LESS) ? " less than "
        : compareType.equals(Type.EQUAL) ? " equal to "
        : compareType.equals(Type.GREATER) ? " greater than "
        : compareType.equals(Type.LESS_OR_EQUAL) ? " less than or equal to "
        : compareType.equals(Type.GREATER_OR_EQUAL) ? " greater than or equal to "
        : compareType.equals(Type.NOT_EQUAL) ? " not equal to " :"")
        + "<b>'" + getValueToCompareWith() + "'</b>";
  }

  @Override
  public String getType() {
    return SValidator.COMPARE;
  }

  /**
   * Gets the {@link #valueToCompareWith}
   * @return the valueToCompareWith
   */
  public String getValueToCompareWith() {
    return valueToCompareWith;
  }

  /**
   * Sets the {@link #valueToCompareWith}
   * @param valueToCompareWith the valueToCompareWith to set
   */
  public void setValueToCompareWith(String valueToCompareWith) {
    this.valueToCompareWith = valueToCompareWith;
    setErrorMessage();
  }

  /**
   * Gets the {@link #compareType}
   * @return the compareType
   */
  public Type getCompareType() {
    return compareType;
  }

  /**
   * Sets the {@link #compareType}
   * @param compareType the compareType to set
   * @throws AttributeException
   */
  public void setCompareType(Type compareType) throws AttributeException {
    if (Arrays.binarySearch(Type.values(), compareType) > -1) {
      this.compareType = compareType;
      setErrorMessage();
    } else {
      throw new AttributeException("Compare type must be :" + Type.LESS + " or "
          + Type.EQUAL + " or " + Type.GREATER + " or " + Type.LESS_OR_EQUAL + " or " + Type.GREATER_OR_EQUAL);
    }
  }
}
