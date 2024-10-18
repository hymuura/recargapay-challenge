package com.recargapay.wallet.repository;

import com.recargapay.wallet.entity.WalletEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface WalletRepository extends ReactiveCrudRepository<WalletEntity, Long> {
}
