package codechallenges.animalshelter;

import datastructures.stack.Stack;

public class AnimalShelter {

  Stack<Animal> front;
  Stack<Animal> back;
  int size;

  public AnimalShelter() {
    front = new Stack<>();
    back = new Stack<>();
  }

  public void enqueue(Animal animal) {
    back.push(animal);
    size++;
  }

  public Animal dequeue(String preference) {
    if (back.isEmpty()) {
      System.out.println(preference + " not found.");
      return null;
    }
    while(!back.isEmpty())
      front.push(back.pop());
    while (!front.isEmpty() && !front.peek().species.equals(preference))
      back.push(front.pop());
    if (front.isEmpty()) {
      System.out.println(preference + " not found.");
      return null;
    } else {
      Animal output = front.pop();
      while (!front.isEmpty())
        back.push(front.pop());
      size--;
      return output;
    }
  }

  public int size() {
    return size;
  }
}
