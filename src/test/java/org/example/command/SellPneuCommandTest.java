package org.example.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SellPneuCommandTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outContent));
  }

  @Test
  void testExecuteValidInput() throws IOException {
    ByteArrayInputStream validInContent = new ByteArrayInputStream("205/55R/16H\n".getBytes());
    System.setIn(validInContent);
    SellPneuCommand command = new SellPneuCommand();
    command.execute();
    assertTrue(outContent.toString().contains("Pneu vendu :"));
  }

  @Test
  void testGetCode() {
    SellPneuCommand command = new SellPneuCommand();
    assertEquals("1", command.getCode());
  }

  @Test
  void testExecuteInvalidInput() throws IOException {
    ByteArrayInputStream invalidInContent = new ByteArrayInputStream("invalid\nq\n".getBytes());
    System.setIn(invalidInContent);
    SellPneuCommand command = new SellPneuCommand();
    command.execute();
    assertTrue(
        outContent.toString().contains("Une erreur est survenue : Retour au menu précédent..."));
  }

  @Test
  void testExecuteQuit() throws IOException {
    ByteArrayInputStream quitInContent = new ByteArrayInputStream("q\n".getBytes());
    System.setIn(quitInContent);
    SellPneuCommand command = new SellPneuCommand();
    command.execute();
    assertTrue(outContent.toString().contains("Retour au menu précédent..."));
  }

  @Test
  void testGetNext() {
    SellPneuCommand command = new SellPneuCommand();
    assertNull(command.getNext());
  }
}