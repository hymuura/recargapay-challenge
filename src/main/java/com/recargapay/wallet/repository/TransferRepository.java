package com.recargapay.wallet.repository;

import com.recargapay.wallet.entity.TransferEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TransferRepository extends ReactiveCrudRepository<TransferEntity, Long> {
}
