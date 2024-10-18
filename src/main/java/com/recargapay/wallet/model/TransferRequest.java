package com.recargapay.wallet.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferRequest {
    private Long walletSourceId;
    private Long walletTargetId;
    private String amount;
    private String currency;
}
