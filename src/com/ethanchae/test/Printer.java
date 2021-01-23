package com.ethanchae.test;

import com.ethanchae.monthlychallenge.TriangleSnail;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class Printer {

    @Test
    public void calculate() {
        String[] magazine = {"two", "times", "three", "is", "not", "four"};
        String[] note = {"two", "times", "two", "is", "four"};
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(5L);
        list.add(5L);
        list.add(25L);
        list.add(125L);

        //assertEquals(4, countTriplets(list, 5));

        double number = BigDecimal.valueOf(Math.log(125)/Math.log(5)).remainder(BigDecimal.ONE).setScale(10, RoundingMode.DOWN).doubleValue();
        assertEquals(0, number, 0);
        //assertEquals(0, number, 0);
    }
    static int commonChild(String s1, String s2) {
        int maxCount = 0;
        int length = s1.length();
        for(int i = 0; i < length; i++){
            if(maxCount > length - i) break;
            int count = 0;
            maxCount = Math.max(maxCount, nextCheckString(s1.substring(i), s2, count));
        }
        return maxCount;
    }

    static int nextCheckString(String s1, String s2, int count){
        if(s1.length() == 0) return count;
        char ch = s1.charAt(0);
        if(s2.contains(String.valueOf(ch))) count++;
        return nextCheckString(
                s1.substring(s1.indexOf(ch) + 1),
                s2.substring(s2.indexOf(ch) + 1),
                count
        );
    }

    static long countTriplets(List<Long> arr, long r) {
        LinkedHashMap <Long, Integer> elements = new LinkedHashMap();
        for(long element : arr){
            BigDecimal.valueOf(Math.log(125)/Math.log(5)).remainder(BigDecimal.ONE).setScale(10, RoundingMode.DOWN);
            BigDecimal number = BigDecimal.valueOf(Math.log(element)).divide(BigDecimal.valueOf(Math.log(r))).remainder(BigDecimal.ONE);
            if(number.compareTo(BigDecimal.ZERO) == 0) continue;
            else {

            }
            Double a = 10d;
            if(!elements.containsKey(element)){
                elements.put(element, 1);
                continue;
            }
            elements.put(element, elements.get(element) + 1);
        }
        long totalCount = 0L;
        ArrayList<Integer> numbers = new ArrayList(elements.values());
        for(int i = 2; i < numbers.size(); i++){
            totalCount += numbers.get(i-2) * numbers.get(i-1) * numbers.get(i);
        }


        return totalCount;
    }

}
