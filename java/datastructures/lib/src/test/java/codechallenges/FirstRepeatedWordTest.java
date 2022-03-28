package codechallenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstRepeatedWordTest {

  @Test
  void example_one() {
    HashMapChallenges sut = new HashMapChallenges();
    String str = "Once upon a time, there was a brave princess who...";
    assertEquals(sut.getFirstRepeatedWord(str), "a");
  }

  @Test
  void example_two() {
    HashMapChallenges sut = new HashMapChallenges();
    String str = "It was the best of times, it was the worst of times, it was the age of wisdom, " +
      "it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, " +
      "it was the season of Light, it was the season of Darkness, it was the spring of hope, it was " +
      "the winter of despair, we had everything before us, we had nothing before us, we were all going " +
      "direct to Heaven, we were all going direct the other way – in short, the period was so far like " +
      "the present period, that some of its noisiest authorities insisted on its being received, for " +
      "good or for evil, in the superlative degree of comparison only...";
    assertEquals(sut.getFirstRepeatedWord(str), "it");
  }

  @Test
  void example_empty_string() {
    HashMapChallenges sut = new HashMapChallenges();
    String str = "";
    assertEquals(sut.getFirstRepeatedWord(str), "");
  }

  @Test
  void example_all_same_word() {
    HashMapChallenges sut = new HashMapChallenges();
    String str = "a a a a";
    assertEquals(sut.getFirstRepeatedWord(str), "a");
  }

  @Test
  void example_three() {
    HashMapChallenges sut = new HashMapChallenges();
    String str = "It was a queer, sultry summer, the summer they electrocuted the Rosenbergs, and I didn’t " +
      "know what I was doing in New York...";
    assertEquals(sut.getFirstRepeatedWord(str), "summer");
  }

  @Test
  void example_one_wordcount() {
    HashMapChallenges sut = new HashMapChallenges();
    String str = "Once upon a time, there was a brave princess who...";
    assertTrue(sut.getWordCounts(str).contains("a: 2"));
    assertTrue(sut.getWordCounts(str).contains("who: 1"));
  }

  @Test
  void example_two_wordcount() {
    HashMapChallenges sut = new HashMapChallenges();
    String str = "It was the best of times, it was the worst of times, it was the age of wisdom, " +
      "it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, " +
      "it was the season of Light, it was the season of Darkness, it was the spring of hope, it was " +
      "the winter of despair, we had everything before us, we had nothing before us, we were all going " +
      "direct to Heaven, we were all going direct the other way – in short, the period was so far like " +
      "the present period, that some of its noisiest authorities insisted on its being received, for " +
      "good or for evil, in the superlative degree of comparison only...";
    assertTrue(sut.getWordCounts(str).contains("the: 14"));
    assertTrue(sut.getWordCounts(str).contains("of: 12"));
    assertTrue(sut.getWordCounts(str).contains("it: 10"));
    assertTrue(sut.getWordCounts(str).contains("best: 1"));
  }

  @Test
  void example_three_wordcount() {
    HashMapChallenges sut = new HashMapChallenges();
    String str = "It was a queer, sultry summer, the summer they electrocuted the Rosenbergs, and I didn’t " +
      "know what I was doing in New York...";
    assertTrue(sut.getWordCounts(str).contains("summer: 2"));
    assertTrue(sut.getWordCounts(str).contains("was: 2"));
    assertTrue(sut.getWordCounts(str).contains("rosenbergs: 1"));
  }
}
