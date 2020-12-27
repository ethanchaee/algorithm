package com.ethanchae.heap;

import java.util.PriorityQueue;

/**
 * Heap
 * <p>
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는
 * 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
 * <p>
 * 섞은 음식의 스코빌 지수 =
 * 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 * <p>
 * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
 * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 1. 오름차순으로 정렬을 하고
 * 2. 앞에부터 섞어넣기
 * 3. 다시 남아있는 숫자들을 확인하기
 *
 * 14:15
 * 와.... good
 */
public class TheHotter {
    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> foods = new PriorityQueue<>();
        for (int value : scoville) {
            foods.add(value);
        }

        while(!foods.isEmpty()){
            int mixedFood = mix(foods.poll(), foods.poll());
            foods.add(mixedFood);
            count++;
            if(isAllValueHigherThan(foods, K)) return count;
            if(foods.size() < 2) return -1;
        }

        return count;
    }

    private int mix(int first, int second) {
        return first + (second * 2);
    }

    private boolean isAllValueHigherThan(PriorityQueue<Integer> foods, int k) {
        if(foods.peek() == null) return false;
        return foods.peek() > k;
    }
}
