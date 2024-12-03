package org.example.cli.resources.printer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserPrinterTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  void tearDown() {
    System.setOut(originalOut);
  }

  @Test
  void testPrintBanner() throws IOException {
    UserPrinter userPrinter = new UserPrinter();
    userPrinter.printBanner();
    String output = outContent.toString();
    assertTrue(output.contains(" _ _              _  _         ___\n"
        + "| \\ | ___  _ _  _| |<_>  ___  | . \\._ _  ___  _ _\n"
        + "|   |/ . \\| '_>/ . || | |___| |  _/| ' |/ ._>| | |\n"
        + "|_\\_|\\___/|_|  \\___||_|       |_|  |_|_|\\___.`___|\n"));
  }

  @Test
  void testPrintMenu() throws IOException {
    UserPrinter userPrinter = new UserPrinter();
    userPrinter.printMenu();
    String output = outContent.toString();
    assertTrue(output.contains("0 - Quittez"));
  }

  @Test
  void testPrintUserError() throws FileNotFoundException {
    UserPrinter userPrinter = new UserPrinter();
    userPrinter.printUserError();
    String output = outContent.toString();
    assertEquals("Erreur : ce choix n'est pas valide.\n", output);
  }

  @Test
  void testCustomFilePaths() throws FileNotFoundException {
    UserPrinter userPrinter = new UserPrinter("src/test/java/org/example/cli/resources/menu.txt",
        "src/test/java/org/example/cli/resources/banner.txt");
    assertNotNull(userPrinter);
  }
}