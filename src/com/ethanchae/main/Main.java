package com.ethanchae.main;

import com.ethanchae.exhaustivesearch.FindPrimeNumber;
import com.ethanchae.hash.Camouflage;
import com.ethanchae.stackqueue.DoublePriorityQueue;

public class Main {

    public static void main(String[] args) {
        // write your code here

//        DoublePriorityQueue doublePriorityQueue = new DoublePriorityQueue();
//        doublePriorityQueue.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});

        //[[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]
        Camouflage camouflage = new Camouflage();
        camouflage.solution(new String[][]{{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}});
    }
}
