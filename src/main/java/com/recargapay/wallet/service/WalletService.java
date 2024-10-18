package com.recargapay.wallet.service;

import com.recargapay.wallet.model.WalletRequest;
import com.recargapay.wallet.model.WalletResponse;
import reactor.core.publisher.Mono;

public interface WalletService {
    Mono<WalletResponse> createWallet(WalletRequest wallet);
}
