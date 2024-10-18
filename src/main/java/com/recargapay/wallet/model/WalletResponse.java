package com.recargapay.wallet.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WalletResponse {
    private Long id;
    private String userName;
    private String balance;
    private String currency;
}
