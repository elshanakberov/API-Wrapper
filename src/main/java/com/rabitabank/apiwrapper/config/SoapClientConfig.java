package com.rabitabank.apiwrapper.config;

import com.rabitabank.apiwrapper.client.CalculatorClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.rabitabank.apiwrapper");
        return jaxb2Marshaller;
    }

    @Bean
    public CalculatorClient calculatorClient(Jaxb2Marshaller jaxb2Marshaller){
        CalculatorClient calculatorClient = new CalculatorClient();
        calculatorClient.setDefaultUri("http://www.dneonline.com/calculator.asmx");
        calculatorClient.setMarshaller(jaxb2Marshaller);
        calculatorClient.setUnmarshaller(jaxb2Marshaller);

        return calculatorClient;
    }


}
