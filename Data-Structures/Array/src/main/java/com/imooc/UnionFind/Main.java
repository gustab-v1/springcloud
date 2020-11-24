package com.imooc.UnionFind;

import java.util.Random;

public class Main {
    private static double testUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElement(a, b);
        }
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
//        System.out.println("uf1: " + testUF(new UnionFind1(100000), 100000));
//        System.out.println("uf2: " + testUF(new UnionFind2(100000), 100000));
        System.out.println("uf3: " + testUF(new UnionFind3(10000), 10000));
        System.out.println("uf4: " + testUF(new UnionFind4(10000), 10000));
        System.out.println("uf5: " + testUF(new UnionFind5(10000), 10000));
        System.out.println("uf6: " + testUF(new UnionFind6(10000), 10000));
    }
}
