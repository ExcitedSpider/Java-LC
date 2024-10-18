package array;

import java.util.Stack;

public class A232QueueImpl {

}

class MyQueue {
  Stack<Integer> inputStack;
  Stack<Integer> outputStack;

  public MyQueue() {
    inputStack = new Stack<>();
    outputStack = new Stack<>();
  }

  public void push(int x) {
    inputStack.push(x);
  }

  public int pop() {
    if(outputStack.size() == 0) {
      transferOutput();
    }
    if(outputStack.size() == 0) {
      throw new RuntimeException("No element in the queue");
    }
    return outputStack.pop();
  }

  private void transferOutput() {
    while (inputStack.size() != 0) {
      var it = inputStack.pop();
      outputStack.push(it);
    }
  }

  public int peek() {
    if(outputStack.size() == 0) {
      transferOutput();
    }
    return outputStack.peek();
  }

  public boolean empty() {
    return outputStack.size() + inputStack.size() == 0;
  }
}
