package org.example.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CommandBaseTest {

  @Test
  void testSetNext() {
    CommandBase command = new CommandBase() {
      @Override
      public String getCode() {
        return null;
      }

      @Override
      public void execute() {
      }
    };
    CommandBase nextCommand = new CommandBase() {
      @Override
      public String getCode() {
        return null;
      }

      @Override
      public void execute() {
      }
    };
    command.setNext(nextCommand);
    assertEquals(nextCommand, command.getNext());
  }
}