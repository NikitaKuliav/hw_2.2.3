package com.example.hw2_2_3.service;


import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int plus(int x, int y) {
        return x + y;
    }

    public int minus(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public double divide(int x, int y) {
        return (double)x / y;
    }
}
