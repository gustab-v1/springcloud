package com.imooc.bst;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        int[] num = {5,3,6,2,4,8};
        for (int i : num) {
            bst.add(i);
        }
        bst.remove(6);
        bst.inOrder();
    }
}

