package com.ethanchae.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeNumber {
    @Test
    public void getCountPrimeNumber() {

        assertEquals(4, countPrimeNumber(10));
        assertEquals(3, countPrimeNumber(5));

    }

    public int countPrimeNumber(int n) {
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
        int answer = 0;
        for (boolean isPrime : isPrimeList) {
            if (isPrime) answer++;
        }
        return answer;
    }
}
