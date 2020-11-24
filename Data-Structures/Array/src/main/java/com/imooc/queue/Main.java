package com.imooc.queue;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<Integer>();

        for (int i = 0; i < 10; i++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }

        Queue<Integer> queue1 = new LoopQueue<Integer>();

        for (int i = 0; i < 100; i++){
            queue1.enqueue(i * 100);
            System.out.println(queue1);

            if(i % 3 == 2){
                queue1.dequeue();
                System.out.println(queue1);
            }

            Stack<Integer> stack1 = new Stack<Integer>();
        }
    }
}
