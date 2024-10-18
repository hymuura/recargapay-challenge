package com.recargapay.wallet.service.impl;

import com.recargapay.wallet.entity.WalletEntity;
import com.recargapay.wallet.mapper.TransferMapper;
import com.recargapay.wallet.model.TransferRequest;
import com.recargapay.wallet.model.TransferResponse;
import com.recargapay.wallet.repository.TransferRepository;
import com.recargapay.wallet.repository.WalletRepository;
import com.recargapay.wallet.service.TransferService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.math.BigDecimal;

@Service
public class TransferServiceImpl implements TransferService {
    private final WalletRepository walletRepository;
    private final TransferRepository transferRepository;

    public TransferServiceImpl(WalletRepository walletRepository, TransferRepository transferRepository) {
        this.walletRepository = walletRepository;
        this.transferRepository = transferRepository;
    }

    @Override
    public Mono<TransferResponse> transfer(TransferRequest request) {
        return Mono.just(request)
                .map(TransferMapper::toEntity)
                .flatMap(transferEntity -> walletRepository.findById(transferEntity.getWalletSourceId())
                        .zipWith(walletRepository.findById(transferEntity.getWalletTargetId()))
                        .flatMap(wallets -> verifyBalance(wallets, transferEntity.getAmount()))
                        .flatMap(wallets -> {
                            WalletEntity sourceWallet = wallets.getT1();
                            WalletEntity targetWallet = wallets.getT2();

                            sourceWallet.setBalance(sourceWallet.getBalance().subtract(transferEntity.getAmount()));
                            targetWallet.setBalance(targetWallet.getBalance().add(transferEntity.getAmount()));

                            return Mono.zip(walletRepository.save(sourceWallet),
                                            walletRepository.save(targetWallet),
                                            transferRepository.save(transferEntity))
                                    .map(result -> TransferMapper.toResponse(result.getT3()));
                        })
                )
                .switchIfEmpty(Mono.error(new IllegalArgumentException("One or both wallets do not exist")));
    }

    private Mono<Tuple2<WalletEntity, WalletEntity>> verifyBalance(Tuple2<WalletEntity, WalletEntity> wallets, BigDecimal amount) {
        WalletEntity sourceWallet = wallets.getT1();

        if (sourceWallet.getBalance().compareTo(amount) < 0) {
            return Mono.error(new IllegalArgumentException("Insufficient balance"));
        }

        return Mono.just(wallets);
    }
}
