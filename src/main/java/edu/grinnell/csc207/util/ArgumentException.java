package edu.grinnell.csc207.util;
/**
 * Class specifying the exception of illegal arguments.
 * The only extension of the typical Exception class is the specification
 * of which argument caused the exception.
 *
 * @author Drew Fargo
 * @version 1.0
 */
public class ArgumentException extends Exception {
  /** The argument that caused the exception. */
  private String argument;
  /**
   * Construct an argument exception from a provided argument and associated error.
   * @param message What the argument was doing wrong
   * @param specArgument The guilty argument
   */
  public ArgumentException(String message, String specArgument) {
    super(message);
    this.argument = specArgument;
  } // ArgumentException

  /**
   * Returns a formatted message of the exception following the pattern.
   * <code>`argument`: error</code>
   * @return The message
   */
  public String getMessage() {
    return String.format("`%s`: %s", this.argument, super.getMessage());
  } // getMessage
} // class ArgumentException
