package com.ethanchae.main;

public class Combination {
    /**
     * 중복이 있는 조합
     */
    public void withDuplication() {

    }

    /**
     * 중복이 없는 조합
     */
    public void withoutDuplication(int[] inputArray, int r) {
        int n = inputArray.length;
        boolean[] visited = new boolean[n];
        backTracking(inputArray, visited, 0, r);
    }

    /**
     * @param r : 뽑으려는 개수
     */
    private void backTracking(int[] inputArray, boolean[] visited, int start,  int r) {
        if (r == 0) {
            print(inputArray, visited);
        }
        for (int i = start; i < inputArray.length; i++) {
            visited[i] = true;
            backTracking(inputArray, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }


    private void print(int[] array, boolean[] visited) {
        for (int i = 0; i < array.length; i++) {
            if (visited[i]) System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
