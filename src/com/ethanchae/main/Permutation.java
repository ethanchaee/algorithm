package com.ethanchae.main;

public class Permutation {

    int[] output;
    public void calculate(int[] array, int r){
        output = new int[array.length];
        backTracking(array, output, new boolean[array.length], 0, r);
    }

    private void backTracking(int[] array, int[] output, boolean[] visited, int depth, int r){
        if(depth == r){
            print(output, r);
            return;
        }
        for (int i = 0; i < array.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            output[depth] = array[i];
            backTracking(array, output, visited, depth + 1, r);
            visited[i]= false;
        }
    }

    private void print(int[] array, int r){
        for (int i = 0; i < r; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

}
