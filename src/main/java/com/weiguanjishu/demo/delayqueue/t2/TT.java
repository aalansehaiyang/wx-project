package com.weiguanjishu.demo.delayqueue.t2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TT {

    public static void main(String[] args) {
        List<String> lists = Arrays.asList("Hello", "World");
        lists.stream().flatMap(word -> Stream.of(word.split("")))
                .distinct()
                .forEach(System.out::println);
    }
}
