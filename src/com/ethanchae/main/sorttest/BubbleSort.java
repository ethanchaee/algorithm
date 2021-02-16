package com.ethanchae.main.sorttest;

import com.ethanchae.main.sort.BaseSort;

public class BubbleSort extends BaseSort {


    @Override
    public void sort() {
        int n = getLength();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j+1]) swap(arr, j, j+1);
            }
        }
        showResult();
    }

    public static void main(String [] args){
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort();
    }
}
