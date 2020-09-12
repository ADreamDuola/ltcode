package com.sap.code;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add("aa");
        list2.add("bb");
        list2.add("cc");
        list3.add("a");
        list3.add("b");
        list3.add("c");
//        final List<? extends Serializable> collect = Stream.of(list1, list2, list3).flatMap(s -> s.stream()).collect(Collectors.toList());
//        System.out.println(collect.toString());
        List<String> list = Stream.of(list2, list3).flatMap(s -> s.stream()).collect(Collectors.toList());
        System.out.println(list.toString());


    }
}
