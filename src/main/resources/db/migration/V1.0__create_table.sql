DROP TABLE IF EXISTS orders_table;
DROP TABLE IF EXISTS cars_table;
DROP TABLE IF EXISTS users_table;

CREATE TABLE users_table(
user_id BIGSERIAL PRIMARY KEY,
user_name VARCHAR(50),
user_email VARCHAR(100) UNIQUE,
user_password VARCHAR(100),
user_address VARCHAR(100),
user_blocked BOOL DEFAULT FALSE,
user_role VARCHAR(50)
);


CREATE TABLE cars_table(
car_id BIGSERIAL PRIMARY KEY,
car_model VARCHAR(50),
car_release_Year VARCHAR(50),
car_color VARCHAR(50),
car_company VARCHAR(50)
);

CREATE TABLE orders_table(
order_id BIGSERIAL PRIMARY KEY,
user_id BIGINT REFERENCES users_table(user_id),
car_id BIGINT,
order_date DATE ,
return_date DATE,
car_returned BOOL,
rental_cost NUMERIC(7,2),
FOREIGN KEY(car_id) REFERENCES cars_table(car_Id)
);
