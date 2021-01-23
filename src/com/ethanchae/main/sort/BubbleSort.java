package com.ethanchae.main.sort;


/**
 * 인접한 두수를 비교하면서 연산하는 방법
 * 배열의 길이가 10 이면
 * 9 + 8 + 7 + ... 의 횟수만큼 비교연산이 일어남
 * 등차수열의 합은 n*(n-1)/2 = (n^2-n)/2
 * 따라서 Big O 는 O (n^2)
 *
 */
public class BubbleSort extends BaseSort {

    @Override
    public void sort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 비교연산 - 앞의 값이 뒤의 값 보다 크면 swap
                if (arr[j] > arr[j + 1]) {
                    //데이터 swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        showResult();
    }

    public static void main(String[] argh) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort();
    }
}
