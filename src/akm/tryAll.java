package akm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class tryAll {
    public static void main(String[] args) {
        Stack<Integer> stack= new Stack<Integer>();
        Queue<Integer>queue=new LinkedList<>();

        stack.add(5);
        stack.add(6);
        stack.add(7);
        stack.push(8);
        stack.peek();
        stack.pop();
        System.out.println(stack);

        queue.add(5);
        queue.add(55);
        queue.offer(6);
        queue.offer(66);
        queue.peek();
        queue.poll();
        System.out.println(queue);
    }
}
