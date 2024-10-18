package com.recargapay.wallet.controller;

import com.recargapay.wallet.model.WalletRequest;
import com.recargapay.wallet.model.WalletResponse;
import com.recargapay.wallet.service.WalletService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public Mono<WalletResponse> createWallet(@RequestBody WalletRequest request) {
        return this.walletService.createWallet(request);
    }
}
