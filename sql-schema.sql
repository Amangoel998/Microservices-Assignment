CREATE DATABASE product_catalogue_db;

USE DATABASE product_catalogue_db;
CREATE TABLE products(
    product_id INT(5) AUTO_INCREMENT PRIMARY KEY,
    product_name varchar(30) UNIQUE NOT NULL,
    product_category varchar(30) NOT NULL
);
INSERT INTO products VALUE
    (10001, 'Samsung Galaxy 20', 'smartphone'),
    (10002, 'Apple X1', 'smartphone'),
    (10003, 'Oneplus 8', 'smartphone');
INSERT INTO products(product_name, product_category) VALUE
    ('Dell Inspiron 3481', 'laptop'),
    ('Dell Vostro 3480', 'laptop'),
    ('HP Pavillion x360', 'laptop'),
    ('HP Envy 13-AQ', 'laptop'),
    ('HP Omen Core i5', 'laptop'),
    ('JBL T160BT', 'headset'),
    ('SkullCandy Jib ', 'headset'),
    ('JBL C100TWS', 'headset'),
    ('Apple AirPods', 'headset'),
    ('MI PowerBank 10K', 'powerbank'),
    ('Syska Powerbank 20K', 'powerbank'),
    ('Apple Watch Series 3', 'smartwatch'),
    ('Samsung Galaxy Watch', 'smartwatch'),
    ('Fitbit Versa Lite', 'smartwatch'),
    ('MI Smart Band 3i', 'smartwatch'),
    ('Google Home', 'smartspeaker'),
    ('Alexa Echo', 'smartspeaker');



CREATE DATABASE products_price_db;
USE products_price_db;
CREATE TABLE products_price(
    product_id INT(5) AUTO_INCREMENT PRIMARY KEY,
    product_price Decimal(10,2) NOT NULL
);
INSERT INTO products_price VALUE (10001, 55299.99);
INSERT INTO products_price(product_price) VALUE
    (96729.90),(82399.50),(57699.80),(35399.60),(64599.50),(82699.90),(87349.90),(1699.00),(1389.80),(4299.90),(15999.40),(2249.50),(2899.80),(23999.80),(16799.70),(4569.60),(1899.90),(2999.90),(4299.50);




CREATE DATABASE products_stock_db;
USE products_stock_db;
CREATE TABLE products_stock(
    product_id INT(5) AUTO_INCREMENT PRIMARY KEY,
    product_stock INT(5) NOT NULL
);
INSERT INTO products_stock VALUE (10001, 50);
INSERT INTO products_stock(product_stock) VALUE
    (40),(35),(29),(25),(24),(18),(31),(75),(85),(45),(25),(65),(56),(26),(22),(36),(34),(19),(27);



CREATE DATABASE product_recommendation_db;
USE product_recommendation_db;




CREATE DATABASE user_shopcart_db;
USE user_shopcart_db;
CREATE TABLE shopcart_items(
    order_id INT(10) AUTO_INCREMENT PRIMARY KEY,
    user_id INT(8) NOT NULL,
    product_id INT(8) NOT NULL,
    quantity INT(3) NOT NULL CHECK(quantity>0)
);
INSERT INTO shopcart_items VALUES (1001, 1001, 10001, 1);