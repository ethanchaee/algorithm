package com.ethanchae.main.sorttest;

import com.ethanchae.main.sort.BaseSort;

public class HeapSort extends BaseSort {

    @Override
    public void sort() {
        int n = getLength();

        showResult();
    }

    private void heap(int[] arr, int n) {

    }


    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.sort();
    }

}
