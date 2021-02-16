package com.ethanchae.main.sort;

import java.awt.event.WindowFocusListener;

/**
 * 힙 : 최댓값, 최솟값을 찾기 위해 고안된 방법으로 완전이진트리의 데이터 구조
 * - maxHeap : 부모노드가 자식노드 보다 큼
 * - minHeap : 부모노드가 자식노드 보다 작음
 * - 자식 노드끼리 대소관계는 어떻게 비교?
 * - 가장 마지막 노드는 가장 아래쪽 자식 노드, 해당 자식노드 두개가 모두 존재할 경우 왼쪽 노드
 * 1. 부모노드 : 자식노드 /2
 * 2. 왼쪽 자식노드 : 부모노드 * 2
 * 3. 오른쪽 자식노드 : 부모노드 * 2 + 1
 * <p>
 * 배열, 리스트 중 배열로 구현
 * 리스트로 구현하면 마지막 노드를 추가하는 것이 어려움
 */
public class HeapSort extends BaseSort {


    @Override
    public void sort() {
        int number = getLength();

        heap(arr, number);
        for (int i = number - 1; i > 0; i--) {
            swap(arr, 0, i);
            heap(arr, i);
        }

        showResult();
    }


    //힙구조로 만듦
    private void heap(int[] arr, int n) {
        int first = n / 2 - 1;
        for(int parent = first ; parent >= 0; parent--){
            int left = parent * 2 + 1;
            int right = left + 1;

            if(right < n && arr[right] > arr[parent]){
                swap(arr, right, parent);
            }
            if(arr[left] > arr[parent]){
                swap(arr, left, parent);
            }
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.sort();
    }
}
