package com.recargapay.wallet.service.impl;

import com.recargapay.wallet.mapper.WalletMapper;
import com.recargapay.wallet.model.WalletRequest;
import com.recargapay.wallet.model.WalletResponse;
import com.recargapay.wallet.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class WalletServiceImplTest {

    @Mock
    private WalletRepository walletRepository;

    @InjectMocks
    private WalletServiceImpl walletService;

    public WalletServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateWallet() {
        WalletRequest request = WalletRequest.builder()
                .userName("test")
                .currency("USD")
                .build();

        when(walletRepository.save(any())).thenReturn(Mono.just(WalletMapper.toEntity(request)));

        Mono<WalletResponse> responseMono = walletService.createWallet(request);

        WalletResponse response = responseMono.block(); // Block to get the value from Mono
        assertEquals("test", response.getUserName());
        assertEquals("USD", response.getCurrency());
        assertEquals("0", response.getBalance());
    }

}