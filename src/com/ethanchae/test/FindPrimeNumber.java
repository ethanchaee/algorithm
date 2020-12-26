package com.ethanchae.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindPrimeNumber {
    @Test
    public void checkStringNumber(){

        assertEquals(13, Integer.parseInt("013"));
        assertEquals(13, Integer.parseInt("0013"));
        assertEquals(13, Integer.parseInt("00013"));

    }

}
