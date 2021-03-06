DROP DATABASE LOJA;

CREATE DATABASE LOJA;
USE LOJA;

CREATE TABLE CATEGORIAS (
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(100) 
);

CREATE TABLE CLIENTES(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(100),
	EMAIL VARCHAR(100),
	ENDERECO VARCHAR(255),
	BAIRRO VARCHAR(50),
	CIDADE VARCHAR(50),
	ESTADO VARCHAR(2),
	CEP VARCHAR(8)
);

CREATE TABLE PRODUTOS(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(40),
	PRECO DOUBLE,
	PRECO_DESC DOUBLE,
	DESCONTO DOUBLE,
	DESC_PQNA VARCHAR(255),
	DESC_GND TEXT,
	IMAGEM VARCHAR(255),
	QTD_ESTOQUE INTEGER DEFAULT 10
);

CREATE TABLE PEDIDOS(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	ID_CLIENTE BIGINT,
	CC_NOME VARCHAR(100),
	CC_BANDEIRA VARCHAR(2),
	CC_NUMERO VARCHAR(20),
	DATA_PEDIDO TIMESTAMP,
	FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTES(ID)
);

CREATE TABLE ITENS_PEDIDO(
	ID_PEDIDO BIGINT NOT NULL,
	ID_PRODUTO BIGINT NOT NULL,
	QTD INTEGER,
	PRECO DOUBLE,
	PRIMARY KEY (ID_PEDIDO,ID_PRODUTO),
	FOREIGN KEY (ID_PEDIDO) REFERENCES PEDIDOS(ID),
	FOREIGN KEY (ID_PRODUTO) REFERENCES PRODUTOS(ID)
);

INSERT INTO CLIENTES (NOME,EMAIL) VALUES ("ARISTENIO","ARISTENIO@GMAIL.COM");
INSERT INTO CLIENTES (NOME,EMAIL) VALUES ("JOAO","JOAO@GMAIL.COM");

INSERT PRODUTOS (NOME,PRECO,DESCONTO) VALUES ("ARROZ",2.75,0.90);
INSERT PRODUTOS (NOME,PRECO,DESCONTO) VALUES ("FEIJAO",3.75,0.90);
INSERT PRODUTOS (NOME,PRECO,DESCONTO) VALUES ("LARANJA",4.75,0.90);
INSERT PRODUTOS (NOME,PRECO,DESCONTO) VALUES ("MAÇA",3.75,0.90);

DELIMITER $$

CREATE TRIGGER TGR_ATUALIZAESTOQUE_INSERT AFTER INSERT 
ON ITENS_PEDIDO
FOR EACH ROW
BEGIN
	UPDATE PRODUTOS SET QTD_ESTOQUE = QTD_ESTOQUE - NEW.QTD
	WHERE ID = NEW.ID_PRODUTO;
END$$

CREATE TRIGGER TGR_ATUALIZAESTOQUE_DELETE AFTER DELETE 
ON ITENS_PEDIDO
FOR EACH ROW
BEGIN
	UPDATE PRODUTOS SET QTD_ESTOQUE = QTD_ESTOQUE + OLD.QTD
	WHERE ID = OLD.ID_PRODUTO;
END$$

#CREATE TRIGGER TGR_CALCULAPRECO BEFORE INSERT 
#ON ITENS_PEDIDO
#FOR EACH ROW
#BEGIN
#	UPDATE ITENS_PEDIDO SET PRECO = NEW.QTD * (SELECT P.PRECO FROM PRODUTOS P WHERE P.ID = NEW.ID_PRODUTO)
#	WHERE ID_PRODUTO = NEW.ID_PRODUTO AND ID_PEDIDO = NEW.ID_PEDIDO;
#END$$

CREATE TRIGGER TGR_ATUALIZAESTOQUE_INSERT BEFORE INSERT 
ON ITENS_PEDIDO
FOR EACH ROW SET @PRECO = NEW.QTD * (SELECT P.PRECO FROM PRODUTOS P WHERE P.ID = NEW.ID_PRODUTO);$$

DELIMITER ;

DROP TRIGGER TGR_ATUALIZAESTOQUE_INSERT;

SELECT NOME,PRECO,QTD_ESTOQUE FROM PRODUTOS WHERE ID = 1;

INSERT INTO PEDIDOS (ID_CLIENTE) VALUES (1);

INSERT INTO ITENS_PEDIDO (ID_PEDIDO,ID_PRODUTO,QTD) VALUES (1,1,3);
DELETE FROM ITENS_PEDIDO WHERE ID_PEDIDO = 1 AND ID_PRODUTO = 1;

INSERT INTO PEDIDOS (ID_CLIENTE) VALUES (2);

SET @PRECO = 0;
INSERT INTO ITENS_PEDIDO (ID_PEDIDO,ID_PRODUTO,QTD) VALUES (2,2,3);
SELECT @PRECO AS PRECO_ITEM;

DELETE FROM ITENS_PEDIDO WHERE ID_PEDIDO = 2 AND ID_PRODUTO = 2;

DELIMITER $$

CREATE PROCEDURE SELECIONAR_PRODUTO(IN QTDPROD INT)
BEGIN
	SELECT * FROM PRODUTOS LIMIT QTDPROD;
END$$

CREATE PROCEDURE CONSULTAR_QTD_PRODUTOS(OUT QUANTIDADE INT)
BEGIN
	SELECT COUNT(*) INTO QUANTIDADE FROM PRODUTOS;
END$$

CREATE PROCEDURE CALCULAR(INOUT NUMERO INT)
BEGIN
	DECLARE VARIAVEL INT DEFAULT 1;
	SET NUMERO = (NUMERO * NUMERO) + VARIAVEL;
END$$

CREATE FUNCTION HELLO (STR CHAR(20))
RETURNS CHAR(50)
RETURN CONCAT("HELLO",STR)$$


DELIMITER ;

CALL SELECIONAR_PRODUTO(13);

CALL CONSULTAR_QTD_PRODUTOS(@TOTAL);
SELECT @TOTAL;

SET @VALOR = 5;
CALL CALCULAR(@VALOR);
SELECT @VALOR;

SET @STRSTR = HELLO("TESTE");
SELECT @STRSTR;

SELECT HELLO("ARISTENIO");