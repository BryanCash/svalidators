/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.svalidators.formcomponents;

import java.util.HashMap;
import java.util.Map;
import com.googlecode.svalidators.validators.SValidator;

/**
 * A list of a components Validators
 * @author ssoldatos
 */
public class ValidatorList {
  Map<String,SValidator> validators = new HashMap<String, SValidator>();

  /**
   * Creates a default list
   */
  public ValidatorList() {
  }

  /**
   * Adds a validator to the {@link #validators}. Only one validator of each type
   * is allowed in the list, so if there's already a validator of this type in the list
   * is removed first.
   * @param validator The validator to add
   */
  public void addValidator(SValidator validator){
    removeValidator(validator.getType());
    validators.put(validator.getType(), validator);
  }

  /**
   * Removes a validator from the {@link #validators}
   * @param type The type of validator to remove
   */
  public void removeValidator(String type){
    validators.remove(type);
  }

  /**
   * Clears the  {@link #validators} list
   */
  public void clearValidators(){
    validators.clear();
  }

  /**
   * Gets the  {@link #validators} size
   * @return The number of validators in  {@link #validators}
   */
  public int getSize(){
    return validators.size();
  }

 /**
  * Get a validsator from the list
  * @param type The type of validator to get
  * @return The validator
  */
  public SValidator getValidator(String type) {
    if(validators.containsKey(type)){
      return validators.get(type);
    } else {
      return null;
    }
  }
}
