package com.recargapay.wallet.service.impl;

import com.recargapay.wallet.mapper.WalletMapper;
import com.recargapay.wallet.model.WalletRequest;
import com.recargapay.wallet.model.WalletResponse;
import com.recargapay.wallet.repository.WalletRepository;
import com.recargapay.wallet.service.WalletService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Mono<WalletResponse> createWallet(WalletRequest request) {
        return Mono.just(request)
                .map(WalletMapper::toEntity)
                .flatMap(walletRepository::save)
                .map(WalletMapper::toResponse);
    }
}
