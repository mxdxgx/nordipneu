package org.example.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class InventairePneuCommandTest {

  @Test
  void testGetCode() {
    InventairePneuCommand command = new InventairePneuCommand();
    assertEquals("6", command.getCode());
  }

  @Test
  void testExecute() {
    InventairePneuCommand command = new InventairePneuCommand();
    // Capture the console output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    command.execute();
    assertEquals("Execution de InventairePneuCommand....\n", outContent.toString());
  }

  @Test
  void testGetNext() {
    InventairePneuCommand command = new InventairePneuCommand();
    assertNull(command.getNext());
  }

  @Test
  void testHasNext() {
    InventairePneuCommand command = new InventairePneuCommand();
    assertFalse(command.hasNext());
  }
}