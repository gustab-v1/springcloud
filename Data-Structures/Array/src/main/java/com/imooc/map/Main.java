package com.imooc.map;

import com.imooc.set.FileOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("D:\\Coder\\java\\eclipse\\eclipse\\eclipse-workspace\\Data-Structures\\Array\\src\\pride-and-prejudice.txt", words);
        System.out.println("Total words: " + words.size());

        //       LinkedListMap<String, Integer> map = new LinkedListMap<>();
        BSTMap<String, Integer> map = new BSTMap<>();

        for (String word : words) {
            if (map.contains(word))
                map.set(word, map.get(word) + 1);
            else
                map.add(word, 1);
        }
        System.out.println("Total different words: " + map.getSize());
        System.out.println("Frequency of PRIDE: " + map.get("you"));
    }
}
