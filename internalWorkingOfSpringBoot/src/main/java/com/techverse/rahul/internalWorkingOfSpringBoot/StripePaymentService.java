package com.techverse.rahul.internalWorkingOfSpringBoot;

import org.springframework.stereotype.Component;

@Component
public class StripePaymentService implements paymentService{

    @Override
    public String pay() {
        String payment = "Stripe payment";
        System.out.println("paying from ... " + payment);
        return payment;
    }
}
