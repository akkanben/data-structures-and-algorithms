package codechallenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
