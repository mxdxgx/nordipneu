package org.example.command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CommandTest {

  @Test
  void testDefaultMethods() {
    Command command = new Command() {
      @Override
      public String getCode() {
        return null;
      }

      @Override
      public void execute() {
      }

      @Override
      public Command getNext() {
        return null;
      }

      @Override
      public boolean hasNext() {
        return false;
      }
    };
    assertNull(command.getNext());
    assertFalse(command.hasNext());
  }
}