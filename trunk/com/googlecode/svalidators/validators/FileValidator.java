/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.svalidators.validators;

import java.io.File;
import com.googlecode.svalidators.exceptions.AttributeException;

/**
 * FileValidator.
 * Validates that a given string is a valis file or directory
 * The type is decided by the type attribute. Default type to file
 * @author ssoldatos
 */
public class FileValidator extends SValidator {

  /** The type of the file to validate. Must be one of {@link Type} **/
  private Type fileType = Type.FILE;

  /**
   * The fileType types :<br />
   * {@link #FILE}<br />
   * {@link #DIR}<br />
   */
  public enum Type {
    /** The {@link #value} must be a file **/
    FILE,
    /** The {@link #value} must be a directory **/
    DIR
  };

  /**
   * Creates a default FileValidator
   */
  public FileValidator() {
    super();
    afterCreation();
  }

  /**
   * Creates a FileValidator with {@link #value} , a type of {@link Type} and
   * set {@link #allowEmpty}
   * @param value The value to validate
   * @param fileType  The file type. Must be one of {@link Type}
   * @param allowEmpty If empty value is allowed
   */
  public FileValidator(String value, Type fileType, boolean allowEmpty) {
    super();
    setValue(value);
    setAllowEmpty(allowEmpty);
    setFileType(fileType);
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
    File f = new File(value);
    return ((fileType.equals(Type.FILE) && f.isFile()) ||
        (fileType.equals(Type.DIR) && f.isDirectory()));
  }

  @Override
  protected void setErrorMessage() {
    errorMessage = "The value must be a valid " + (fileType.equals(Type.FILE) ? "file" : "directory");
  }

  @Override
  public String getType() {
    return SValidator.FILE;
  }

  /**
   * Gets the {@link #fileType}
   * @return the fileType
   */
  public Type getFileType() {
    return fileType;
  }

  /**
   * Sets the {@link #fileType}
   * @param fileType the fileType to set
   * @throws AttributeException
   */
  public void setFileType(Type fileType) throws AttributeException {
    if (fileType.equals(Type.FILE) || fileType.equals(Type.DIR)) {
      this.fileType = fileType;
      setErrorMessage();
    } else {
      throw new AttributeException("The fileType must be " + Type.FILE + " or " + Type.DIR);
    }
  }
}
