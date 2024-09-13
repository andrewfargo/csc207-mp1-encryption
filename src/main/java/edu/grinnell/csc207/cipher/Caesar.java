package edu.grinnell.csc207.cipher;

import edu.grinnell.csc207.util.CipherUtils;

/**
 * A class for the Caesar cipher.
 * @author Drew Fargo
 * @version 1.0
 */
public class Caesar extends CipherObject {
  /** The key character used. */
  private char key;

  /**
   * Creates a new Caesar cipher from ciphertext and a keyphrase.
   * @param text The text to be ciphered.
   * @param specKey The key character.
   * @pre text matches [a-z]*
   * @pre specKey matches [a-z]
   */
  public Caesar(String text, char specKey) {
    super(text);
    this.key = specKey;
  } // Caesar

  /**
   * Encrypts the text and returns the result.
   * @return The encrypted string.
   * @post The returned string matches [a-z]*
   */
  public String encrypt() {
    return CipherUtils.caesarEncrypt(this.getText(), this.key);
  } // encrypt

  /**
   * Decrypts the text and returns the result.
   * @return The decrypted string.
   * @post The returned string matches [a-z]*
   */
  public String decrypt() {
    return CipherUtils.caesarDecrypt(this.getText(), this.key);
  } // decrypt
} // class Caesar
