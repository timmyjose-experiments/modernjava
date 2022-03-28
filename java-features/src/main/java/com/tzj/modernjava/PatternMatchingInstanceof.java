package com.tzj.modernjava;

public class PatternMatchingInstanceof {
  public static void main(String[] args) {
    Object foo = new Foo();

    if (foo instanceof Foo f) {
      System.out.println("Got a foo");
    }

    foo = null;
    if (foo instanceof String s) {
      System.out.println("Got a String");
    }
  }
}

class Foo {}