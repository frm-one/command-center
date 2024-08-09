controllerCREATE DATABASE IF NOT EXISTS pedidos_db;
USE pedidos_db;

CREATE TABLE cliente (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         nome VARCHAR(255) NOT NULL
);

CREATE TABLE pedido (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        numero_controle VARCHAR(255) UNIQUE NOT NULL,
                        data_cadastro DATETIME NOT NULL,
                        nome_produto VARCHAR(255) NOT NULL,
                        valor_unitario DECIMAL(10, 2) NOT NULL,
                        quantidade INT DEFAULT 1,
                        valor_total DECIMAL(10, 2) NOT NULL,
                        codigo_cliente INT NOT NULL,
                        FOREIGN KEY (codigo_cliente) REFERENCES cliente(id)
);
