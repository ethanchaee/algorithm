package com.ethanchae.main.sort;


/**
 * 선택 정렬
 * 정렬순서상 가장 앞서는 값을 왼쪽으로 보내고, 원래 그 자리에 있던 데이터는 빈자리에 놓음
 * */
public class SelectionSort extends BaseSort{

    @Override
    public void sort() {
        for (int i = 0; i < arr.length; i++) {
            int tempPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                //비교연산, 최소값 탐색
                if(arr[tempPosition] > arr[j]){
                    tempPosition = j;
                }
            }
            //데이터 이동
            int temp = arr[tempPosition];
            arr[tempPosition] = arr[i];
            arr[i] = temp;
        }
        showResult();
    }

    public static void main(String[] argh) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort();
    }
}
