package edu.grinnell.csc207.util;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class whose constructor takes in a set of arguments and produces a
 * structured output of which options the user has chosen.
 *
 * @author Drew Fargo
 * @version 1.0
 */
public class ArgParse {
  /**
   * Specifies every cipher action available to the user.
   */
  public enum CipherAction {
    /** Encode using the cipher. */
    ENCODE,
    /** Decode using the cipher. */
    DECODE
  } // CipherAction

  /**
   * Specifies every cipher available to the user.
   */
  public enum CipherType {
    /** Shift the string using one character. */
    CAESAR,
    /** Shift the string using a modulating keyphrase. */
    VIGENERE
  } // CipherType

  /** Encrypt or decrypt? */
  private CipherAction action;
  /** Caesar or Vigenere? */
  private CipherType type;
  /** The text we are shifting. */
  private String text;
  /** The key we are using. */
  private String key;

  /**
   * Takes an ArrayList of arguments AFTER options have been removed,
   * and validates that the text and key follow specific formats.
   * If this is not the case, then we throw an exception.
   *
   * @param argList The arguments.
   * @throws ArgumentException if any argument is invalid.
   */
  private void validateArguments(ArrayList<String> argList)
      throws ArgumentException {
    if (argList.size() != 2) {
      throw new ArgumentException("n/a", "Invalid arguments supplied.");
    } // if

    for (String argument : argList) {
      if (!argument.matches("[a-z]*")) {
        throw new ArgumentException(argument, "Non-alphanumeric text supplied.");
      } // if
    } // for

    if (argList.get(1).length() == 0) {
      throw new ArgumentException(argList.get(1), "Key must be at least one character.");
    } // if

    if (this.type == ArgParse.CipherType.CAESAR && argList.get(1).length() != 1) {
      throw new ArgumentException(argList.get(1), "Caesar key must be one character.");
    } // if
  } // validateArguments

  /**
   * Constructor without arguments necessary for a class extension.
   */
  public ArgParse() {
  } // ArgParse

  /**
   * Constructor for the Cipher program. Takes arguments as specified
   * by the main class of said program.
   *
   * @param args The list of arguments as a String array.
   * @throws ArgumentException if the arguments are invalid.
   */
  public ArgParse(String[] args) throws ArgumentException {
    ArrayList<String> argList = new ArrayList<String>(Arrays.asList(args));
    if (argList.remove("-caesar")) {
      this.type = ArgParse.CipherType.CAESAR;
    } else if (argList.remove("-vigenere")) {
      this.type = ArgParse.CipherType.VIGENERE;
    } // if


    if (argList.remove("-encode")) {
      this.action = ArgParse.CipherAction.ENCODE;
    } else if (argList.remove("-decode")) {
      this.action = ArgParse.CipherAction.DECODE;
    } // if

    this.validateArguments(argList);
    this.text = argList.get(0);
    this.key = argList.get(1);
  } // ArgParse

  /**
   * Accessor for the cipher type.
   * @return either CAESAR or VIGENERE
   */
  public CipherType getType() {
    return this.type;
  } // getType

  /**
   * Accessor for the cipher action.
   * @return either ENCODE or DECODE
   */
  public CipherAction getAction() {
    return this.action;
  } // getAction

  /**
   * Accessor for the cipher text.
   * @return A string of text
   */
  public String getText() {
    return this.text;
  } // getText

  /**
   * Accessor for the cipher key.
   * @return A string of text if using Vigenere, or a string of one character if Caesar
   */
  public String getKey() {
    return this.key;
  } // getKey

  /**
   * Mutator for the cipher type.
   * Used by class extensions.
   * @param newType The new type
   */
  protected void setType(CipherType newType) {
    this.type = newType;
  } // setType

  /**
   * Mutator for the cipher action.
   * Used by class extensions.
   * @param newAction The new action
   */
  protected void setAction(CipherAction newAction) {
    this.action = newAction;
  } // setAction

  /**
   * Mutator for the cipher text.
   * Used by class extensions.
   * @param newText The new text
   */
  protected void setText(String newText) {
    this.text = newText;
  } // setText

  /**
   * Mutator for the cipher key.
   * Used by class extensions.
   * @param newKey The new key
   */
  protected void setKey(String newKey) {
    this.key = newKey;
  } // setKey
} // ArgParse
