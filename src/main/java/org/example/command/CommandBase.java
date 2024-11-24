package org.example.command;

import java.io.IOException;
import lombok.Setter;

public class CommandBase implements Command {

  @Setter
  private Command next;

  @Override
  public String getCode() {
    return null;
  }

  @Override
  public void execute() throws IOException {

  }

  @Override
  public Command getNext() {
    return this.next;
  }

  @Override
  public boolean hasNext() {
    return this.next != null;
  }

}
