package com.urm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * To extends in future
 */
public class StandardApplicationContext {

  protected static final Logger LOGGER = LoggerFactory.getLogger(StandardApplicationContext.class);

  private static Map<String,Object> three_second_map = new ConcurrentHashMap<>();

  private int role = Constants.ROLE_ARBIT;

  /*
   * This member variable is used to record reconnection times ,only client/server thread can use it,
   * So you don't have to consider concurrency problem.
   */
  private int reconnect_counts = 0;

  /**
   * singleton private constructor
   */
  private StandardApplicationContext() {

  }

  private static class ContextHolder {
    private static StandardApplicationContext context = new StandardApplicationContext();
  }

  public static StandardApplicationContext getInstance() {
    return ContextHolder.context;
  }

  public int getReconnectCounts() {
    return reconnect_counts;
  }

  public void setReconnectCounts(int reconnect_counts) {
    this.reconnect_counts = reconnect_counts;
  }

  public int getRole() {
    return role;
  }

  public void setRole(int role) {
    this.role = role;
  }
}
