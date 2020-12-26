package com.ethanchae.main;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 * 문제 설명
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * <p>
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 * <p>
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * 013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 *
 * 2:32
 *
 */
public class FindPrimeNumber {

    TreeSet<Integer> numberList = new TreeSet<>();
    int answer = 0;
    char[] output;

    public int solution(String numbers) {
        int size = numbers.length();
        output = new char[size];
        createNumberList(numbers.toCharArray());
        countPrimeNumber();

        return answer;
    }


    private void createNumberList(char[] array) {
        for (int i = 1; i <= array.length; i++) {
            permutationNumberCard(array, output, new boolean[array.length], 0, i);
        }
    }

    private void permutationNumberCard(char[] array, char[] output, boolean[] visited, int depth, int r) {
        if (depth == r) {
            numberList.add(getNumber(output, r));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            output[depth] = array[i];
            permutationNumberCard(array, output, visited, depth + 1, r);
            visited[i] = false;
        }
    }

    private int getNumber(char[] array, int r) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < r; i++) {
            stringBuilder.append(array[i]);
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    private void countPrimeNumber() {
        Set<Integer> primeNumbers = createPrimeNumberList(numberList.last());
        for (int number : numberList) {
            if (primeNumbers.contains(number)) answer++;
        }
    }

    private Set<Integer> createPrimeNumberList(int n) {
        Set<Integer> numbers = new HashSet<>();
        boolean[] isPrimeList = new boolean[n + 1];
        for (int i = 2; i < isPrimeList.length; i++) {
            isPrimeList[i] = true;
        }
        int root = (int) Math.sqrt(n) + 1;

        for (int i = 2; i < root; i++) {
            if (!isPrimeList[i]) continue;
            int lastPosition = n / i + 1;
            for (int j = 2; j < lastPosition; j++) {
                isPrimeList[i * j] = false;
            }
        }
        int i = 0;
        for (boolean isPrime : isPrimeList) {
            if (isPrime) numbers.add(i);
            i++;
        }
        return numbers;
    }
}
