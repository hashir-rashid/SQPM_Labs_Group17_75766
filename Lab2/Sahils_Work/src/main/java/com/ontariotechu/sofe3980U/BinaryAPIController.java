package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

    @GetMapping("/add")
    public String add(
            @RequestParam(name="operand1", required=false, defaultValue="") String operand1,
            @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.add(number1, number2).getValue();
    }

    @GetMapping("/add_json")
    public BinaryAPIResult addJson(
            @RequestParam(name="operand1", required=false, defaultValue="") String operand1,
            @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "add", number2, Binary.add(number1, number2));
    }

    @GetMapping("/multiply")
    public String multiply(
            @RequestParam(name="operand1", required=false, defaultValue="") String operand1,
            @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.multiply(number1, number2).getValue();
    }

    @GetMapping("/multiply_json")
    public BinaryAPIResult multiplyJson(
            @RequestParam(name="operand1", required=false, defaultValue="") String operand1,
            @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "multiply", number2, Binary.multiply(number1, number2));
    }

    @GetMapping("/or")
    public String or(
            @RequestParam(name="operand1", required=false, defaultValue="") String operand1,
            @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.or(number1, number2).getValue();
    }

    @GetMapping("/or_json")
    public BinaryAPIResult orJson(
            @RequestParam(name="operand1", required=false, defaultValue="") String operand1,
            @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "or", number2, Binary.or(number1, number2));
    }

    @GetMapping("/and")
    public String and(
            @RequestParam(name="operand1", required=false, defaultValue="") String operand1,
            @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.and(number1, number2).getValue();
    }

    @GetMapping("/and_json")
    public BinaryAPIResult andJson(
            @RequestParam(name="operand1", required=false, defaultValue="") String operand1,
            @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {

        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "and", number2, Binary.and(number1, number2));
    }
}
