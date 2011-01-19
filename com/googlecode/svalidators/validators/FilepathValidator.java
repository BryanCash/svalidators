/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Validates that a value is a valid filepath
 * @author ssoldatos
 */
public class FilepathValidator extends SValidator {

   /**
   * Creates a default FilepathValidator
   */
  public FilepathValidator() {
    super();
    afterCreation();
  }

  /**
   * Create an FilepathValidator with a {@link #value} and set {@link #allowEmpty}
   * @param value The value to validate
   * @param allowEmpty If empty value is allowed
   */
  public FilepathValidator(String value, boolean allowEmpty) {
    super();
    this.value = value;
    this.allowEmpty = allowEmpty;
    afterCreation();
  }

  @Override
  public boolean validate() {
    File f = new File(value);
    File dir = f.getParentFile();
    if(dir == null){
      dir = new File("./");
      f = new File ("./"+value);
    }
    if(f.isFile()){
      return true;
    }
    if(dir.canWrite()){
      FileOutputStream fout = null;
      try {
      fout = new FileOutputStream(f);
      } catch (FileNotFoundException ex) {
        return false;
      } finally {
        try {
          if(fout != null){
            fout.close();
          }
        } catch (IOException ex) {
          return false;
        }
        f.delete();
      }
      return true;
    }
    return false;
  }

  @Override
  public void setErrorMessage() {
    errorMessage = "The value must be a valid file path";
  }

  @Override
  public String getType() {
    return SValidator.FILEPATH;
  }
}
