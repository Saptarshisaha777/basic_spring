import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static Stack<Integer> createStack(@org.jetbrains.annotations.NotNull int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            stack.push(num);
        }
        return stack;
    }

    public static @NotNull Queue<Integer> createQueue(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums) {
            queue.add(num);
        }
        return queue;
    }

    public static @NotNull PriorityQueue<Integer> createPriorityQueue(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        return pq;
    }
}
