package codechallenges;

import datastructures.linkedlist.LinkedList;

public class LinkedListChallenges {

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
}
