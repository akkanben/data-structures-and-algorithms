package datastructures.stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
  @Test
  void test_push() {
    Stack<String> sut = new Stack<>();
    sut.push("Hello");
    assert(sut.size() == 1);
  }

  @Test
  void test_push_multiple() {
    Stack<String> sut = new Stack<>();
    sut.push("is");
    sut.push("name");
    sut.push("my");
    sut.push("Hello");
    assert(sut.size() == 4);
  }

  @Test
  void test_pop() {
    Stack<String> sut = new Stack<>();
    sut.push("Hello");
    String str = sut.pop();
    assert(str.equals("Hello"));
    assert(sut.size() == 0);
  }

  @Test
  void test_pop_until_empty() {
    Stack<Integer> sut = new Stack<>();
    sut.push(100);
    sut.push(200);
    sut.push(1000);
    sut.push(2000);
    while(!sut.isEmpty()) {
      sut.pop();
    }
    assert(sut.isEmpty());
  }

  @Test
  void test_peek() {
    Stack<Double> sut = new Stack<>();
    sut.push(3.14);
    sut.push(1.618);
    assert(sut.peek().equals(1.618));
  }

  @Test
  void test_instantiate_empty_stack() {
    Stack<Integer> sut = new Stack<>();
    assert(sut.isEmpty());
  }

  @Test
  void test_peek_empty_exception() {
    Stack<Integer> sut = new Stack<>();
    assertThrows(NullPointerException.class, () -> {
      sut.peek();
    });
  }

  @Test
  void test_pop_empty_exception() {
    Stack<Integer> sut = new Stack<>();
    assertThrows(NullPointerException.class, () -> {
      sut.pop();
    });
  }


}
