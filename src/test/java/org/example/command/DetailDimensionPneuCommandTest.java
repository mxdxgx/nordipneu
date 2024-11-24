package org.example.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class DetailDimensionPneuCommandTest {

  @Test
  void testGetCode() {
    DetailDimensionPneuCommand command = new DetailDimensionPneuCommand();
    assertEquals("5", command.getCode());
  }

  @Test
  void testExecute() {
    DetailDimensionPneuCommand command = new DetailDimensionPneuCommand();
    // Capture the console output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    command.execute();
    assertEquals("Execution de DetailDimensionPneuCommand....\n", outContent.toString());
  }

  @Test
  void testGetNext() {
    DetailDimensionPneuCommand command = new DetailDimensionPneuCommand();
    assertNull(command.getNext());
  }

  @Test
  void testHasNext() {
    DetailDimensionPneuCommand command = new DetailDimensionPneuCommand();
    assertFalse(command.hasNext());
  }
}