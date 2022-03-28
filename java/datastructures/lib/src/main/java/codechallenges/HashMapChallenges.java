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

}
