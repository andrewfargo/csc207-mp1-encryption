package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;
import edu.grinnell.csc207.util.ArgParseSimple;
import edu.grinnell.csc207.util.ArgumentException;

/**
 * Main class of the AllCaesar program. Takes two arguments, one
 * specifying the action of the cipher (-encode, -decode), and one for
 * the text. The program will perform a Caesar encoding or decoding on
 * that text for all 26 letters of the alphabet.
 *
 * @author Drew Fargo
 * @version 1.0
 */
public class AllCaesar {
  /**
   * Main method of the AllCaesar program.
   *
   * @param args The argument supplied by the runtime environment.
   * @throws ArgumentException if the arguments supplied by the user
   * are invalid.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    PrintWriter errPen = new PrintWriter(System.err, true);
    ArgParseSimple arguments;
    try {
      arguments = new ArgParseSimple(args);
    } catch (ArgumentException e) {
      errPen.println("Error: " + e.getMessage());
      return;
    } // catch

    switch (arguments.getAction()) {
      case ENCODE:
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(arguments.getText(), ch));
        } // for
        break;
      case DECODE:
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(arguments.getText(), ch));
        } // for
        break;
      default:
        return; // panic
    } // switch

    pen.close();
    errPen.close();
  } // main
} // AllCaesar
