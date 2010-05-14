/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.exceptions;

/**
 * ComponentException<br />
 * Is thrown when an invalid component is added to a validation group
 * @author ssoldatos
 */
public class ComponentException extends IllegalArgumentException {

  /**
   * Default Constructor
   */
  public ComponentException() {
    super();
  }

  /**
   * Constructor with the exceptions message
   * @param message The exceptions message
   */
  public ComponentException(String message) {
    super(message);
  }
}
