package datastructures.hashtable;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {

  @Test
  void constructor() {
    HashMap<Integer, Integer> sut = new HashMap<>();
    assertEquals(sut.capacity, 10);
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
    sut.set(40, 200);
    assertEquals(sut.get(111), 50);
    assertEquals(sut.get(25), -1);
    assertEquals(sut.get(40), 200);
  }

  @Test
  void set_overwrite() {
    HashMap<Integer, Integer> sut = new HashMap<>();
    sut.set(111, 50);
    sut.set(111, -1);
    assertEquals(sut.get(111), -1);
  }

  @Test
  void set_get_overwrite_multiple() {
    HashMap<Integer, Integer> sut = new HashMap<>();
    sut.set(111, 50);
    sut.set(0, 10);
    sut.set(55, 10);
    assertEquals(sut.get(111), 50);
    assertEquals(sut.get(0), 10);
    assertEquals(sut.get(55), 10);
    sut.set(111, -1);
    sut.set(0, -1100);
    sut.set(55, 500);
    assertEquals(sut.get(111), -1);
    assertEquals(sut.get(0), -1100);
    assertEquals(sut.get(55), 500);
    sut.set(111, -1);
    assertEquals(sut.get(111), -1);
    sut.set(111, 100);
    sut.set(0, 5);
    assertEquals(sut.get(111), 100);
    assertEquals(sut.get(0), 5);
  }

  @Test
  void get_null() {
    HashMap<String, Integer> sut = new HashMap<>();
    sut.set("potato", 1);
    assertNull(sut.get("onion"));
  }

  @Test
  void contains_single() {
    HashMap<String, Integer> sut = new HashMap<>();
    sut.set("potato", 50);
    assertTrue(sut.contains("potato"));
    assertFalse(sut.contains("carrot"));
  }

  @Test
  void contains_keys() {
    HashMap<String, Integer> sut = new HashMap<>();
    sut.set("potato", 50);
    sut.set("carrot", 112);
    sut.set("onion", 99);
    List<String> list = sut.keys();
    assertTrue(list.contains("onion"));
    assertTrue(list.contains("carrot"));
    assertTrue(list.contains("potato"));
  }

  @Test
  void keys_simple() {
    HashMap<String, Integer> sut = new HashMap<>();
    sut.set("potato", 50);
    sut.set("carrot", 112);
    sut.set("onion", 99);
    assertEquals(sut.keys().size(), 3);
  }


  @Test
  void expand_once() {
    HashMap<String, Integer> sut = new HashMap<>();
    sut.set("potato", 50);
    sut.set("carrot", 112);
    sut.set("onion", 33);
    sut.set("celery", 41);
    sut.set("lettuce", 29);
    sut.set("broccoli", 61);
    sut.set("cucumber", 79);
    sut.set("radish", 49);
    sut.set("spinach", 93);
    sut.set("beans", 11);
    sut.set("cabbage", 51);
    sut.set("chard", 22);
    assertEquals(sut.size(), 12);
  }

  @Test
  void expand_many() {
    HashMap<String, Integer> sut = new HashMap<>();
    int expand = 10;
    for(int i = 1; i <= 100000; i++) {
      sut.set(Integer.toString(i), i);
      if (i % expand == 0) {
        expand *= 2;
        assertEquals(sut.size(), i);
      }
    }
  }

  // default size is 10 so 3 values go in index 0, and 3 go into index 1
  @Test
  void collisions() {
    HashMap<Integer, Integer> sut = new HashMap<>();
    sut.set(0, 1);
    sut.set(10, 2);
    sut.set(20, 3);
    sut.set(1, 50);
    sut.set(11, 55);
    sut.set(21, 60);
  }

  @Test
  void collision_retrieval() {
    HashMap<Integer, Integer> sut = new HashMap<>();
    sut.set(0, 1);
    sut.set(10, 2);
    sut.set(20, 3);
    sut.set(1, 50);
    sut.set(11, 55);
    sut.set(21, 60);
    assertEquals(sut.get(0), 1);
    assertEquals(sut.get(10), 2);
    assertEquals(sut.get(20), 3);
    assertEquals(sut.get(1), 50);
    assertEquals(sut.get(11), 55);
    assertEquals(sut.get(21), 60);
  }

  @Test
    void hash_in_range() {
    HashMap<String, Integer> sut = new HashMap<>();
    sut.set("potato", 1);
    assertTrue(sut.hash("potato") <= sut.capacity);
  }
}
