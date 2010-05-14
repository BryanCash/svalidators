/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.svalidators.formcomponents;

import java.util.HashMap;
import java.util.Map;
import com.googlecode.svalidators.validators.SValidator;

/**
 *
 * @author ssoldatos
 */
public class ValidatorList {
  Map<String,SValidator> validators = new HashMap<String, SValidator>();

  public ValidatorList() {
  }

  public void addValidator(SValidator validator){
    removeValidator(validator.getType());
    validators.put(validator.getType(), validator);
  }

  public void removeValidator(String type){
    validators.remove(type);
  }

  public void clearValidators(){
    validators.clear();
  }

  public int getSize(){
    return validators.size();
  }

  public SValidator getValidator(String type) {
    return validators.get(type);
  }
}
