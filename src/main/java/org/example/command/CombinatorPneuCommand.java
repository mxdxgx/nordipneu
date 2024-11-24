package org.example.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CombinatorPneuCommand extends CommandBase {

  public CombinatorPneuCommand(Command next) {
    super.setNext(next);
  }

  @Override
  public void execute() throws IOException {
    String currentUserInput;
    boolean canContinue = true;

    try {
      while (canContinue) {
        System.out.print("Veuillez entrer le nombre de pneus (1-4) : ");
        currentUserInput = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (currentUserInput.equals("q")) {
          System.out.println("Retour au menu précédent...");
          return;
        } else {
          int numberOfPneus = Integer.parseInt(currentUserInput);
          if (numberOfPneus < 1 || numberOfPneus > 4) {
            System.out.println("Nombre de pneus invalide, veuillez entrer un nombre entre 1 et 4");
          } else {
            System.out.println("Nombre de pneus : " + numberOfPneus);
            // TODO: Add number of pneus to cart
            return;
          }
        }
      }

    } catch (IOException exception) {
      throw exception;
    }
  }

  @Override
  public Command getNext() {
    return super.getNext();
  }

}
