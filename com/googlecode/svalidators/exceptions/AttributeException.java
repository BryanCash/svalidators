/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.svalidators.exceptions;

/**
 * AttributeException<br />
 * Is thrown when a invalid attribute is set to a validator
 * @author ssoldatos
 */
public class AttributeException extends IllegalArgumentException {
  private static final long serialVersionUID = 235364575687L;

  /**
   * Default Constructor
   */
 public AttributeException() {
    super();
  }

 /**
  * Constructor with the exceptions message
  * @param message The exceptions message
  */
  public AttributeException(String message) {
    super(message);
  }




}
