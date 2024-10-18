package com.recargapay.wallet.service;

import com.recargapay.wallet.model.TransferRequest;
import com.recargapay.wallet.model.TransferResponse;
import reactor.core.publisher.Mono;

public interface TransferService {
    Mono<TransferResponse> transfer(TransferRequest transferRequest);
}
