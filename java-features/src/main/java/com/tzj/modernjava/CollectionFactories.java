package com.tzj.modernjava;

import static java.util.Map.entry;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFactories {
  public static void main(String[] args) {
    Set<String> set = Set.of("hello", "world");
    System.out.println(set);

    Map<String, Integer> m =
        Map.ofEntries(
            entry("hello", 5),
            entry("world", 5),
            entry("we", 2),
            entry("meet", 4),
            entry("again", 5));
    System.out.println(m);

    List<Double> l = List.of(1.2, -2.3, 3.4, -4.5, 5.6, -109.122);
    System.out.println(l);
  }
}