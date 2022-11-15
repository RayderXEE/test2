package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MainFunction implements Function<List<String>, List<String>> {
    @Override
    public List<String> apply(List<String> list) {
        ArrayList<String> list1 = new ArrayList<>();
        list.stream()
                .map(s->s+"1")
                .forEach(list1::add);
        return list1;
    }
}
