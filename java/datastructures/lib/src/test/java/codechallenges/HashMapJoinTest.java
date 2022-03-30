package codechallenges;

import datastructures.hashtable.HashMap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapJoinTest {

  @Test
  void example() {
    HashMapChallenges sut = new HashMapChallenges();
    HashMap<String, String> left = new HashMap<>();
    HashMap<String, String> right = new HashMap<>();
    left.set("diligent", "employed");
    left.set("fond", "enamored");
    left.set("guide", "usher");
    left.set("outfit", "garb");
    left.set("wrath", "anger");
    right.set("diligent", "idle");
    right.set("fond", "averse");
    right.set("guide", "follow");
    right.set("flow", "jam");
    right.set("wrath", "delight");
    assertEquals(sut.joinHashMapPair(left, right).toString(), "[[diligent, employed, idle], [wrath, anger, delight], [fond, enamored, averse], [guide, usher, follow], [outfit, garb, null]]");
  }

  @Test
  void example_right_join() {
    HashMapChallenges sut = new HashMapChallenges();
    HashMap<String, String> left = new HashMap<>();
    HashMap<String, String> right = new HashMap<>();
    left.set("diligent", "employed");
    left.set("fond", "enamored");
    left.set("guide", "usher");
    left.set("outfit", "garb");
    left.set("wrath", "anger");
    right.set("diligent", "idle");
    right.set("fond", "averse");
    right.set("guide", "follow");
    right.set("flow", "jam");
    right.set("wrath", "delight");
    assertEquals(sut.joinHashMapPair(left, right, true).toString(), "[[diligent, idle, employed], [flow, jam, null], [wrath, delight, anger], [fond, averse, enamored], [guide, follow, usher]]");
  }

  @Test
  void white_board_example() {
    HashMapChallenges sut = new HashMapChallenges();
    HashMap<String, String> left = new HashMap<>();
    HashMap<String, String> right = new HashMap<>();
    left.set("apple", "A");
    left.set("banana", "B");
    left.set("cat", "C");
    left.set("elephant", "E");
    left.set("fox", "F");
    left.set("house", "H");
    left.set("ice", "I");
    right.set("apple", "a");
    right.set("banana", "b");
    right.set("dog", "d");
    right.set("elephant", "e");
    right.set("fox", "f");
    right.set("grandma", "g");
    right.set("ice", "i");
    assertEquals(sut.joinHashMapPair(left, right).toString(), "[[apple, A, a], [elephant, E, e], [cat, C, null], [fox, F, f], [ice, I, i], [banana, B, b], [house, H, null]]");
  }

  @Test
  void white_board_example_right_join() {
    HashMapChallenges sut = new HashMapChallenges();
    HashMap<String, String> left = new HashMap<>();
    HashMap<String, String> right = new HashMap<>();
    left.set("apple", "A");
    left.set("banana", "B");
    left.set("cat", "C");
    left.set("elephant", "E");
    left.set("fox", "F");
    left.set("house", "H");
    left.set("ice", "I");
    right.set("apple", "a");
    right.set("banana", "b");
    right.set("dog", "d");
    right.set("elephant", "e");
    right.set("fox", "f");
    right.set("grandma", "g");
    right.set("ice", "i");
    assertEquals(sut.joinHashMapPair(left, right, true).toString(), "[[apple, a, A], [elephant, e, E], [fox, f, F], [dog, d, null], [ice, i, I], [banana, b, B], [grandma, g, null]]");
  }

  @Test
  void no_matches() {
    HashMapChallenges sut = new HashMapChallenges();
    HashMap<String, String> left = new HashMap<>();
    HashMap<String, String> right = new HashMap<>();
    left.set("apple", "A");
    left.set("banana", "B");
    left.set("cat", "C");
    left.set("elephant", "E");
    right.set("dog", "d");
    right.set("fox", "f");
    right.set("grandma", "g");
    right.set("ice", "i");
    assertEquals(sut.joinHashMapPair(left, right).toString(), "[[apple, A, null], [elephant, E, null], [cat, C, null], [banana, B, null]]");
  }

  @Test
  void left_empty() {
    HashMapChallenges sut = new HashMapChallenges();
    HashMap<String, String> left = new HashMap<>();
    HashMap<String, String> right = new HashMap<>();
    right.set("dog", "d");
    right.set("fox", "f");
    right.set("grandma", "g");
    right.set("ice", "i");
    assertEquals(sut.joinHashMapPair(left, right).toString(), "[]");
  }


  @Test
  void right_empty() {
    HashMapChallenges sut = new HashMapChallenges();
    HashMap<String, String> left = new HashMap<>();
    HashMap<String, String> right = new HashMap<>();
    left.set("apple", "A");
    left.set("banana", "B");
    left.set("cat", "C");
    left.set("elephant", "E");
    assertEquals(sut.joinHashMapPair(left, right).toString(), "[[apple, A, null], [elephant, E, null], [cat, C, null], [banana, B, null]]");
  }


}
