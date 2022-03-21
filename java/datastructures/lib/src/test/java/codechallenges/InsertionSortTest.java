package codechallenges;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionSortTest {

  @Test
  void test_example_one() {
    SortChallenges sut = new SortChallenges();
    int[] arr = {8, 4, 23, 42, 16, 15};
    int[] target = {4, 8, 15, 16, 23, 42};
    sut.insertionSort(arr);
    assertArrayEquals(arr, target);

  }

  @Test
  void test_example_two() {
    SortChallenges sut = new SortChallenges();
    int[] arr = {20, 18, 12, 8, 5, -2};
    int[] target = {-2, 5, 8, 12, 18, 20};
    sut.insertionSort(arr);
    assertArrayEquals(arr, target);
  }

  @Test
  void test_example_three() {
    SortChallenges sut = new SortChallenges();
    int[] arr = {5, 12, 7, 5, 5, 7};
    int[] target = {5, 5, 5, 7, 7, 12};
    sut.insertionSort(arr);
    assertArrayEquals(arr, target);
  }

  @Test
  void test_example_four() {
    SortChallenges sut = new SortChallenges();
    int[] arr = {2, 3, 5, 7, 13, 11};
    int[] target = {2, 3, 5, 7, 11, 13};
    sut.insertionSort(arr);
    assertArrayEquals(arr, target);
  }
}
