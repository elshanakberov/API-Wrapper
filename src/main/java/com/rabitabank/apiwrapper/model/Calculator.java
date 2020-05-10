package com.rabitabank.apiwrapper.model;


public class Calculator {

    private int input1;
    private int input2;

    public Calculator() {
    }

    public Calculator(int input1, int input2) {
        this.input1 = input1;
        this.input2 = input2;
    }

    public int getInput1() {
        return input1;
    }

    public void setInput1(int input1) {
        this.input1 = input1;
    }

    public int getInput2() {
        return input2;
    }

    public void setInput2(int input2) {
        this.input2 = input2;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "input1=" + input1 +
                ", input2=" + input2 +
                '}';
    }
}
