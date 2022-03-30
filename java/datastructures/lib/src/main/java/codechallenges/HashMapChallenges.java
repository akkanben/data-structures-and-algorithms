package codechallenges;

import datastructures.hashtable.HashMap;
import org.apache.commons.math3.util.Pair;
import org.checkerframework.checker.units.qual.A;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HashMapChallenges {

  public String getFirstRepeatedWord(String str) {
    HashMap<String, Boolean> hashmap = new HashMap<>();
    String current = "";
    for (int i = 0; i < str.length(); i++) {
      char c = Character.toLowerCase(str.charAt(i));
      if ((c >= 'a' && c <= 'z') || c == '\'')
        current = current + c;
      else if (c == ' ' || i == str.length() - 1) {
        if (hashmap.contains(current))
          return current;
        hashmap.set(current, true);
        current = "";
      }
    }
    return "";
  }

  public List<String> getWordCounts(String str) {
    HashMap<String, Integer> hashmap = new HashMap<>();
    String current = "";
    for (int i = 0; i < str.length(); i++) {
      char c = Character.toLowerCase(str.charAt(i));
      if ((c >= 'a' && c <= 'z') || c == '\'')
        current = current + c;
      else if ((c == ' ' || i == str.length() - 1) && current.length() > 0) {
        if (hashmap.contains(current))
          hashmap.set(current, hashmap.get(current) + 1);
        else
          hashmap.set(current, 1);
        current = "";
      }
    }
    ArrayList<String> output = new ArrayList<>();
    for (String element : hashmap.keys()) {
      output.add(element + ": " + hashmap.get(element));
    }
    return output;
  }

  public ArrayList<ArrayList<String>> joinHashMapPair(HashMap<String, String> hashMapLeft, HashMap<String, String> hashMapRight, boolean isRightJoin) {
    ArrayList<ArrayList<String>> output = new ArrayList<>();
    if (isRightJoin) {
      HashMap<String, String> temp = hashMapLeft;
      hashMapLeft = hashMapRight;
      hashMapRight = temp;
    }
    for (String key : hashMapLeft.keys()) {
      ArrayList<String> row = new ArrayList<>();
      row.add(key);
      row.add(hashMapLeft.get(key));
      output.add(row);
    }
    for (ArrayList<String> row : output) {
      String key = row.get(0);
      if (hashMapRight.contains(key))
        row.add(hashMapRight.get(key));
      else
        row.add(null);
    }
    return output;
  }

  public ArrayList<ArrayList<String>> joinHashMapPair(HashMap<String, String> hashMapLeft, HashMap<String, String> hashMapRight) {
    ArrayList<ArrayList<String>> output = new ArrayList<>();
    for (String key : hashMapLeft.keys()) {
      ArrayList<String> row = new ArrayList<>();
      row.add(key);
      row.add(hashMapLeft.get(key));
      output.add(row);
    }
    for (ArrayList<String> row : output) {
      String key = row.get(0);
      if (hashMapRight.contains(key))
        row.add(hashMapRight.get(key));
      else
        row.add(null);
    }
    return output;
  }
}
