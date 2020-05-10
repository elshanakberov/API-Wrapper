package com.rabitabank.apiwrapper.aspect;

import com.rabitabank.apiwrapper.model.Calculator;
import com.rabitabank.apiwrapper.service.CallService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LogToFileAspect {

    private static Logger log = LoggerFactory.getLogger(LogToFileAspect.class);

    SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM HH:mm:ss");
    String date = simpleDateFormat.format(new Date());

    @Autowired
    HttpServletRequest request;

    private int call = 1;

    @Around( "execution(* com.rabitabank.apiwrapper.controller.CalculatorController.*(..))" )
    public Object add( ProceedingJoinPoint joinPoint ) throws Throwable
    {
        // Log here for request using joinPoint variable information
        Object[] args = joinPoint.getArgs();
        Calculator calculator = (Calculator) args[0];
        log.info(date +" ." + "Call " + call +" - " + request.getRequestURI()+" ("+calculator.getInput1() + "," + calculator.getInput2() + ") to JSON");
        log.info(date +" ." + "Call " + call +" - " + request.getRequestURI()+"("+calculator.getInput1() + "," + calculator.getInput2() + ") to SOAP");
        // and add the necessary entries to DB
        Object proceed = joinPoint.proceed(); // This instructs the target to proceed with method execution which is the add() method
        // Log here for response and add the necessary info to DB
        log.info(date +" ." +"Call " + this.call +" - " + "response from SOAP");
        this.call++;
        return proceed; // This is mandatory and this contains the result of add() method. You can even change the actual result here
    }
}
