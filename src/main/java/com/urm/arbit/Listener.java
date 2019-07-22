package com.urm.arbit;

public interface Listener {

  int getRole();

  Listener setRole(int role);

  Listener offline();

  Listener switch2Single();

}
