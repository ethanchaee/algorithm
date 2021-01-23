package com.ethanchae.main.sort;

public abstract class BaseSort implements SortInterface{

    private long startTime = 0;

    public BaseSort() {
        this.startTime = System.nanoTime();
    }

    public void showResult(){
        System.out.println("정렬결과 : " + this.getClass().getSimpleName() + " 경과시간 : " + (System.nanoTime() - startTime));
        for(int i : arr){
            System.out.println(i + " ");
        }
    }
}
