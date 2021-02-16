package com.ethanchae.main.sorttest;

import com.ethanchae.main.sort.BaseSort;

public class QuickSort extends BaseSort {


    @Override
    public void sort() {
        int n = getLength();

        quickSort(arr, 0, n - 1);

        showResult();
    }


    private void quickSort(int[] arr, int start, int end){
        if (n <= start) return;

        int pivot = partitioning(arr, start, end);

        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot, end);
    }

    private int partitioning(int [] arr, int start, int end){
        int pivot = arr[(start + end) / 2];
        int left = start;
        int right = end;

        while(left < right){
            while(arr[left] < pivot){
                left++;
            }
            while(arr[right] > pivot){
                right--;
            }
            if(left <= right){
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }




    public static void main(String [] args){
        QuickSort quickSort = new QuickSort();
        quickSort.sort();
    }
}
