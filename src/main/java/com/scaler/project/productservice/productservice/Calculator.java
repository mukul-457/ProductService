package com.scaler.project.productservice.productservice;

public class Calculator {

    private Mathematics mathematics;

    public Calculator(Mathematics mathematics) {
        this.mathematics = mathematics;
    }


    public  int add(int a, int b) {
        return mathematics.add(a, b);
    }
    public int subtract(int a, int b) {
        return mathematics.subtract(a, b);
    }

    public  int multiply(int a, int b) {
        return mathematics.multiply(a, b);
    }

    public int divide (int a, int b) {
        return mathematics.divide(a, b);
    }
}
