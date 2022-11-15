package com.example.demo.test;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }

    public Test() {

    }

    public void run() {
        new TestListProvider().getList().parallelStream().map(new MainFunction()).forEach(new ExcelConsumer());
    }

}
