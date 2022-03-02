package codechallenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateBracketsTest {

  @Test
  void test_constructor() {
    ValidateBrackets sut = new ValidateBrackets();
    assertNotNull(sut);
    assertTrue(sut.validateBrackets("hello"));
    assertFalse(sut.validateBrackets("}"));
    assertTrue(sut.validateBrackets("{{}}"));
    assertTrue(sut.validateBrackets("{()(){}[{}{}]}"));
    assertTrue(sut.validateBrackets("{{}}"));
    assertTrue(sut.validateBrackets("{{}}"));
    assertFalse(sut.validateBrackets("()}"));
    assertFalse(sut.validateBrackets("(}"));
  }

  @Test
  void test_simple_true() {
    ValidateBrackets sut = new ValidateBrackets();
    assertTrue(sut.validateBrackets("{}"));
    assertTrue(sut.validateBrackets("()"));
    assertTrue(sut.validateBrackets("[]"));
    assertTrue(sut.validateBrackets("()[]"));
    assertTrue(sut.validateBrackets("[]{}"));
  }

  @Test
  void test_simple_false() {
    ValidateBrackets sut = new ValidateBrackets();
    assertFalse(sut.validateBrackets("}"));
    assertFalse(sut.validateBrackets("{"));
    assertFalse(sut.validateBrackets("))"));
    assertFalse(sut.validateBrackets("(("));
    assertFalse(sut.validateBrackets("[)"));
    assertFalse(sut.validateBrackets("]]"));
  }

  @Test
  void test_complex_true() {
    ValidateBrackets sut = new ValidateBrackets();
    assertTrue(sut.validateBrackets("{()(){}[{}{}]}"));
    assertTrue(sut.validateBrackets("[[[()(({()})())]{}]({})]"));
  }

  @Test
  void test_complex_false() {
    ValidateBrackets sut = new ValidateBrackets();
    assertFalse(sut.validateBrackets("{()(){}[{())}{}]}"));
    assertFalse(sut.validateBrackets("[[[()(({()})[())]{}]({})]"));
  }

  @Test
  void test_with_extra_chars() {
    ValidateBrackets sut = new ValidateBrackets();
    assertTrue(sut.validateBrackets("abc{abc}abc"));
    assertFalse(sut.validateBrackets("ABC{ABC"));
    assertTrue(sut.validateBrackets("{AB{CD}EF}"));
  }

  @Test
  void test_empty() {
    ValidateBrackets sut = new ValidateBrackets();
    assertTrue(sut.validateBrackets(""));
  }
}
