package codechallenges;

public class SortChallenges {

  public void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int j = i - 1;
      int temp = arr[i];
      while (j >= 0 && temp < arr[j]) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = temp;
    }
  }

  void mergeSort(int[] arr) {

    int n = arr.length;
    if (n <= 1)
      return;
    int[] left = new int[n / 2];
    int[] right = new int[(n / 2) + (n % 2)];
    int leftIndex = 0;
    int rightIndex = 0;

    for (int i = 0; i < arr.length; i++) {
      if (i < n / 2)
        left[leftIndex++] = arr[i];
      else
        right[rightIndex++] = arr[i];
    }
    mergeSort(left);
    mergeSort(right);
    merge(left, right, arr);
  }

  void merge(int[] left, int[] right, int[]arr) {
    int i, j, k;
    i = j = k = 0;
    while (i < left.length && j < right.length) {
      if (left[i] <= right[j])
        arr[k++] = left[i++];
      else
        arr[k++] = right[j++];
    }
    while (i < left.length)
      arr[k++] = left[i++];
    while (j < right.length)
      arr[k++] = right[j++];
  }

  public void quickSort(int[] arr) {
    quickHelper(arr, 0,arr.length - 1);
  }

  private void quickHelper(int[] arr, int left, int right) {
    if (left < right) {
      int position = partition(arr, left, right);
      quickHelper(arr, left, position - 1);
      quickHelper(arr, position +1, right);
    }
  }

  private int partition(int[] arr, int left, int right) {
    int pivot = arr[right];
    int low = left - 1;
    for (int i = left; i < right; i++) {
      if (arr[i] <= pivot)
        swap(arr, i, ++low);
    }
    swap(arr, right, low + 1);
    return low + 1;
  }

  private void swap(int[] arr, int i, int low) {
    int temp = arr[i];
    arr[i] = arr[low];
    arr[low] = temp;
  }

}
