package org.example.command;

import java.io.IOException;

public interface Command {
    Command next = null;

    String getCode();

    void execute() throws IOException;

    Command getNext();

    boolean hasNext();
}
