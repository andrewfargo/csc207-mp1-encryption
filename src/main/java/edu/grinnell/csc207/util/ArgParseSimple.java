package edu.grinnell.csc207.util;

/**
 * An extension of ArgParse for use in the AllCaesar program.
 * Takes in a list of arguments into its constructor and provides a
 * structured result of which options were chosen.
 *
 * @author Drew Fargo
 * @version 1.0
 */
public class ArgParseSimple extends ArgParse {
  /**
   * The constructor for the AllCaesar program. Takes an argument for
   * the action of the cipher and th text supplied. Sets also the
   * initial values for the cipher to work.
   * @param args The arugment list.
   * @throws ArgumentException if the arguments provided are invalid.
   */
  public ArgParseSimple(String[] args) throws ArgumentException {
    super.setType(ArgParse.CipherType.CAESAR);
    if (args.length != 2) {
      throw new ArgumentException(String.valueOf(args.length),
                                  "Invalid number of arguments specified.");
    } // if

    if (args[0].equals("encode")) {
      super.setAction(ArgParse.CipherAction.ENCODE);
    } else if (args[0].equals("decode")) {
      super.setAction(ArgParse.CipherAction.DECODE);
    } else {
      throw new ArgumentException(args[0],
                                  "Illegal argument, expect \"encode\", \"decode\".");
    } // if

    if (!args[1].matches("[a-z]*")) {
      throw new ArgumentException(args[1], "Non-alphanumeric text supplied.");
    } // if

    super.setText(args[1]);
  } // ArgParseSimple
} // ArgParseSimple
