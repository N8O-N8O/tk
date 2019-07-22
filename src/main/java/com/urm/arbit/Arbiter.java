package com.urm.arbit;

import static com.urm.Constants.ROLE_MASTER;
import static com.urm.Constants.ROLE_SLAVE;

import java.util.ArrayList;
import java.util.List;

public class Arbiter implements Observable {

  List<Listener> listeners = new ArrayList<>();

  void addListener(Listener listener) {
    listeners.add(listener);
  }

  public void arbitMasterOffline() {
    listeners.forEach(listener -> {
      if (ROLE_MASTER == listener.getRole()) {
        listener.offline();
      } else {
        listener.switch2Single();
      }
    });
  }

  public void arbitSlaveOffline() {
    listeners.forEach(listener -> {
      if (ROLE_SLAVE == listener.getRole()) {
        listener.switch2Single();
      } else {
        listener.offline();
      }
    });
  }


  @Override
  public Observable register(Listener listener) {
    this.listeners.add(listener);
    return this;
  }

  @Override
  public Observable clear() {
    this.listeners.clear();
    return this;
  }

}
