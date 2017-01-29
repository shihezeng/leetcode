package easy;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/implement-stack-using-queues/
public class Q225_implement_stack_using_queues {
	public static class MyStack {
	    Queue<Integer> queue;
	    /** Initialize your data structure here. */
	    public MyStack() {
	        queue = new LinkedList<Integer>();
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	        queue.offer(x);
	        for(int i=0; i<queue.size()-1;i++){
	        	queue.offer(queue.poll());
	        }
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	        return queue.poll();
	    }
	    
	    /** Get the top element. */
	    public int top() {
	        return queue.peek();
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return queue.isEmpty();
	    }
	}
	
	public static void main(String[] args){
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());
	}
}
