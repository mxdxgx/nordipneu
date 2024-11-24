package org.example.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatisticVenteCommandTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outContent));
  }

  @Test
  void testGetCode() {
    StatisticVenteCommand command = new StatisticVenteCommand();
    assertEquals("4", command.getCode());
  }

  @Test
  void testExecute() {
    StatisticVenteCommand command = new StatisticVenteCommand();
    command.execute();
    assertEquals("Execution de StatisticVenteCommand....\n", outContent.toString());
  }

  @Test
  void testGetNext() {
    StatisticVenteCommand command = new StatisticVenteCommand();
    assertNull(command.getNext());
  }

  @Test
  void testHasNext() {
    StatisticVenteCommand command = new StatisticVenteCommand();
    assertFalse(command.hasNext());
  }
}