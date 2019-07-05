package com.urm;

public interface Constants {



  String APP_ROLE = "app.role";
  int ROLE_MASTER = 0;
  int ROLE_SLAVE = 1;
  int ROLE_SINGLE = 2;
  int ROLE_ARBIT = 3;

  int MAX_RECONNECT_TIMES = 3;
  int MAX_HEARTBEAT_TIMES = 10;

  String API_ID ="api.id";

  String MQ_TYPE = "mq.type";
  String MQ_SUBLIST = "mq.sublist";
  int SERVICE_PRIVILEGE_Read = 0;// 监听权限
  int SERVICE_PRIVILEGE_Write = 1;// 发送数据权限
  int SERVICE_PRIVILEGE_ALL = 2;// 监听权限+发送数据权限

  String MQ_TYPE_ACTIVE = "activemq";

  String ACTIVEMQ_USERNAME = "activemq.username";
  String ACTIVEMQ_PASSWORD = "activemq.password";
  String ACTIVEMQ_BROKER_ADDRESS = "activemq.broker.address";


}
