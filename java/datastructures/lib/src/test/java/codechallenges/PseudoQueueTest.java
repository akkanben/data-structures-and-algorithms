package codechallenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PseudoQueueTest {

  @Test
  void test_constructor() {
    PseudoQueue<String> sut = new PseudoQueue<>();
    assertNotNull(sut);
  }

  @Test
  void test_enqueue() {
    PseudoQueue<Integer> sut = new PseudoQueue<>();
    sut.enqueue(20);
  }

  @Test
  void test_enqueue_multiple() {
    PseudoQueue<Integer> sut = new PseudoQueue<>();
    sut.enqueue(20);
    sut.enqueue(15);
    sut.enqueue(10);
    sut.enqueue(5);
  }

  @Test
  void test_dequeue() {
    PseudoQueue<Integer> sut = new PseudoQueue<>();
    sut.enqueue(20);
    sut.enqueue(15);
    sut.enqueue(10);
    assertEquals(sut.dequeue(), 20);
  }

  @Test
  void test_enqueue_dequeue_multiple() {
    PseudoQueue<Integer> sut = new PseudoQueue<>();
    sut.enqueue(20);
    sut.enqueue(15);
    sut.enqueue(10);
    assertEquals(sut.dequeue(), 20);
    sut.enqueue(150);
    assertEquals(sut.dequeue(), 15);
    sut.enqueue(200);
    sut.enqueue(400);
    sut.enqueue(1000);
    assertEquals(sut.dequeue(), 10);
    assertEquals(sut.dequeue(), 150);
    sut.enqueue(-1);
    sut.enqueue(-2);
    sut.enqueue(-3);
    assertEquals(sut.dequeue(), 200);
    assertEquals(sut.dequeue(), 400);
    assertEquals(sut.dequeue(), 1000);
    assertEquals(sut.dequeue(), -1);
    assertEquals(sut.dequeue(), -2);
    assertEquals(sut.dequeue(), -3);


  }

  @Test
  void test_example_empty() {
    PseudoQueue<Integer> sut = new PseudoQueue<>();
    assertThrows(NullPointerException.class, () -> {
      sut.dequeue();
    });
  }

}
