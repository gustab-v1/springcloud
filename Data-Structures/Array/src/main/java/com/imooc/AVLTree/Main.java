package com.imooc.AVLTree;

import com.imooc.map.FileOperation;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("D:\\Coder\\java\\eclipse\\eclipse\\eclipse-workspace\\Data-Structures\\Array\\src\\pride-and-prejudice.txt", words);
        System.out.println("Total words: " + words.size());

        Collections.sort(words);
        //       LinkedListMap<String, Integer> map = new LinkedListMap<>();
        AVLTree<String, Integer> map = new AVLTree<>();

        for (String word : words) {
            if (map.contains(word))
                map.set(word, map.get(word) + 1);
            else
                map.add(word, 1);
        }

        System.out.println("Total different words: " + map.getSize());
        System.out.println("Frequency of PRIDE: " + map.get("i"));
        System.out.println("is balance: " + map.isBalance());
        System.out.println("is BST: " + map.isBST());

        for (String word : words) {
            map.remove(word);
            if (!map.isBalance() || !map.isBST())
                System.out.println("?");
        }
    }
}