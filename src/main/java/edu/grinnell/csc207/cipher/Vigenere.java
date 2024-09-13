package edu.grinnell.csc207.cipher;

import edu.grinnell.csc207.util.CipherUtils;

/**
 * A class for the Vigenere cipher.
 * @author Drew Fargo
 * @version 1.0
 */
public final class Vigenere extends CipherObject {
  /** The keyphrase used. */
  private String key;

  /**
   * Creates a new vigenere cipher from ciphertext and a keyphrase.
   * @param text The text to be ciphered.
   * @param specKey The keyphrase.
   * @pre text matches [a-z]*
   * @pre specKey matches [a-z]+
   */
  public Vigenere(String text, String specKey) {
    super(text);
    this.key = specKey;
  } // Vigenere

  /**
   * Encrypts the text and returns the result.
   * @return The encrypted string.
   * @post The returned string matches [a-z]*
   */
  public String encrypt() {
    return CipherUtils.vigenereEncrypt(this.getText(), this.key);
  } // encrypt

  /**
   * Decrypts the text and returns the result.
   * @return The decrypted string.
   * @post The returned string matches [a-z]*
   */
  public String decrypt() {
    return CipherUtils.vigenereDecrypt(this.getText(), this.key);
  } // decrypt
} // class Vigenere
