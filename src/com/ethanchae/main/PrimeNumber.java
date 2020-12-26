package com.ethanchae.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimeNumber {
    private int createPrimeNumberList(int n) {
        boolean[] isPrimeList = new boolean[n+1];

        for(int i = 2; i < isPrimeList.length; i ++){
            isPrimeList[i] = true;
        }
        int root = (int) Math.sqrt(n);

        for(int i = 2; i <= root; i++){
            if(!isPrimeList[i]) continue;
            int lastPosition = i/n + 1;
            for(int j = 2; j < lastPosition; j++){
                isPrimeList[i*j] = false;
            }
        }
        int answer = 0;
        for(boolean isPrime : isPrimeList){
            if(isPrime) answer++;
        }
        return answer;
    }
}
