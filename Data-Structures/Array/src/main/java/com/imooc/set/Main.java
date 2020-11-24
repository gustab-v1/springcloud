package com.imooc.set;

import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("D:\\Coder\\java\\eclipse\\eclipse\\eclipse-workspace\\Data-Structures\\Array\\src\\pride-and-prejudice.txt",word1);
        System.out.println("Total words: "+word1.size());

        BSTSet<String> bstSet = new BSTSet<>();
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();

        for (String s : word1) {
            linkedListSet.add(s);
        }
        System.out.println("different words: "+linkedListSet.getSize());
    }
}
