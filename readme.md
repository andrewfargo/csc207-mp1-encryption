# Mini-project 1: Classical Encryption

Drew Fargo

A project for CSC207 2024Fa.

## Usage

This program performs one of two provided shift ciphers on provided text.
There are two actions that the cipher can do:

1. Encode text
2. Decode text

There are two ciphers that the program can use:

1. Caesar Cipher (shift the text by one character)
2. Vigenere Cipher (shift the text by a modulating keyphrase)

The default usage of the JAR file is to perform these operations via command line arguments,
in which case the usage is as follows:

```
java -jar JARFILE (-encode|-decode) (-caesar|-vigenere) CIPHERTEXT KEY
```

Note: if using a Caesar cipher, the key must be only one character.

The program also has an alternate usage, AllCaesar. The usage of AllCaesar is as follows:

```
java edu.grinnell.csc207.main.AllCaesar (encode|decode) CIPHERTEXT
```

No key is provided, as the program will list every possible key character and output the result.

## Implementation Notes

I implemented the ciphers as extended classes of a generic shift cipher class.
This was partially a self-imposed challenge, and partially a legitimate attempt to
remove duplicated code through polymorphism.
Ideally, some of the methods from CipherUtils would be moved into this class,
but that would break unit tests provided.

## Citations

- Referenced W3Schools for certain Java syntax.
  - Switch Statements
  - ArrayList
  - Exceptions
  - Inheritance
- Referenced Oracle Java 17 Documentation for certain classes.
  - Strings
  - ArrayList
  - Exceptions
  
<https://github.com/andrewfargo/csc207-mp1-encryption>
