package com.tzj.modernjava;

public class Records {
  public static void main(String[] args) {
    var p1 = new Point(100, 200);
    var p2 = new Point(100, -200);
    var p3 = new Point(100, 200);

    System.out.printf("%s == %s? %b\n", p1, p2, p1.equals(p2));
    System.out.printf("%s == %s? %b\n", p1, p3, p1.equals(p3));
    System.out.printf("%s == %s? %b\n", p2, p3, p2.equals(p3));

    var r1 = new Rational(2, 4);
    System.out.printf("r1 = %s\n", r1);

    var r2 = new Rational(4, 12);
    System.out.printf("r2 = %s\n", r2);

    System.out.printf("%s + %s = %s\n", r1, r2, r1.add(r2));
    System.out.printf("%s - %s = %s\n", r1, r2, r1.sub(r2));
    System.out.printf("%s * %s = %s\n", r1, r2, r1.mul(r2));
    System.out.printf("%s / %s = %s\n", r1, r2, r1.div(r2));
  }
}

record Point(int x, int y) {}

record Rational(int num, int denom) {
  Rational {
    int gcd = gcd(num, denom);
    num /= gcd;
    denom /= gcd;
  }

  int gcd(int n, int m) {
    if (m == 0) {
      return n;
    }
    return gcd(m, n % m);
  }

  Rational add(Rational other) {
    int num = this.num * other.denom + this.denom * other.num;
    int denom = this.denom * other.denom;
    return new Rational(num, denom);
  }

  Rational sub(Rational other) {
    int num = this.num * other.denom - this.denom * other.num;
    int denom = this.denom * other.denom;
    return new Rational(num, denom);
  }

  Rational mul(Rational other) {
    int num = this.num * other.num;
    int denom = this.denom * other.denom;
    return new Rational(num, denom);
  }

  Rational div(Rational other) {
    int num = this.num * other.denom;
    int denom = this.denom * other.num;
    return new Rational(num, denom);
  }
}