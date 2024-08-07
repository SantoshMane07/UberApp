package com.santoshmane.project.uber.UberApp.repositories;

import com.santoshmane.project.uber.UberApp.entities.User;
import com.santoshmane.project.uber.UberApp.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
    Optional<Wallet> findByUser(User user);
}
