package com.ethanchae.main.sorttest;

import com.ethanchae.main.sort.BaseSort;

public class InsertionSort extends BaseSort {

    @Override
    public void sort() {
        int n  = getLength();

        showResult();
    }

    public static void main(String [] args){
        InsertionSort sort = new InsertionSort();
        sort.sort();
    }
}
