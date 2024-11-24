package org.example.command;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import lombok.NoArgsConstructor;
import org.example.cli.Shell;
import org.example.models.pneus.Pneu;

@NoArgsConstructor
public class SellPneuCommand extends CommandBase {

  public Shell shell;

  public SellPneuCommand(Command next) throws FileNotFoundException {
    super.setNext(next);
  }

  @Override
  public String getCode() {
    return "1";
  }

  @Override
  public void execute() throws IOException {
    this.setDisableNext(false);
    String currentUserInput;
    boolean canContinue = true;
    try {
      while (canContinue) {

        System.out.print("Veuillez entrer le type de pneu : ");

        currentUserInput = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (currentUserInput == null) {
          canContinue = false;
          System.out.println("Une erreur est survenue : Retour au menu précédent...");
        } else if (currentUserInput.equals("q")) {
          System.out.println("Retour au menu précédent...");
          this.setDisableNext(true);
          return;
        } else {
          boolean matchingPattern = Pattern.compile("[0-9]{3}/[0-9]{2}[R|B]/[0-9]{2}[A-Z]")
              .matcher(currentUserInput).matches();
          if (!matchingPattern) {
            System.out.println(
                "Format Invalide, format recommandé : NNN(largeur)/NN(rapport)T(type)/NN(diametre)S(saison)");
          } else {
            Pneu pneuVendu = Pneu.fromUserInput(currentUserInput);
            System.out.println("Pneu vendu : " + pneuVendu);
            // TODO: Add item to cart
            canContinue = false;
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
