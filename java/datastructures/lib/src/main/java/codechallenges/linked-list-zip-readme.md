# Challenge Summary

Create a function that takes in 2 linked lists and outputs a new linked list that is a combination of input lists "zipped together". The new list should be ordered such that the values from the first list and the second list alternate.

## Whiteboard Process

[![Whiteboard](images/linked-list-insertions.jpg)](../../../../../images/linked-list-zip.jpg)

<style>
  img {
    max-width: 80%;
  }
</style>


## Approach & Efficiency

To zip the files I decided to use a while loop to continue while either list still had remaining values that had not been added to the new list. In the while loop we check each list if we're to the end of that list or not, if we're not we append the value to the new list. This means we need to iterate as many times as the largest list making the time complexity O(N). The new linked list takes a space complexity of O(N) since it creates a new linked list and appends all the values of list 1 and list 2.

## Code

```java
  // Code Challenge: Class 08
  public LinkedList<Integer> zipLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
     if(list1.size() < 1)
      return list2;
    if(list2.size() < 1)
      return list1;
    LinkedList<Integer> output = new LinkedList<>();
    int position = 0;
    while(position < list1.size() || position < list2.size()) {
      if(position < list1.size())
        output.append(list1.kthFromEnd(list1.size() - position - 1));
      if(position < list2.size())
        output.append(list2.kthFromEnd(list2.size() - position - 1));
      position++;
    }
    return output;
  }

  // Stretch Goal
  public LinkedList<Integer> zipSortedListsSorted(LinkedList<Integer> list1, LinkedList<Integer> list2) {
    if (list1.size() < 1)
      return list2;
    if (list2.size() < 1)
      return list1;
    LinkedList<Integer> output = new LinkedList<>();
    int list1position = 0;
    int list2position = 0;
    boolean list1HasMore = list1position < list1.size();
    boolean list2HasMore = list2position < list2.size();
    while (list1HasMore || list2HasMore) {
      if (list1HasMore && list2HasMore) {
        Integer list1Value = list1.kthFromEnd(list1.size() - list1position - 1);
        Integer list2Value = list2.kthFromEnd(list2.size() - list2position - 1);
        if (list1Value < list2Value) {
          output.append(list1Value);
          list1position++;
        } else {
          output.append(list2Value);
          list2position++;
        }
      } else {
          if (list1HasMore) {
            Integer list1Value = list1.kthFromEnd(list1.size() - list1position - 1);
            output.append(list1Value);
            list1position++;
          } else {
            Integer list2Value = list2.kthFromEnd(list2.size() - list2position - 1);
            output.append(list2Value);
            list2position++;
          }
        }
      list1HasMore = list1position < list1.size();
      list2HasMore = list2position < list2.size();
    }
    return output;
  }
```


