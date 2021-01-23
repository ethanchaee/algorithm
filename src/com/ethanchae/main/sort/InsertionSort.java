package com.ethanchae.main.sort;

/**
 *
 */
public class InsertionSort extends BaseSort {

    @Override
    public void sort() {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            //정렬이 완료된 영역
            for (int j = i - 1; j >= 0; j--) {
                //가지고 있는 숫자가 현재위치의 숫자보다 왼쪽에 와야 하는 경우
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];    //한칸 뒤로 밀기
                }
                //가지고 있는 숫자가 현재위치의 숫자보다 오른쪽에 와야하는 경우
                else {
                    arr[j + 1] = temp;
                    //정렬된 공간에 값을 넣었으므로 다음 숫자 비교로 넘어감
                    break;
                }
            }

        }
        showResult();
    }

    public static void main(String[] argh) {
        InsertionSort sort = new InsertionSort();
        sort.sort();
    }
}