package com.recargapay.wallet.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@Builder
@Table("transfer")
public class TransferEntity {
    @Id
    private Long id;
    private Long walletSourceId;
    private Long walletTargetId;
    private BigDecimal amount;
    private String currency;
}
