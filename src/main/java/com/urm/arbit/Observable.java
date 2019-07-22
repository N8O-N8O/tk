package com.urm.arbit;

public interface Observable {

  Observable register(Listener listener);

  Observable clear();

}
