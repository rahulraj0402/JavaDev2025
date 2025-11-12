package com.techverse.rahul.internalWorkingOfSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.provider",value = "razor")
public class RazorPaymentService  implements paymentService{
    // component : it automatically makes a object and stores in a IOC and when  ever we want it our spring
    // gives it to use


    // @Autowired : to make

    @Override
    public String pay(){
        String payment = "Razorpay payment";
        System.out.println("payment from : "+payment);
        return payment;
    }
}
