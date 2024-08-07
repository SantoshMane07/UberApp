package com.santoshmane.project.uber.UberApp.strategies.impl;

import com.santoshmane.project.uber.UberApp.entities.Driver;
import com.santoshmane.project.uber.UberApp.entities.Payment;
import com.santoshmane.project.uber.UberApp.entities.Rider;
import com.santoshmane.project.uber.UberApp.entities.Wallet;
import com.santoshmane.project.uber.UberApp.entities.enums.PaymentStatus;
import com.santoshmane.project.uber.UberApp.entities.enums.TransactionMethod;
import com.santoshmane.project.uber.UberApp.repositories.PaymentRepository;
import com.santoshmane.project.uber.UberApp.services.PaymentService;
import com.santoshmane.project.uber.UberApp.services.WalletService;
import com.santoshmane.project.uber.UberApp.strategies.PaymentStrategy;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;

    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(), payment.getAmount(),null,payment.getRide(), TransactionMethod.RIDE);

        double driversCut = payment.getAmount() * (1-PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser(), driversCut,null,payment.getRide(),TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
