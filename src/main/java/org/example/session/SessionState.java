package org.example.session;

import java.util.List;
import org.example.models.pneus.Pneu;

public class SessionState {

  private static SessionState INSTANCE;
  private List<Pneu> pneus;

  public static SessionState getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new SessionState();
    }
    return INSTANCE;
  }
}
