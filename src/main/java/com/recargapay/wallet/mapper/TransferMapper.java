package com.recargapay.wallet.mapper;

import com.recargapay.wallet.entity.TransferEntity;
import com.recargapay.wallet.model.TransferRequest;
import com.recargapay.wallet.model.TransferResponse;

import java.math.BigDecimal;

public class TransferMapper {

    public static TransferEntity toEntity(TransferRequest transferRequest) {
        return TransferEntity.builder()
                .amount(new BigDecimal(transferRequest.getAmount()))
                .currency(transferRequest.getCurrency())
                .walletSourceId(transferRequest.getWalletSourceId())
                .walletTargetId(transferRequest.getWalletTargetId())
                .build();
    }

    public static TransferResponse toResponse(TransferEntity transferEntity) {
        return TransferResponse.builder()
                .id(transferEntity.getId())
                .build();
    }
}
