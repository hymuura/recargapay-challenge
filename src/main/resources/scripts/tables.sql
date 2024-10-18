CREATE TABLE transfer
(
    id               BIGSERIAL PRIMARY KEY,
    wallet_source_id BIGINT         NOT NULL,
    wallet_target_id BIGINT         NOT NULL,
    amount           NUMERIC(19, 2) NOT NULL,
    currency         VARCHAR(10)    NOT NULL
);

CREATE TABLE wallet
(
    id        BIGSERIAL PRIMARY KEY,
    user_name VARCHAR(100)   NOT NULL,
    currency  VARCHAR(10)    NOT NULL,
    balance   NUMERIC(19, 2) NOT NULL
);