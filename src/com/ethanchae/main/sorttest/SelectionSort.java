package com.ethanchae.main.sorttest;

import com.ethanchae.main.sort.BaseSort;

import java.util.concurrent.ConcurrentHashMap;

public class SelectionSort extends BaseSort {
    @Override
    public void sort() {
        int n = getLength();
        for(int i = 0; i < n; i ++){
            int minIndex = i;
            for(int j = i; j < n; j++){
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }
            swap(arr, minIndex, i);
        }
        showResult();
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        ConcurrentHashMap
        sort.sort();
    }
}
