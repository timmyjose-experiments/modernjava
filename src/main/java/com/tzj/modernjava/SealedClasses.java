package com.tzj.modernjava;

public class SealedClasses {
  public static void main(String[] args) {
    celestialDemo();
    exprDemo();
  }

  private static void exprDemo() {
    Expr expr =
        new DivExpr(
            new MulExpr(
                new AddExpr(new ConstExpr(10), new SubExpr(new ConstExpr(5), new ConstExpr(2))),
                new ConstExpr(2)),
            new AddExpr(new ConstExpr(10), new ConstExpr(3)));
    System.out.printf("%d\n", expr.eval());
    System.out.printf("%d\n", eval(expr));
  }

  private static int eval(Expr expr) {
    return switch (expr) {
      case ConstExpr c -> c.eval();
      case AddExpr add -> add.lhs().eval() + add.rhs().eval();
      case SubExpr sub -> sub.lhs().eval() - sub.rhs().eval();
      case MulExpr mul -> mul.lhs().eval() * mul.rhs().eval();
      case DivExpr div -> div.lhs().eval() / div.rhs().eval();
    };
  }

  // private static int eval(Expr expr) {
  //      return switch (expr) {
  //        case ConstExpr(int n) -> n;
  //        case AddExpr(Expr lhs, Expr rhs) -> eval(lhs) + eval( rhs);
  //        case SubExpr(Expr lhs, Expr rhs) -> eval(lhs) - eval( rhs);
  //        case MulExpr(Expr lhs, Expr rhs) -> eval(lhs) * eval( rhs);
  //        case DivExpr(Expr lhs, Expr rhs) -> eval(lhs) / eval( rhs);
  //      };
  // }

  private static void celestialDemo() {
    Celestial celestial = new Comet();

    switch (celestial) {
      case Planet p -> System.out.println("Got a planet");
      case Star s -> System.out.println("Got a star");
      case Comet c -> System.out.println("Got a comet");
    }
  }
}

sealed interface Celestial permits Planet, Star, Comet {}

final class Planet implements Celestial {}

final class Star implements Celestial {}

final class Comet implements Celestial {}

sealed interface Expr permits ConstExpr, AddExpr, SubExpr, MulExpr, DivExpr {
  int eval();
}

record ConstExpr(int val) implements Expr {
  @Override
  public int eval() {
    return this.val;
  }
}

record AddExpr(Expr lhs, Expr rhs) implements Expr {
  @Override
  public int eval() {
    return lhs.eval() + rhs.eval();
  }
}

record SubExpr(Expr lhs, Expr rhs) implements Expr {
  @Override
  public int eval() {
    return lhs.eval() - rhs.eval();
  }
}

record MulExpr(Expr lhs, Expr rhs) implements Expr {
  @Override
  public int eval() {
    return lhs.eval() * rhs.eval();
  }
}

record DivExpr(Expr lhs, Expr rhs) implements Expr {
  @Override
  public int eval() {
    return lhs.eval() / rhs.eval();
  }
}