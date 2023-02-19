insert into customers (CUSTOMER_ID, first_name, last_name) values
(1,'srinivas', 'dornala'),
(2,'micky', 'mouse'),
(3,'donald', 'duck'),
(4,'david', 'boon'),
(5,'kapil', 'dev');

insert into sales_transactions (SALES_ID, amount, product_desc, quantity, transaction_date, CUSTOMERID_FK) values
    (1, 100, 'product1', 2, '2022-11-04',1),
    (2, 200, 'product2', 2, '2023-01-25',2),
    (3, 300, 'product3', 2, '2023-01-25',3),
    (4, 400, 'product4', 2, '2023-01-25',4),
    (5, 500, 'product5', 2, '2023-01-25',5),
    (6, 600, 'product6', 2, '2022-11-25',1),
	(7, 500, 'product5', 2, '2022-12-25',1),
	(8, 700, 'product5', 2, '2022-08-25',1),
	(9, 500, 'product5', 2, '2022-12-25',2),
	(10, 300, 'product5', 2, '2022-12-25',3),
	(11, 200, 'product5', 2, '2022-08-25',2),
	(12, 400, 'product5', 2, '2022-12-25',4),
	(13, 600, 'product5', 2, '2022-07-25',3),
	(14, 500, 'product5', 2, '2022-09-25',2);

insert into sales_rewards(REWARDS_ID, rewards, salesid_fk) values
    (1, 50,1),
    (2, 250,2),
    (3, 450,3),
    (4, 650,4),
    (5, 850,5),
    (6, 1050,6),
	(7, 850,7),
	(8, 1250,8),
	(9, 850,9),
	(10, 250,10),
	(11, 250,11),
	(12, 650,12),
    (13, 1050,13),
	(14, 850,14);