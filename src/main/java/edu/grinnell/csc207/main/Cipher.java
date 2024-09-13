package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.cipher.Caesar;
import edu.grinnell.csc207.cipher.Vigenere;
import edu.grinnell.csc207.cipher.CipherObject;
import edu.grinnell.csc207.util.ArgParse;
import edu.grinnell.csc207.util.ArgumentException;

/**
 * Main class for the Cipher program. Takes four arguments, one
 * specifying the action (-encode, -decode), one specifying the cipher
 * type (-caesar, -vigenere), the text, and the key. Only the text and
 * key need be in that order, the others may have varying positions.
 *
 * @author Drew Fargo
 * @version 1.0
 */
public class Cipher {
  /**
   * Main function of the Cipher program.
   *
   * @param args Program arguments supplied by the runtime
   * environment.
   * @throws ArgumentException if the arguments supplied to the
   * program are invalid, including arguments that do not exist,
   * conflicting arguments, or poor ordering of arguments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    PrintWriter errPen = new PrintWriter(System.err, true);
    ArgParse arguments;
    try {
      arguments = new ArgParse(args);
    } catch (ArgumentException e) {
      errPen.println("Error: " + e.getMessage());
      return;
    } catch (Exception e) {
      errPen.println("Error: Internal System Error");
      return;
    } // catch

    CipherObject cipher;

    switch (arguments.getType()) {
      case CAESAR:
        cipher = new Caesar(arguments.getText(), arguments.getKey().charAt(0));
        break;
      case VIGENERE:
        cipher = new Vigenere(arguments.getText(), arguments.getKey());
        break;
      default:
        return; // panic
    } // switch

    String outString;

    switch (arguments.getAction()) {
      case ENCODE:
        outString = cipher.encrypt();
        break;
      case DECODE:
        outString = cipher.decrypt();
        break;
      default:
        return; // panic
    } // switch

    pen.println(outString);
  } // main
} // Cipher
