INSERT INTO customer (first_name, last_name, email, customer_status)
VALUES ('jeremy', 'komarov', 'k@gmail.com', 'VIP'),
       ('david', 'katz', 'daivd@gmail.com', 'VIP'),
       ('hen', 'cohen', 'hen@gmail.com', 'VIP'),
       ('yossi', 'levi', 'yossu@gmail.com', 'VIP'),
       ('david', 'abu', 'zach@gmail.com', 'VIP');

INSERT INTO customer_order(customer_id, item_name, price, delivery_id)
VALUES (1, 'Basketball', 30.00, 1),
       (1, 'Samsung', 22.00, 2),
       (2, 'Iphone', 35.00, null),
       (4, 'MacBook', 2000.00, null),
       (5, 'Mouse', 30.00, null),
       (1, 'keyboard', 30.00, null)