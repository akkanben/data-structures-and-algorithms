package codechallenges;

import java.util.ArrayList;
import java.util.Stack;

public class ValidateBrackets {

  boolean validateBrackets(String str) {
    Stack<Character> charStack = new Stack<>();
    ArrayList<Character> openBrackets = new ArrayList<>();
    openBrackets.add('{');
    openBrackets.add('(');
    openBrackets.add('[');
    ArrayList<Character> closeBrackets = new ArrayList<>();
    closeBrackets.add('}');
    closeBrackets.add(')');
    closeBrackets.add(']');
    for (int i = 0; i < str.length(); i++) {
      Character current = str.charAt(i);
      if (!openBrackets.contains(current) && !closeBrackets.contains(current))
        continue;
      if (charStack.isEmpty()) {
        if (openBrackets.contains(current))
          charStack.push(current);
        else
          return false;
      } else {
        Character top = charStack.peek();
        if (openBrackets.contains(top)) {
          if (openBrackets.contains(current))
            charStack.push(current);
          else if (isMatchingBrackets(top, current))
            charStack.pop();
          else
            return false;
        } else
          return false;
        }
      }
    return charStack.isEmpty() ? true : false;
  }

  boolean isMatchingBrackets(char openingBracket, char closingBracket) {
    if (openingBracket == '{')
      return closingBracket == '}';
    if (openingBracket == '(')
      return closingBracket == ')';
    if (openingBracket == '[')
      return closingBracket == ']';
    return false;
  }

}
