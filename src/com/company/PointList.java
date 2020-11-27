package com.company;


import java.util.Arrays;

public class PointList {
    private static final int DEFAULT_CAPACITY = 10;
    private Point[] points;
    private int size = 0;
    private int newCapacity = DEFAULT_CAPACITY;

    public PointList() {
        points = new Point[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }


    public void add(Point point) {
        if (point != null) {
            if (size < newCapacity) {
                points[size] = point;
                size++;
            } else {
                newCapacity = (int) (newCapacity * 1.5);
                Point[] tempData = new Point[newCapacity];
                System.arraycopy(points, 0, tempData, 0, points.length);
                tempData[size] = point;
                points = Arrays.copyOf(tempData, newCapacity);
                size++;
            }
        }
    }

    public Point get(int index) {
        checkIndex(index);
        return points[index];
    }

    public Point set(int index, Point element) {
        checkIndex(index);
        Point prev = points[index];
        points[index] = element;
        return prev;
    }

    public Point remove(int index) {
        checkIndex(index);
        Point e = points[index];
        System.arraycopy(points, (index + 1), points, index, (--size - index));
        points[size] = null;
        return e;
    }



    public void clear() {
        int size = size();
        for (int i = 0; i <= size - 1; i++) {
            points[i] = null;
        }

        this.size = 0;
    }

    public int indexOf(Object o) {
        for (int i = 0; i <= size - 1; i++) {
            if (points[i].equals(o)) {
                return i;
            } else if (points[i] == o) {
                return i;
            }
        }
        return -1;
    }

    private void checkIndex(int index) {
        if (size - 1 < index) {
            throw new IndexOutOfBoundsException("");
        }
    }
}
