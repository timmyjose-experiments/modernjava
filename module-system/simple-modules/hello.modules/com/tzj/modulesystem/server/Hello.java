package com.tzj.modulesystem.server;

public class Hello implements HelloInterface {
  @Override
  public void sayHello(String name) {
    System.out.printf("Hello, %s\n", name);
  }
}