package easy;

import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/
public class Q232_queue_using_stack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int x) {
        stack2.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (stack1.isEmpty()) {
            pushToStack1();
        }
        stack1.pop();
    }

    // Get the front element.
    public int peek() {
        if (stack1.isEmpty()) {
            pushToStack1();
        }
        return stack1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void pushToStack1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public static void main(String[] args) {
        Q232_queue_using_stack queue = new Q232_queue_using_stack();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.pop();
        queue.pop();
    }

}
