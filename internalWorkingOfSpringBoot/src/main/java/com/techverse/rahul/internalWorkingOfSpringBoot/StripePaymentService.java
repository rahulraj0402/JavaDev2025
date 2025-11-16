package com.techverse.rahul.internalWorkingOfSpringBoot;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.provider" , havingValue = "stripe")
public class StripePaymentService implements paymentService{

    @Override
    public String pay() {
        String payment = "Stripe payment";
        System.out.println("paying from ... " + payment);
        return payment;
    }
}
