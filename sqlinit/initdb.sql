CREATE DATABASE IF NOT EXISTS testdb_airplane_business;
USE testdb_airplane_business;

CREATE TABLE IF NOT EXISTS `flights_info` (
                                `id` bigint NOT NULL AUTO_INCREMENT,
                                `created_by` varchar(100) NOT NULL DEFAULT '',
                                `created_date` datetime(6) NOT NULL,
                                `updated_by` varchar(100) DEFAULT '',
                                `updated_date` datetime(6) DEFAULT NULL,
                                `arrival_airport` varchar(255) DEFAULT NULL,
                                `arrival_time` datetime(6) DEFAULT NULL,
                                `departure_airport` varchar(255) DEFAULT NULL,
                                `departure_time` datetime(6) DEFAULT NULL,
                                `flight_number` varchar(255) DEFAULT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

Insert into testdb_airplane_business.flights_info (id, created_by, created_date, arrival_airport, arrival_time, departure_airport, departure_time, flight_number)
values (1, 'admin', '2024-07-20 02:00:59.58400', 'dubai', '2024-07-23 02:00:59.58400', 'dhaka', '2024-07-22 02:00:59.58400', 'DHKTODUB123'),
(2, 'admin', '2024-07-20 02:00:59.58400', 'abudhabi', '2024-07-25 02:00:59.58400', 'dhaka', '2024-07-24 02:00:59.58400', 'DHKTOABUDhabi123'),
(3, 'admin', '2024-07-20 02:00:59.58400', 'new york', '2024-07-25 02:00:59.58400', 'dhaka', '2024-07-23 02:00:59.58400', 'DHKTONY123'),
(4, 'admin', '2024-07-20 02:00:59.58400', 'london', '2024-07-28 02:00:59.58400', 'dhaka', '2024-07-26 02:00:59.58400', 'DHKTOLONDON123'),
(5, 'admin', '2024-07-20 02:00:59.58400', 'rome', '2024-08-03 02:00:59.58400', 'dhaka', '2024-08-01 02:00:59.58400', 'DHKTOROME123');

CREATE TABLE IF NOT EXISTS `passenger` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `email` varchar(255) DEFAULT NULL,
                             `first_name` varchar(255) DEFAULT NULL,
                             `last_name` varchar(255) DEFAULT NULL,
                             `phone_number` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

Insert into testdb_airplane_business.passenger (id, email, first_name, last_name, phone_number)
values (1, 'a@gmail.com', 'a', 'b', '01966767381'),
(2, 'b@gmail.com', 'x', 'y', '01966767382'),
(3, 'c@gmail.com', 'rifat', 'ahmed', '01966767383'),
(4, 'd@gmail.com', 'siam', 'khan', '01966767384');

CREATE TABLE IF NOT EXISTS `ticket` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `price` decimal(38,2) DEFAULT NULL,
                          `seat_number` varchar(255) DEFAULT NULL,
                          `sold_date` datetime(6) DEFAULT NULL,
                          `flight_id` bigint DEFAULT NULL,
                          `passenger_id` bigint DEFAULT NULL,
                          `total_seat` int DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `FKjlifmea6r8lm5wle2tr721w83` (`flight_id`),
                          KEY `FK3y0nr3g8pk6ygc173mjaaumgh` (`passenger_id`),
                          CONSTRAINT `FK3y0nr3g8pk6ygc173mjaaumgh` FOREIGN KEY (`passenger_id`) REFERENCES `passenger` (`id`),
                          CONSTRAINT `FKjlifmea6r8lm5wle2tr721w83` FOREIGN KEY (`flight_id`) REFERENCES `flights_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

Insert into testdb_airplane_business.ticket (id, price, seat_number, sold_date, flight_id, passenger_id, total_seat)
values (1, 4000, 'F1, F2', '2024-07-21 02:00:59.58400', 1, 1, 2),
(2, 2000, 'D1', '2024-07-21 02:00:59.58400', 1, 2, 1),
(3, 6000, 'E1, E2, E3', '2024-07-21 02:00:59.58400', 1, 3, 3),
(4, 2000, 'A1', '2024-07-22 02:00:59.58400', 1, 4, 1),
(5, 1000, 'A1', '2024-07-21 02:00:59.58400', 2, 1, 1),
(6, 3000, 'F1, F2, F3', '2024-07-22 02:00:59.58400',2, 2, 3),
(7, 1000, 'D1', '2024-07-22 02:00:59.58400', 2, 3, 1),
(8, 4000, 'B1, B2', '2024-07-23 02:00:59.58400', 2, 4, 2),
(9, 10000, 'A1, A2', '2024-07-21 02:00:59.58400', 3, 1, 2),
(10, 5000, 'F1', '2024-07-22 02:00:59.58400', 3, 2, 1),
(11, 10000, 'G1, G2', '2024-07-22 02:00:59.58400', 3, 3, 2),
(12, 5000, 'C1', '2024-07-23 01:00:59.58400', 3, 4, 1),
(13, 8000, 'F1, F2', '2024-07-22 02:00:59.58400', 4, 1, 2),
(14, 4000, 'E1', '2024-07-22 02:00:59.58400', 4, 2, 1),
(15, 8000, 'C1, C2', '2024-07-23 02:00:59.58400', 4, 4, 2),
(16, 24000, 'F1, F2, G1', '2024-07-29 02:00:59.58400', 5, 3, 2);

CREATE TABLE IF NOT EXISTS food_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
    );

CREATE TABLE IF NOT EXISTS `food_item` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `name` varchar(255) DEFAULT NULL,
                             `price` decimal(38,2) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

Insert into testdb_airplane_business.food_item (id, name, price)
values (1, 'cup-cake', 100),
 (2, 'caupaccino', 300),
 (3, 'chips', 50),
 (4, 'coke', 200);

CREATE TABLE IF NOT EXISTS `food_sales` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `quantity_sold` int DEFAULT NULL,
                              `sale_date` datetime(6) DEFAULT NULL,
                              `flight_id` bigint DEFAULT NULL,
                              `food_item_id` bigint DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `FKb4j672ln9tqns1gn3f03y5qm8` (`flight_id`),
                              KEY `FKcotymq41j1t2tc7ldmmctjw1m` (`food_item_id`),
                              CONSTRAINT `FKb4j672ln9tqns1gn3f03y5qm8` FOREIGN KEY (`flight_id`) REFERENCES `flights_info` (`id`),
                              CONSTRAINT `FKcotymq41j1t2tc7ldmmctjw1m` FOREIGN KEY (`food_item_id`) REFERENCES `food_item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

Insert into testdb_airplane_business.food_sales (id, quantity_sold, sale_date, flight_id, food_item_id)
values (1, 20, '2024-07-22 02:00:59.58400', 1, 1),
(2, 10, '2024-07-22 02:00:59.58400', 1, 2),
(3, 15, '2024-07-22 02:00:59.58400', 1, 3),
(4, 2, '2024-07-22 02:00:59.58400', 1, 4),
(5, 10, '2024-07-24 02:00:59.58400', 2, 1),
(6, 3, '2024-07-24 02:00:59.58400', 2, 2),
(7, 4, '2024-07-24 02:00:59.58400', 2, 3),
(8, 20, '2024-07-24 02:00:59.58400', 2, 4),
(9, 10, '2024-07-23 02:00:59.58400', 3, 1),
(10, 3, '2024-07-23 02:00:59.58400', 3, 2),
(11, 4, '2024-07-26 02:00:59.58400', 3, 3),
(12, 20, '2024-07-26 02:00:59.58400', 3, 4),
(13, 4, '2024-07-26 02:00:59.58400', 3, 3),
(14, 20, '2024-08-01 02:00:59.58400', 4, 4),
(15, 100, '2024-08-01 02:00:59.58400', 4, 1);
