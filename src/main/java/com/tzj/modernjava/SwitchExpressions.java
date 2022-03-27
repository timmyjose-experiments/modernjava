package com.tzj.modernjava;

public class SwitchExpressions {
  public static void main(String[] args) {
    noFallthroughDemo();
    System.out.printf("%s\n", howMany(0));
    System.out.printf("%s\n", howMany(1));
    System.out.printf("%s\n", howMany(2));
    System.out.printf("%s\n", howMany(12));

    var s = "foo";
    int result =
        switch (s) {
          case "bar" -> 1; // no yield needed in switch expressions
          case "foo" -> 2;
          default -> 100;
        };

    System.out.printf("%d\n", result);

    result =
        switch (s) {
          case "bar":
            yield 1; // needed for switch statements yielding values
          case "foo":
            yield 2;
          default:
            yield 100;
        };

    System.out.printf("%d\n", result);
  }

  static void noFallthroughDemo() {
    var day = Weekday.WEDNESDAY;

    switch (day) {
      case SATURDAY, SUNDAY -> System.out.println("Got a weekday");
      case MONDAY, TUESDAY, WEDNESDAY -> System.out.println("Got the first half of the week");
      case THURSDAY, FRIDAY -> System.out.println("Got the second half of the week");
    }
  }

  static String howMany(int n) {
    return switch (n) {
      case 0 -> "zero";
      case 1 -> "one";
      case 2 -> "two";
      default -> "many";
    };
  }
}

enum Weekday {
  SUNDAY,
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY
}
