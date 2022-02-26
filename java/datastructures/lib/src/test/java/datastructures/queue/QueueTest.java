package datastructures.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueTest {

  @Test
  void test_enqueue() {
    Queue<String> sut = new Queue<>();
    sut.enqueue("Java");
    assert(sut.size() == 1);
  }

  @Test
  void test_enqueue_multiple() {
    Queue<String> sut = new Queue<>();
    sut.enqueue("Java");
    sut.enqueue("C++");
    sut.enqueue("Rust");
    assert(sut.size() == 3);
  }

  @Test
  void test_dequeue_expected() {
    Queue<String> sut = new Queue<>();
    sut.enqueue("Java");
    sut.enqueue("C++");
    sut.enqueue("Rust");
    String str = sut.dequeue();
    assert(str.equals("Java"));
  }

  @Test
  void test_peek_expected() {
    Queue<String> sut = new Queue<>();
    sut.enqueue("Java");
    String str = sut.peek();
    assert(str.equals("Java"));
    assert(sut.size() == 1);
  }

  @Test
  void test_dequeue_until_empty() {
    Queue<String> sut = new Queue<>();
    sut.enqueue("Java");
    sut.enqueue("C++");
    sut.enqueue("Rust");
    while(!sut.isEmpty()) {
      sut.dequeue();
    }
    assert(sut.isEmpty());
  }

  @Test
  void test_instantiate_empty() {
    Queue<Integer> sut = new Queue<>();
    assert(sut.isEmpty());
    assert(sut.size() == 0);
  }


  @Test
  void test_peek_empty_exception() {
    Queue<Integer> sut = new Queue<>();
    assertThrows(NullPointerException.class, () -> {
      sut.peek();
    });
  }

  @Test
  void test_dequeue_empty_exception() {
    Queue<Integer> sut = new Queue<>();
    assertThrows(NullPointerException.class, () -> {
      sut.dequeue();
    });
  }

}
