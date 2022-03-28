package com.tzj.modulesystem.client;

import com.tzj.modulesystem.server.HelloInterface;
import java.util.ServiceLoader;

public class HelloClient {
  public static void main(String[] args) {
    Iterable<HelloInterface> services = ServiceLoader.load(HelloInterface.class);
    HelloInterface service = services.iterator().next();
    service.sayHello(args[0]);
  }
}