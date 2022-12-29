package org.example.command;

public interface Command {
    public Command next = null;

    String getCode();

    void execute();

    Command getNext();

    boolean hasNext();
}
