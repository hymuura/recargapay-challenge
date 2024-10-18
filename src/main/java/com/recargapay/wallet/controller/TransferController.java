package com.recargapay.wallet.controller;

import com.recargapay.wallet.model.TransferRequest;
import com.recargapay.wallet.model.TransferResponse;
import com.recargapay.wallet.service.TransferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public Mono<TransferResponse> createWallet(@RequestBody TransferRequest request) {
        return this.transferService.transfer(request);
    }
}
