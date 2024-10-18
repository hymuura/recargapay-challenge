package com.recargapay.wallet.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WalletRequest {
    private String userName;
    private String currency;
}
