package com.recargapay.wallet.mapper;

import com.recargapay.wallet.entity.WalletEntity;
import com.recargapay.wallet.model.WalletRequest;
import com.recargapay.wallet.model.WalletResponse;

import java.math.BigDecimal;
import java.util.UUID;

public class WalletMapper {

    public static WalletEntity toEntity(WalletRequest walletRequest) {
        return WalletEntity.builder()
                .userName(walletRequest.getUserName())
                .currency(walletRequest.getCurrency())
                .balance(BigDecimal.ZERO)
                .build();
    }

    public static WalletResponse toResponse(WalletEntity walletEntity) {
        return WalletResponse.builder()
                .id(walletEntity.getId())
                .userName(walletEntity.getUserName())
                .currency(walletEntity.getCurrency())
                .balance(walletEntity.getBalance().toString())
                .build();
    }
}
