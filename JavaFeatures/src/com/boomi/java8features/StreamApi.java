package com.boomi.java8features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(18, 34, 4, 77, 13, 67, 87, 54, 12, 2);

        list.forEach(ele -> System.out.println(ele));

        Stream<Integer> streamList = list.stream();
        Stream<Integer> sortedList = streamList.sorted();

        System.out.println("");
        int sumOfSquareOfAllEvenNumber = sortedList.filter(ele -> ele % 2 == 0)
                .map(ele -> ele * ele)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sumOfSquareOfAllEvenNumber);

        System.out.println("");
        list.forEach(ele -> System.out.println(ele));

    }
}
