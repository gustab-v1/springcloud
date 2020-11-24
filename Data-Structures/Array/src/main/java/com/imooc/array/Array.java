package com.imooc.array;

public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public Array(E[] arr){
        data = (E[])new Object[arr.length];
        for(int i = 0; i < arr.length; i++)
            data[i] = arr[i];
        size = arr.length;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return data.length;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在所有元素前添加一个元素
     *
     * @param e 添加的元素的值
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向所有元素后添加一个元素
     *
     * @param e 添加的元素的值
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在第index的位置插入e
     *
     * @param index 索引的值
     * @param e     添加的元素的值
     */
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        if (size == data.length)
            resize(data.length * 2);

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素
     *
     * @param index 索引的值
     * @return 返回指定索引的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        return data[index];
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    /**
     * 修改index索引位置的元素为e
     *
     * @param index 索引的值
     * @param e     元素
     */
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Index is illegal");
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     *
     * @param e 元素的值
     * @return 存在的话返回true，否则为false
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * 查找数组中元素e所在索引，如果不存在元素e，则返回-1
     *
     * @param e 元素的值
     * @return 找到则返回元素所在索引，否则返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     *
     * @param index 索引的值
     * @return 删除的元素的值
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove fail, Index is illegal");

        E res = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];

        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return res;
    }

    /**
     * 从数组中删除第一个元素
     *
     * @return 删除的元素的值
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素
     *
     * @return 删除的元素的值
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     *
     * @param e 需删除的指定元素的值
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    public void swap(int i, int j){
        if(i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal");
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    /**
     * 数组动态扩容
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }
}
