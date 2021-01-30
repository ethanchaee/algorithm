package com.ethanchae.main.sort;

public class MergeSort extends BaseSort {
    static int n = 0;

    @Override
    public void sort() {
        n = getLength();
        mergeSort(arr, 0, n);
        showResult();
    }

    static void mergeSort(int[] data, int start, int end) {
        //배열의 길이가 2 이상일 때만 나눔,
        //최소단위 1 까지 나누는 과정
        if (end - start < 2) return;

        //divide
        int mid = (start + end) / 2;            //중간 인덱스춤
        mergeSort(data, 0, mid);          //왼쪽 리스트
        mergeSort(data, mid, end);              //오른쪽 리스트

        //conquer and combine
        mergeArray(data, start, mid, end);      //정렬한 리스트 합치기
    }

    static void mergeArray(int[] arr, int start, int mid, int end) {
        int sortedLength = end - start;
        int[] temp = new int[sortedLength];
        int index = 0;
        int leftIdx = start;
        int rightIdx = mid;

        //conquer
        while (leftIdx < mid && rightIdx < end) {
            //값을 비교해서, 작은 값을 정렬 리스트에 추가
            if (arr[leftIdx] < arr[rightIdx]) {
                temp[index++] = arr[leftIdx++];
            } else {
                temp[index++] = arr[rightIdx++];
            }
        }

        //각 리스트는 이미 정렬이 된 상태이기 때문에, 그냥 값을 넣으면 됨
        //왼쪽 리스트에 정렬할 내용이 남아있으면 추가
        while (leftIdx < mid) {
            temp[index++] = arr[leftIdx++];
        }
        //오른쪽 리스트에 정렬할 내용이 남아있으면 추가
        while (rightIdx < end) {
            temp[index++] = arr[rightIdx++];
        }

        //combine
        for (int i = start; i < end; i++) {
            arr[i] = temp[i - start];
        }
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort();
    }
}
