CREATE DATABASE IF NOT EXISTS command_center_db;
USE command_center_db;

CREATE TABLE clients (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL
);

CREATE TABLE commands (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          control_number VARCHAR(255) UNIQUE NOT NULL,
                          registration_date DATETIME NOT NULL,
                          product_name VARCHAR(255) NOT NULL,
                          unit_price DECIMAL(10, 2) NOT NULL,
                          quantity INT DEFAULT 1,
                          total_price DECIMAL(10, 2) NOT NULL, -- Considerar calcular dinamicamente
                          client_code INT NOT NULL,
                          FOREIGN KEY (client_code) REFERENCES clients(id)
);
