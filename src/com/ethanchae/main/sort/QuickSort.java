package com.ethanchae.main.sort;

public class QuickSort extends BaseSort {

    static int n;

    @Override
    public void sort() {
        n = getLength();

        quickSort(arr, 0, n - 1);

        showResult();
    }

    static void quickSort(int[] arr, int start, int end) {
        if (end <= start) return;

        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot, end);
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end)/2];
        while(start < end){
            while(arr[start] < pivot) start ++;
            while(arr[end] > pivot) end--;
            if(start <= end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.sort();
    }
}
