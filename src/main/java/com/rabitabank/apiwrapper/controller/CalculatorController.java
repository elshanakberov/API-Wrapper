package com.rabitabank.apiwrapper.controller;

import com.rabitabank.apiwrapper.AddResponse;
import com.rabitabank.apiwrapper.DivideResponse;
import com.rabitabank.apiwrapper.MultiplyResponse;
import com.rabitabank.apiwrapper.SubtractResponse;
import com.rabitabank.apiwrapper.annotations.LogToDb;
import com.rabitabank.apiwrapper.client.CalculatorClient;
import com.rabitabank.apiwrapper.model.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    private CalculatorClient calculatorClient;


    public CalculatorController(CalculatorClient calculatorClient) {
        this.calculatorClient = calculatorClient;
    }

    @LogToDb
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Calculator calculator){
           AddResponse response = calculatorClient.add(calculator.getInput1(),calculator.getInput2());
           return ResponseEntity.ok().body(response.getAddResult());
     }

    @LogToDb
    @PostMapping("/multiply")
    public ResponseEntity multiply(@RequestBody Calculator calculator){
        MultiplyResponse response = calculatorClient.multiply(
          calculator.getInput1(),
          calculator.getInput2()
        );

        return ResponseEntity.ok().body(response.getMultiplyResult());
    }

    @LogToDb
    @PostMapping("/divide")
    public ResponseEntity divide(@RequestBody Calculator calculator){
        DivideResponse response = calculatorClient.divide(
                calculator.getInput1(),
                calculator.getInput2()
        );

        return ResponseEntity.ok().body(response.getDivideResult());
    }
    @LogToDb
    @PostMapping("/subtract")
    public ResponseEntity subtract(@RequestBody Calculator calculator){

        SubtractResponse response = calculatorClient.subtract(
                calculator.getInput1(),
                calculator.getInput2()
        );

        return ResponseEntity.ok().body(response.getSubtractResult());
    }



}
