package codechallenges;

import codechallenges.animalshelter.Animal;
import codechallenges.animalshelter.AnimalShelter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalShelterTest {

  @Test
  void test_constructor() {
    AnimalShelter sut = new AnimalShelter();
    assertNotNull(sut);
  }

  @Test
  void test_enqueue_single() {
    AnimalShelter sut = new AnimalShelter();
    sut.enqueue(new Animal("dog"));
    assertEquals(sut.size(), 1);
  }

  @Test
  void test_enqueue_multiple() {
    AnimalShelter sut = new AnimalShelter();
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("cat"));
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("dog"));
    assertEquals(sut.size(), 7);
  }

  @Test
  void test_getsize() {
    AnimalShelter sut = new AnimalShelter();
    assertEquals(sut.size(), 0);
    sut.enqueue(new Animal("pig"));
    assertEquals(sut.size(), 1);
  }

  @Test
  void test_dequeue_single_at_front() {
    AnimalShelter sut = new AnimalShelter();
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("cat"));
    sut.enqueue(new Animal("cat"));
    sut.enqueue(new Animal("cat"));
    assertEquals(sut.size(), 4);
    assertEquals(sut.dequeue("dog").getSpecies(), "dog");
    assertEquals(sut.size(), 3);
  }

  @Test
  void test_dequeue_single_at_back() {
    AnimalShelter sut = new AnimalShelter();
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("cat"));
    assertEquals(sut.size(), 4);
    assertEquals(sut.dequeue("cat").getSpecies(), "cat");
    assertEquals(sut.size(), 3);
  }

  @Test
  void test_dequeue_multiple_linear() {
    AnimalShelter sut = new AnimalShelter();
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("cat"));
    sut.enqueue(new Animal("cat"));
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("cat"));
    assertEquals(sut.dequeue("cat").getSpecies(), "cat");
    assertEquals(sut.dequeue("dog").getSpecies(), "dog");
    assertEquals(sut.dequeue("dog").getSpecies(), "dog");
    assertEquals(sut.dequeue("cat").getSpecies(), "cat");
    assertEquals(sut.dequeue("cat").getSpecies(), "cat");
    assertEquals(sut.dequeue("dog").getSpecies(), "dog");
    assertEquals(sut.dequeue("dog").getSpecies(), "dog");
    assertEquals(sut.dequeue("dog").getSpecies(), "dog");
    assertEquals(sut.size(), 0);
  }

  @Test
  void test_dequeue_enqueue_mix() {
    AnimalShelter sut = new AnimalShelter();
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("cat"));
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("dog"));
    assertEquals(sut.dequeue("cat").getSpecies(), "cat");
    assertEquals(sut.dequeue("dog").getSpecies(), "dog");
    sut.enqueue(new Animal("cat"));
    sut.enqueue(new Animal("cat"));
    assertEquals(sut.dequeue("cat").getSpecies(), "cat");
    assertEquals(sut.dequeue("cat").getSpecies(), "cat");
    sut.enqueue(new Animal("cat"));
    assertEquals(sut.dequeue("dog").getSpecies(), "dog");
    assertEquals(sut.dequeue("cat").getSpecies(), "cat");
    assertEquals(sut.dequeue("dog").getSpecies(), "dog");
    assertEquals(sut.size(), 0);
  }

  @Test
  void test_dequeue_single_not_found() {
    AnimalShelter sut = new AnimalShelter();
    sut.enqueue(new Animal("dog"));
    assertNull(sut.dequeue("cat"));
  }

  @Test
  void test_dequeue_multiple_not_found() {
    AnimalShelter sut = new AnimalShelter();
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("dog"));
    sut.enqueue(new Animal("cat"));
    sut.enqueue(new Animal("dog"));
    sut.dequeue("cat");
    assertNull(sut.dequeue("cat"));
  }

}
