/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import com.googlecode.svalidators.exceptions.AttributeException;

/**
 * ReqularExpressionValidator
 * Validates a value against a regular expression
 * At least one attribute should be provided : regex
 * An optional attribute is the boolean match. If the match is
 * used to validate (whole value should match the regex).
 * If false find will be used (only a part of the value needs to match the regex).
 * @author ssoldatos
 */
public class RegularExpressionValidator extends SValidator {
  /** The regular expression **/
  private String regex = "";
  /** If value should match exactly the regex or include it **/
  private boolean match = false;

  /**
   * Creates a default RegularExpressionValidator
   */
  public RegularExpressionValidator()  {
    super();
    afterCreation();
  }


  /**
   * Creates a regular expression validator with a {@link #value} and
   * set {@link #regex} and {@link #match}
   * @param value The value to check
   * @param regex The regular expression
   * @param match If value should match exactly the regex or include it
   * @param allowEmpty If empty value is allowed
   */
  public RegularExpressionValidator(String value, String regex, boolean match , boolean allowEmpty) {
    super();
    this.value = value;
    this.allowEmpty = allowEmpty;
    setRegex(regex);
    setMatch(match);
    afterCreation();
  }

  @Override
  public boolean validate() {
   int empty = validateEmpty();
    if (empty == SValidator.EMPTY_ALLOWED) {
      return true;
    } else if(empty == SValidator.EMPTY_NOTALLOWED){
      return false;
    }
    Pattern patt = Pattern.compile(getRegex());
    Matcher m = patt.matcher(getValue());
    if (isMatch()) {
      return m.matches();
    } else {
      return m.find();
    }
  }

  @Override
  public void setErrorMessage() {
    errorMessage = "Value must " + (isMatch() ? "match " : "include ") + " the regural expression '" + getRegex() + "'";
  }

  @Override
  public String getType() {
    return SValidator.REGEX;
  }

  /**
   * Gets the {@link #regex}
   * @return the regex
   */
  public String getRegex() {
    return regex;
  }

  /**
   * Sets the {@link #regex}
   * @param regex the regex to set
   * @throws AttributeException If {@link #regex} is not a valid regular expression
   */
  public void setRegex(String regex) throws AttributeException {
    try{
      Pattern.compile(regex);
      this.regex = regex;
      setErrorMessage();
    } catch(PatternSyntaxException ex){
      throw new AttributeException(regex + " is not a valid regular expression");
    }
  }

  /**
   * Gets the {@link #match}
   * @return the match
   */
  public boolean isMatch() {
    return match;
  }

  /**
   * Sets the {@link #match}
   * @param match the match to set
   */
  public void setMatch(boolean match) {
    this.match = match;
    setErrorMessage();
  }
}
