-- Insert users
INSERT INTO users (username, password, role) VALUES ('neeraja', 'secure123', 'CUSTOMER');
INSERT INTO users (username, password, role) VALUES ('admin', 'admin123', 'ADMIN');

-- Insert accounts
INSERT INTO accounts (account_number, account_type, balance, status, user_id)
VALUES ('1234567890', 'SAVINGS', 10000.0, 'ACTIVE', 1);

INSERT INTO accounts (account_number, account_type, balance, status, user_id)
VALUES ('9876543210', 'CURRENT', 5000.0, 'ACTIVE', 2);

-- Insert transactions
INSERT INTO transactions (from_account_id, to_account_id, transfer_type, amount, timestamp, status, account_id)
VALUES (1, 2, 'UPI', 500.0, CURRENT_TIMESTAMP, 'SUCCESS', 1);

-- Insert notifications
INSERT INTO notifications (to_email, subject, message)
VALUES ('neeraja@example.com', 'Transaction Alert', 'Your transaction of ₹500 was successful.');