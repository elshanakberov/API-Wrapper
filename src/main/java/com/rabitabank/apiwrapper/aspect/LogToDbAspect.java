package com.rabitabank.apiwrapper.aspect;

import com.rabitabank.apiwrapper.entity.Call;
import com.rabitabank.apiwrapper.entity.Response;
import com.rabitabank.apiwrapper.model.Calculator;
import com.rabitabank.apiwrapper.service.CallService;
import com.rabitabank.apiwrapper.service.ResponseService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Aspect
@Component
public class LogToDbAspect {

    @Autowired
    private CallService callService;
    @Autowired
    private ResponseService responseService;
    @Autowired
    HttpServletRequest request;

    @Around("@annotation(com.rabitabank.apiwrapper.annotations.LogToDb)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        Object proceed = joinPoint.proceed();
        final Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        Calculator calculator = (Calculator) args[0];
        String requestToJson = request.getRequestURI()+"("+calculator.getInput1()+","+calculator.getInput2() +") to JSON";
        String requestToSoap = request.getRequestURI() + "("+calculator.getInput1()+","+calculator.getInput2() +") to SOAP";
        String responseFromJson = "result from SOAP";
        Call call = new Call();
        call.setInsertDate(new Date());
        callService.save(call);
        Response requestJson = new Response(call,new Date(),requestToJson);
        Response requestSoap = new Response(call,new Date(),requestToSoap);
        Response responseSoap = new Response(call,new Date(),responseFromJson);
        responseService.save(requestJson);
        responseService.save(requestSoap);
        responseService.save(responseSoap);
        return proceed;
    }
}
