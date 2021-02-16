package com.ethanchae.main.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public abstract class BaseSort implements SortInterface{

    private long startTime = 0;

    public BaseSort() {
        this.startTime = System.nanoTime();
        Arrays.sort(resultArr);
    }

    public void showResult(){
        System.out.println("정렬결과 : " + this.getClass().getSimpleName() + " 경과시간 : " + (System.nanoTime() - startTime));
        for(int i : arr){
            System.out.print(i + ", ");
        }
        System.out.println("\n 정렬정답 : ");
        for(int i : resultArr){
            System.out.print(i + ", ");
        }
    }

    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int getLength(){
        return arr.length;
    }
}
