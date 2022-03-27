package com.tzj.modernjava;

public class PatternMatchingForSwitch {
  public static void main(String[] args) {
    System.out.println(formattedString(10));
    System.out.println(formattedString(10L));
    System.out.println(formattedString(10.0));
    System.out.println(formattedString(10.0f));
    System.out.println(formattedString("hello"));
    System.out.println(formattedString(true));

    var bob = new Person("Bob", 21);
    System.out.println(formattedString(bob));

    testShape();
  }

  static String formattedString(Object o) {
    return switch (o) {
      case Boolean b -> String.format("bool %b", b);
      case Integer i -> String.format("int %d", i);
      case Long l -> String.format("long %d", l);
      case Float f -> String.format("float %f", f);
      case Double d -> String.format("double %f", d);
      case String s -> String.format("string %s", s);
      case Person p -> p.toString();
      default -> "Unknown value";
    };
  }

  static void testShape() {
    var circle = new Circle(10.01);
    testCircle(circle);
    testCircle(null);

    var rectangle = new Rectangle(12, 13.23);
    testRectangle(rectangle);
  }

  static void testCircle(Shape s) {
    switch (s) {
      case null -> System.out.println("Got a null");
      case Circle c && (c.area() < 100.0) -> 
        System.out.println("Small triangle");
      case Circle c ->
        System.out.println("Large triangle");
      default ->
        System.out.println("Not a triangle");
    }
  }

  static void testRectangle(Shape s) {
    switch (s) {
      case Rectangle r -> System.out.println(r.perimeter());
      default -> System.out.println("Not a rectangle");
    }
  }
}

record Person(String name, int age) {}

sealed interface Shape permits Circle, Rectangle {
  double area();

  double perimeter();
}

record Circle(double radius) implements Shape {
  @Override
  public double area() {
    return Math.PI * radius * radius;
  }

  @Override
  public double perimeter() {
    return 2.0 * Math.PI * radius;
  }
}

record Rectangle(double length, double width) implements Shape {
  @Override
  public double area() {
    return length * width;
  }

  @Override
  public double perimeter() {
    return 2.0 * (length + width);
  }
}
