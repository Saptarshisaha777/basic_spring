package com.learn.java8;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] ums = {1, 2, 3,4,5};
        Queue<Integer> queue = new LinkedList<>();
        for (int num : ums) {
            queue.add(num);
        }
        System.out.println();
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue);

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
