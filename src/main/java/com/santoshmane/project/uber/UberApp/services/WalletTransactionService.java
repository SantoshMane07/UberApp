package com.santoshmane.project.uber.UberApp.services;

import com.santoshmane.project.uber.UberApp.dto.WalletTransactionDto;
import com.santoshmane.project.uber.UberApp.entities.WalletTransaction;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransaction walletTransaction);

}
