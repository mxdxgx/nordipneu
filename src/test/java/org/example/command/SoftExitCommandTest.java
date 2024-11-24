package org.example.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SoftExitCommandTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outContent));
  }

  @Test
  void testGetCode() {
    SoftExitCommand command = new SoftExitCommand();
    assertEquals("0", command.getCode());
  }

  @Test
  void testExecute() {
    SoftExitCommand command = new SoftExitCommand();
    command.execute();
    assertEquals("Retour au menu précédent...\n", outContent.toString());
  }

  @Test
  void testGetNext() {
    SoftExitCommand command = new SoftExitCommand();
    assertNull(command.getNext());
  }

  @Test
  void testHasNext() {
    SoftExitCommand command = new SoftExitCommand();
    assertFalse(command.hasNext());
  }
}