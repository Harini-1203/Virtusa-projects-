CREATE TABLE Categories (
    category_id INT PRIMARY KEY,
    category_name varchar(50)
);

create table Products (
    product_id int primary key,
    product_name varchar(50),
    product_price int,
    expiry_date date,
    stock_count int,
    category_id int,
    FOREIGN KEY(category_id) references categories(category_id)
);

insert into categories values
(100,'dry fruits'),
(101,'dairy'),
(102,'stationary'),
(103,'drinks'),
(104,'pulses'),
(105,'fruits'),
(106,'vegetables');

INSERT INTO products (product_id, product_name, product_price, expiry_date, stock_count, category_id)
VALUES
(1, 'cashew nut', 300, CURRENT_DATE + INTERVAL 60 DAY, 30, 100),
(2, 'almond', 400, CURRENT_DATE + INTERVAL 80 DAY, 20, 100),
(3, 'walnut', 450, CURRENT_DATE + INTERVAL 40 DAY, 40, 100),
(4, 'pistachio', 600, CURRENT_DATE + INTERVAL 90 DAY, 25, 100),
(5, 'milk', 50, CURRENT_DATE + INTERVAL 2 DAY, 30, 101),
(6, 'curd', 60, CURRENT_DATE + INTERVAL 5 DAY, 50, 101),
(7, 'ghee', 500, CURRENT_DATE + INTERVAL 30 DAY, 20, 101),
(8, 'paneer', 200, CURRENT_DATE + INTERVAL 7 DAY, 35, 101),
(9, 'notebook', 80, NULL, 100, 102),
(10, 'pen pack', 50, NULL, 150, 102),
(11, 'cola', 40, CURRENT_DATE + INTERVAL 120 DAY, 80, 103),
(12, 'orange juice', 90, CURRENT_DATE + INTERVAL 15 DAY, 45, 103),
(13, 'energy drink', 110, CURRENT_DATE + INTERVAL 200 DAY, 60, 103),
(14, 'toor dal', 120, CURRENT_DATE + INTERVAL 180 DAY, 70, 104),
(15, 'moong dal', 110, CURRENT_DATE + INTERVAL 150 DAY, 65, 104),
(16, 'apple', 150, CURRENT_DATE + INTERVAL 10 DAY, 90, 105),
(17, 'banana', 60, CURRENT_DATE + INTERVAL 3 DAY, 120, 105),
(18, 'grapes', 80, CURRENT_DATE + INTERVAL 4 DAY, 75, 105),
(19, 'tomato', 40, CURRENT_DATE + INTERVAL 5 DAY, 100, 106),
(20, 'potato', 30, CURRENT_DATE + INTERVAL 20 DAY, 200, 106),
(21, 'carrot', 50, CURRENT_DATE + INTERVAL 7 DAY, 85, 106);


create table sales_transactions (
	t_id int primary key,
    product_id int,
    purchase_date datetime default current_timestamp,
    quantity int,
    foreign key (product_id) references products(Product_id)
);
INSERT INTO sales_transactions (t_id,product_id,quantity) VALUES 
(1, 1, 10),
(2, 5, 20),
(3, 8, 15),
(4, 12, 5);

INSERT INTO sales_transactions (t_id, product_id, purchase_date, quantity) VALUES
(5, 1, CURRENT_DATE - INTERVAL 25 DAY, 12),
(6, 2, CURRENT_DATE - INTERVAL 28 DAY, 8),
(7, 5, CURRENT_DATE - INTERVAL 20 DAY, 15),
(8, 8, CURRENT_DATE - INTERVAL 18 DAY, 10),
(9, 12, CURRENT_DATE - INTERVAL 22 DAY, 6),
(10, 3, CURRENT_DATE - INTERVAL 45 DAY, 9),
(11, 4, CURRENT_DATE - INTERVAL 50 DAY, 7),
(12, 6, CURRENT_DATE - INTERVAL 48 DAY, 14),
(13, 7, CURRENT_DATE - INTERVAL 55 DAY, 5),
(14, 10, CURRENT_DATE - INTERVAL 52 DAY, 11);

-- expiring soon
select * from products where expiry_date between CURRENT_DATE and current_date+interval 7 day
and stock_count>50;

-- deadstock Analysis
select p.product_id,p.product_name
from
products p  left join sales_transactions s 
on p.product_id=s.product_id and s.purchase_date>= current_date -interval 60 day
where s.product_id is null;

-- Revenue contribution
select c.category_name, sum(s.quantity*p.product_price) as returns from
 sales_transactions s join products p on s.product_id=p.product_id
 join categories c on c.category_id = p.category_id
WHERE s.purchase_date >= DATE_FORMAT(CURRENT_DATE - INTERVAL 1 MONTH, '%Y-%m-01')
AND s.purchase_date < DATE_FORMAT(CURRENT_DATE, '%Y-%m-01')
group by c.category_name;
