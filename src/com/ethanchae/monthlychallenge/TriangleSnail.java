package com.ethanchae.monthlychallenge;

import java.util.ArrayList;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/68645
 */
public class TriangleSnail {
    private int maxNumber = 1;
    private int totalNumber = 0;

    public int[] solution(int n) {
        totalNumber = getTotalNumber(n);
        ArrayList<int[]> numbers = setNumbers(n);
        return getResult(numbers);
    }

    private ArrayList<int[]> setNumbers(int n) {
        ArrayList<int[]> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(new int[i + 1]);
        }
        numbers.get(0)[0] = 1;

        initLeftLine(numbers);
        if (totalNumber == 1) return numbers;

        int count = 0;
        for (; ; ) {
            if(numbers.size() - (count + 1) > 0){
                maxNumber = setBottomLine(count, numbers);
            }
            if (maxNumber == totalNumber) break;
            if((numbers.size() - (count + 2)) > 0){
                maxNumber = setRightLine(count, numbers);
            }
            if (maxNumber == totalNumber) break;
            maxNumber = setLeftLine(count + 2, numbers);
            if (maxNumber == totalNumber) break;
            count++;
        }
        return numbers;
    }

    private int getTotalNumber(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += i;
        }
        return count;
    }

    private int setLeftLine(int start, ArrayList<int[]> numbers) {
        int lastNumber = 0;
        for (int i = 0; i < numbers.size() - start - 1; i++) {
            lastNumber = maxNumber + (i + 1);
            numbers.get(i + start)[start - 1] = lastNumber;
        }
        return lastNumber;
    }

    private void initLeftLine(ArrayList<int[]> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            numbers.get(i)[0] = i + 1;
        }
    }

    private int setBottomLine(int count, ArrayList<int[]> numbers) {
        int size = numbers.size();
        int[] bottomLine = numbers.get(size - (count + 1));
        for (int i = count; i < size - count; i++) {
            bottomLine[i] = i + size;
        }
        return bottomLine[size - (count + 1)];
    }

    private int setRightLine(int start, ArrayList<int[]> numbers) {
        int k = 1;
        int lastNumber = 0;
        for (int i = numbers.size() - (start + 2); i > start; i--) {
            lastNumber = maxNumber + k;
            numbers.get(i)[i] = lastNumber;
            k++;
        }
        return lastNumber;
    }

    private int[] getResult(ArrayList<int[]> numbers) {
        int[] result = new int[getTotalNumber(numbers.size())];
        int k = 0;
        for (int[] ints : numbers) {
            for (int number : ints) {
                result[k] = number;
                k++;
                System.out.println(number);
            }
        }
        return result;
    }
}
