package org.example.command;

import java.io.IOException;
import lombok.Getter;
import lombok.Setter;

public class CommandBase implements Command {

  @Getter
  @Setter
  private boolean disableNext = false;
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
