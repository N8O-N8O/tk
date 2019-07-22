package com.urm.arbit;

import static com.urm.Constants.ROLE_MASTER;
import static com.urm.Constants.ROLE_SLAVE;

public abstract class AbstractListener implements Listener {

  private int role = ROLE_MASTER;

  @Override
  public int getRole() {
    return role;
  }

  @Override
  public Listener setRole(int role) {
    this.role = role;
    return this;
  }

  @Override
  public Listener offline() {
    if (ROLE_MASTER == this.role) {
      sendMasterOfflineCommand();
    } else if (ROLE_SLAVE == this.role) {
      sendSlaveOfflineCommand();
    }
    return this;
  }

  protected abstract void sendSlaveOfflineCommand();

  protected abstract void sendMasterOfflineCommand();

  @Override
  public Listener switch2Single() {
    if (ROLE_MASTER == this.role) {
      sendMasterSwitch2SingleCommand();
    } else if (ROLE_SLAVE == this.role) {
      sendSlaveSwitch2SingleCommand();
    }
    return this;
  }

  protected abstract void sendSlaveSwitch2SingleCommand();

  protected abstract void sendMasterSwitch2SingleCommand();
}
