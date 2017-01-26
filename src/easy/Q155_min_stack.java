package easy;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
public class Q155_min_stack {
    public static class Stack1 {
        private Node head;

        private class Node {
            private int val;
            private int min;
            private Node next;

            public Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }

        public void push(int x) {
            head = head == null ? new Node(x, x, null)
                    : new Node(x, Math.min(x, head.min), head);
        }

        public void pop() {
            if (head != null)
                head = head.next;
        }

        public int top() {
            if (head == null)
                throw new IllegalStateException();
            return head.val;
        }

        public int getMin() {
            if (head == null)
                throw new IllegalStateException();
            return head.min;
        }
    }

    public static class Stack2 {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;

        public void push(int x) {
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if (!stack.isEmpty()) {
                if (min == stack.pop()) {
                    min = stack.pop();
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

    public static class Stack3 {
        Stack<Long> stack = new Stack<>();
        long min;

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(0L);
                min = x;
            } else {
                stack.push(x - min);
                if (x < min)
                    min = x;
            }

        }

        public void pop() {
            if (stack.isEmpty())
                return;
            long pop = stack.pop();
            if (pop < 0)
                min = min - pop;
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new IllegalStateException();
            }
            long peek = stack.peek();
            if (peek > 0) {
                return (int) (min + peek);
            } else {
                return (int) min;
            }
        }

        public int getMin() {
            return (int) min;
        }
    }

    public static void main(String[] args) {
        // Stack1 stack1 = new Stack1();
        // Stack2 stack1 = new Stack2();
        Stack3 stack1 = new Stack3();
        stack1.push(10);
        stack1.push(-1);
        stack1.push(9);
        System.out.println(stack1.getMin());
        stack1.pop();
        System.out.println(stack1.getMin());
        stack1.pop();
        System.out.println(stack1.getMin());
    }
}
