package datastructures.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {

  @Test
  void constructor() {
    HashMap<Integer, Integer> sut = new HashMap<>();
    assertEquals(sut.size, 10);
  }

  @Test
  void set_single() {
    HashMap<Integer, Integer> sut = new HashMap<>();
    sut.set(111, 50);
    assertEquals(sut.get(111), 50);
  }

  @Test
  void set_multiple() {
    HashMap<Integer, Integer> sut = new HashMap<>();
    sut.set(111, 50);
    sut.set(25, -1);
    assertEquals(sut.get(111), 50);
    assertEquals(sut.get(25), -1);
  }

  @Test
  void set_overwrite() {
    HashMap<Integer, Integer> sut = new HashMap<>();
    sut.set(111, 50);
    sut.set(111, -1);
    assertEquals(sut.get(111), -1);
  }

  @Test
  void contains_single() {
    HashMap<String, Integer> sut = new HashMap<>();
    sut.set("potato", 50);
    assertTrue(sut.contains("potato"));
    assertFalse(sut.contains("carrot"));
  }

  @Test
  void keys_simple() {
    HashMap<String, Integer> sut = new HashMap<>();
    sut.set("potato", 50);
    sut.set("carrot", 112);
    sut.set("onion", 99);
    System.out.println(sut.keys());
  }
}
