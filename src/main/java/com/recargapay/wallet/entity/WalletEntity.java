package com.recargapay.wallet.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@Builder
@Table("wallet")
public class WalletEntity {
    @Id
    private Long id;
    @Column("user_name")
    private String userName;
    private BigDecimal balance;
    private String currency;
}
