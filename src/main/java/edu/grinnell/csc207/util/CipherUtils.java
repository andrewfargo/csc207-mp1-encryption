package edu.grinnell.csc207.util;

/**
 * A collection of cipher-related utilities.
 *
 * @author Drew Fargo
 * @version 1.0
 */
public class CipherUtils {
  /** Specifies the number of letters in the lowercase alphabet. */
  private static final int NUM_LETTERS = 26;

  /**
   * Converts a character 'a-z' to an integer 0-25.
   * @param letter A lowercase letter 'a' to 'z'
   * @return An index of the letter 0-25
   * @pre letter matches [a-z]
   * @post return is between 0 and 25, inclusive.
   */
  private static int letter2int(char letter) {
    return letter - 'a';
  } // letter2int

  /**
   * Converts an integer 0-25 to a character 'a-z'.
   * @param i An integer 0-25
   * @return A character 'a-z'
   * @pre i is between 0 and 25, inclusive
   * @post The letter returned matches [a-z]
   */
  private static char int2letter(int i) {
    return (char) ('a' + i);
  } // int2letter

  /**
   * Converts a string of text into an array of letter indices.
   * @param text A string of lowercase letters.
   * @return An array of letter indices
   * @pre text matches [a-z]*
   * @post All of the return array is between 0 and 25
   */
  private static int[] text2ints(String text) {
    int[] nums = new int[text.length()];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = letter2int(text.charAt(i));
    } // for
    return nums;
  } // text2ints

  /**
   * Converts an array of letter indices into a string.
   * @param nums An array of letter indices
   * @return A string that the indices make up
   * @pre All of nums are between 0 and 25, inclusive
   * @post The return string matches [0-25]*
   */
  private static String ints2text(int[] nums) {
    char[] letters = new char[nums.length];

    for (int i = 0; i < nums.length; i++) {
      letters[i] = (char) int2letter(nums[i]);
    } // for
    return new String(letters);
  } // ints2text

  /**
   * Sum (or take the difference of) two arrays.
   * @param a The first array
   * @param b The second array
   * @param sign Either 1 or -1. 1 represents addition and -1 subtraction.
   * @return An array c where c[i] = a[i] + (or -) b[i%blen], depending on sign.
   * @pre sign is -1 or 1
   * @pre b is not empty
   */
  private static int[] sumarrays(int[] a, int[] b, int sign) {
    int[] result = new int[a.length];

    for (int i = 0; i < a.length; i++) {
      result[i] = a[i] + (sign * b[i % b.length]);
      result[i] %= NUM_LETTERS;
      if (result[i] < 0) {
        result[i] += NUM_LETTERS; // I have strong discontentment with Java modulo
      } // if
    } // for

    return result;
  } // sumarrays

  /**
   * Performs a generic shift cipher operation.
   * @param str The string to be shifted
   * @param keyArray a list of number(s) that will shift str
   * @param sign -1 if decoding, +1 if encoding
   * @return The shifted string
   * @pre keyArray is not empty
   * @pre sign is 1 or -1
   * @pre str matches [a-z]*
   * @post return matches [a-z]*
   */
  private static String cipherOp(String str, int[] keyArray, int sign) {
    int[] nums = text2ints(str);
    nums = sumarrays(nums, keyArray, sign);
    str = ints2text(nums);
    return str;
  } // cipherOp

  /**
   * Encrypts a string using the Caesar Cipher.
   * @param str The string to be encrypted
   * @param letter The key character
   * @return The encrypted string
   * @pre str matches [a-z]*
   * @pre letter matches [a-z]
   * @post str matches [a-z]*
   */
  public static String caesarEncrypt(String str, char letter) {
    return cipherOp(str, new int[] {letter2int(letter)}, 1);
  } // caesarEncrypt

  /**
   * Decrypts a string using the Caesar Cipher.
   * @param str The string to be decrypted
   * @param letter The key character
   * @return The decrypted string
   * @pre str matches [a-z]*
   * @pre letter matches [a-z]
   * @post str matches [a-z]*
   */
  public static String caesarDecrypt(String str, char letter) {
    return cipherOp(str, new int[] {letter2int(letter)}, -1);
  } // caesarDecrypt

  /**
   * Encrypts a string using the Vigenere Cipher.
   * @param str The string to be encrypted
   * @param key The key phrase
   * @return The encrypted string
   * @pre str matches [a-z]*
   * @pre letter matches [a-z]*
   * @post str matches [a-z]*
   */
  public static String vigenereEncrypt(String str, String key) {
    return cipherOp(str, text2ints(key), 1);
  } // vigenereEncrypt

  /**
   * Decrypts a string using the Caesar Cipher.
   * @param str The string to be decrypted
   * @param key The key phrase
   * @return The decrypted string
   * @pre str matches [a-z]*
   * @pre letter matches [a-z]*
   * @post str matches [a-z]*
   */
  public static String vigenereDecrypt(String str, String key) {
    return cipherOp(str, text2ints(key), -1);
  } // vigenereDecrypt
} // class CipherUtils
