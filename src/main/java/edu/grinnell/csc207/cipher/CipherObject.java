package edu.grinnell.csc207.cipher;

/**
 * Abstract representation of a shift cipher.
 * @author Drew Fargo
 * @version 1.0
 */
public abstract class CipherObject {
  /**
   * The text to be shifted.
   */
  private String text;

  /**
   * Create a generic shift cipher from the text that needs to be shifted.
   * @param specText The text to be shifted.
   */
  public CipherObject(String specText) {
    this.text = specText;
  } // CipherObject

  /**
   * Accessor of the cipher text.
   * @return The cipher text.
   */
  protected String getText() {
    return this.text;
  } // getText

  /**
   * Abstract encryption method.
   * @return The encrypted string.
   */
  public abstract String encrypt();
  /**
   * Abstract decryption method.
   * @return The decrypted string.
   */
  public abstract String decrypt();
} // class CipherObject
