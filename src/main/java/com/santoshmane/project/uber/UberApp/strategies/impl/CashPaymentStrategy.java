package com.santoshmane.project.uber.UberApp.strategies.impl;

import com.santoshmane.project.uber.UberApp.entities.Driver;
import com.santoshmane.project.uber.UberApp.entities.Payment;
import com.santoshmane.project.uber.UberApp.entities.enums.PaymentStatus;
import com.santoshmane.project.uber.UberApp.entities.enums.TransactionMethod;
import com.santoshmane.project.uber.UberApp.repositories.PaymentRepository;
import com.santoshmane.project.uber.UberApp.services.PaymentService;
import com.santoshmane.project.uber.UberApp.services.WalletService;
import com.santoshmane.project.uber.UberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser(), platformCommission,null,payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
