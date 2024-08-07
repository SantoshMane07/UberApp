package com.santoshmane.project.uber.UberApp.strategies;

import com.santoshmane.project.uber.UberApp.entities.enums.PaymentMethod;
import com.santoshmane.project.uber.UberApp.strategies.impl.CashPaymentStrategy;
import com.santoshmane.project.uber.UberApp.strategies.impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod){
        return switch(paymentMethod){
            case WALLET -> walletPaymentStrategy;
            case CASH -> cashPaymentStrategy;
        };
    }

}
