package com.imooc.stack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        LinkedListStack<Integer> arrayStack = new LinkedListStack<Integer>();
        for(int i = 0; i < 5; i++){
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        arrayStack.pop();
        System.out.println(arrayStack);
    }
}
