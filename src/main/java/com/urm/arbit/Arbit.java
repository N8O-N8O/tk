package com.urm.arbit;

import java.util.concurrent.TimeUnit;

@FunctionalInterface
public interface Arbit<V> {

  //TODO do arbit ,if no reply --> system.out
  //               if let me out --> system.out
  //               if let me to be single --> change my role single refresh context;
  //
  V initiationArbitration(Long time, TimeUnit milliseconds,int role);

}
