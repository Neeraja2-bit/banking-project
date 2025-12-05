CREATE TABLE IF NOT EXISTS users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255),
                       password VARCHAR(255),
                       role VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS accounts (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          account_number VARCHAR(255),
                          account_type VARCHAR(255),
                          balance DOUBLE,
                          status VARCHAR(255),
                          user_id BIGINT, -- Foreign key to users table
                          FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS transactions (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              from_account_id BIGINT,
                              to_account_id BIGINT,
                              transfer_type VARCHAR(255),
                              amount DOUBLE,
                              timestamp TIMESTAMP,
                              status VARCHAR(255),
                              account_id BIGINT,
                              FOREIGN KEY (account_id) REFERENCES accounts(id)
);
CREATE TABLE IF NOT EXISTS notifications
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    to_email VARCHAR(255),
    subject  VARCHAR(255),
    message  VARCHAR(255)
)
