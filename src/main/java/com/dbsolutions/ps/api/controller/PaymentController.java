package com.dbsolutions.ps.api.controller;

import com.dbsolutions.ps.api.entity.Payment;
import com.dbsolutions.ps.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(path = "payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(path = "/doPayment")
    public Payment doPayment(@RequestBody Payment payment) {
        return paymentService.doPayment(payment);
    }
    
    public String paymentProcessing() {
        // TODO: 8/18/2022 add 3rd party payment gateway ex..paypal 
        return new Random().nextBoolean()?"success":"false";
    }
}
