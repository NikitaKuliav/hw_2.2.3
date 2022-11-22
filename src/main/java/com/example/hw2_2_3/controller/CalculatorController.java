package com.example.hw2_2_3.controller;

import com.example.hw2_2_3.service.CalculatorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String greetings() {
        return "<h1>Добро пожаловать в калькулятор</h1>";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer x,
                       @RequestParam(name = "num2", required = false) Integer y) {
        if (x == null || y == null) {
            return "Нет одного из аргументов";
        }
        return buildResultString(x, y, "+", calculatorService.plus(x, y));

    }

    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer x,
                       @RequestParam(name = "num2", required = false) Integer y) {
        if (x == null || y == null) {
            return "Нет одного из параметров";
        }
        return buildResultString(x, y, "-", calculatorService.minus(x, y));

    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer x,
                       @RequestParam(name = "num2", required = false) Integer y) {
        if (x == null || y == null) {
            return "Нет одного из аргументов";
        }
        return buildResultString(x, y, "*", calculatorService.multiply(x, y));

    }

    @GetMapping("/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer x,
                       @RequestParam(name = "num2", required = false) Integer y) {
        if (x == null || y == null) {
            return "Нет одного из аргументов";
        }
        if(y==0) {
            return "Делить на ноль нельзя!";
        }
        return buildResultString(x, y, "/", calculatorService.divide(x, y));

    }
    private String buildResultString(int x,
                                     int y,
                                     String operation,
                                     Number result) {
        return String.format("%d %s %d = %s", x, operation, y, result);
    }






}
