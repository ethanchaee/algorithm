package com.ethanchae.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Printer {

    @Test
    public void clauclate(){
        com.ethanchae.stackqueue.Printer printer = new com.ethanchae.stackqueue.Printer();
        int result = printer.solution(new int[]{2, 1, 3, 2}, 2);
        int result2 = printer.solution(new int[]{1, 1, 9, 1, 1, 1}, 5);

        assertEquals(1, result);
        assertEquals(0, result2);
    }

}
