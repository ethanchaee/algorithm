package com.ethanchae.main.sorttest;

import com.ethanchae.main.sort.BaseSort;

public class MergeSort extends BaseSort {
    @Override
    public void sort() {
        int end = getLength();

        mergeSort(arr, 0, end);


        showResult();
    }

    public void mergeSort(int[] arr, int start, int end){
        if(end - start < 2) return;

        int mid = (end + start)/2;
        mergeSort(arr, 0, mid);
        mergeSort(arr, mid, end);

        mergeArray(arr, start, mid, end);
    }

    public void mergeArray(int[] arr, int start, int mid, int end){
        int[] temp = new int[end + start + 1];
        int left = start;
        int right = mid;
        int index = 0;
        while(left < mid && right < end){
            if(arr[left] < arr[right]){
                temp[index] = arr[left];
                left ++;
            } else {
                temp [index] = arr[right];
                right++;
            }
            index ++;
        }

        while(left < mid){
            temp[index] = arr[left];
            left++;
            index++;
        }

        while(right < end){
            temp[index] = arr[right];
            right++;
            index++;
        }

        for(int i = start; i < end; i++){
            arr[i] = temp[i - start];
        }
    }



    public static void main(String [] args){
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort();
    }
}
