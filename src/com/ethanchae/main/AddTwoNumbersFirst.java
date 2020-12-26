package com.ethanchae.main;

import java.util.Set;
import java.util.TreeSet;

public class AddTwoNumbersFirst {
    private final Set<Integer> result = new TreeSet<>();
    private final int pickCount = 2;
    public int[] solution(int[] numbers) {
        calculate(numbers, new boolean[numbers.length], 0, pickCount);
        return setToIntArray(result);
    }

    private void calculate(int[] inputArray, boolean[] visited, int start, int r) {
        if (r == 0) {
            addNumber(inputArray, visited);
        }
        for (int i = start; i < inputArray.length; i++) {
            visited[i] = true;
            calculate(inputArray, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }

    private void addNumber(int[] inputArray, boolean[] visited) {
        int number = 0;
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]){
                number += inputArray[i];
                count++;
            }
            if(count == pickCount){
                break;
            }
        }
        result.add(number);
    }

    private int[] setToIntArray(Set<Integer> integerSet) {
        int[] intArray = new int[integerSet.size()];
        int i = 0;
        for (Integer value : integerSet) {
            intArray[i] = value;
            i++;
        }
        return intArray;
    }
}
