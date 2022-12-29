package org.example.command;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SellPneuCommand extends CommandBase {

    public SellPneuCommand(Command next) {
        super.setNext(next);
    }

    @Override
    public String getCode() {
        return "1";
    }

    @Override
    public void execute() {
        System.out.println("Execution de SellPneuCommand....");
    }

    @Override
    public Command getNext() {
        return super.getNext();
    }
}
