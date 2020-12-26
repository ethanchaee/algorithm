package com.ethanchae.main;

import java.util.Set;
import java.util.TreeSet;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/68644
 * 정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는
 * 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에
 * 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
 * -> TreeSet 확인
 * 조합으로 풀 필요 없음.
 * 1:22 소요
 */
public class AddTwoNumbers {
    private final Set<Integer> result = new TreeSet<>();

    public int[] solution(int[] numbers) {
        calculate(numbers, 0);
        return setToIntArray(result);
    }

    private void calculate(int[] inputArray, int start) {
        if (start + 1 > inputArray.length) return;

        int firstNumber = inputArray[start];
        for (int i = start + 1; i < inputArray.length; i++) {
            result.add(firstNumber + inputArray[i]);
        }
        calculate(inputArray, start + 1);
    }

    private int[] setToIntArray(Set<Integer> integerSet) {
        int[] intArray = new int[integerSet.size()];
        int i = 0;
        for (Integer value : integerSet) {
            intArray[i] = value;
            i++;
        }
        //stream 을 사용해서 하는 방법도 있으나 훨씬 느림
        //return integerSet.stream().mapToInt(Integer::intValue).toArray();
        return intArray;
    }

}
