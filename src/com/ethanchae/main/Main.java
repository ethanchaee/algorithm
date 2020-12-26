package com.ethanchae.main;

import sun.lwawt.macosx.CSystemTray;

public class Main {

    public static void main(String[] args) {
        // write your code here
        FindPrimeNumber findPrimeNumber = new FindPrimeNumber();
        int answer = findPrimeNumber.solution("017");
        System.out.println(answer);


//        Combination combination = new Combination();
//        combination.withoutDuplication(new int[]{1,2,3,4,5}, 2);
//
//        System.out.println("premutation");
//        Permutation permutation= new Permutation();
//        permutation.calculate(new int[]{1,2,3,4,5}, 2);
    }
}
