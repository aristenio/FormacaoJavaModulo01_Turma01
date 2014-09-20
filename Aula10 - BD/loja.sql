CREATE DATABASE LOJA;

CREATE TABLE CATEGORIA (
	ID BIGINT,
	NOME VARCHAR(100) 
);

CREATE TABLE USUARIOS(
	ID BIGINT,
	NOME VARCHAR(100),
	EMAIL VARCHAR(100),
	SENHA VARCHAR(20),
	ENDERECO VARCHAR(255),
	BAIRRO VARCHAR(50),
	CIDADE VARCHAR(50),
	ESTADO VARCHAR(2),
	CEP VARCHAR(8)
);

CREATE TABLE PRODUTOS(
	ID BIGINT,
	NOME VARCHAR(40),
	PRECO DOUBLE,
	DESCONTO DOUBLE,
	DESC_PQNA VARCHAR(255),
	DESC_GND TEXT,
	IMAGEM VARCHAR(255)
);

CREATE TABLE ITENS_PEDIDO(
	ID BIGINT,
	QTD INTEGER,
	PRECO DOUBLE
);

CREATE TABLE PEDIDO(
	ID BIGINT,
	CC_NOME VARCHAR(100),
	CC_BANDEIRA VARCHAR(2),
	CC_NUMERO VARCHAR(20),
	DATA_PEDIDO TIMESTAMP
);