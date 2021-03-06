/*DELETAR BASE DE DADOS*/
DROP DATABASE FORMACAOJAVA1;
/*CRIAR BASE DE DADOS*/
CREATE DATABASE FORMACAOJAVA1;
/*USAR BASE DE DADOS*/
USE FORMACAOJAVA1;

/*CRIAR TABELAS*/
CREATE TABLE TABELA1(
	CAMPO1 VARCHAR(255),
	CAMPO2 DOUBLE
);

/*LISTAS TABELAS*/
SHOW TABLES;

/*DELETAR TABELAS*/
DROP TABLE TABELA1;

/*ALTERAR TABELA - RENOMEAR*/
ALTER TABLE TABELA1 RENAME TABELA;

/*ALTERAR TABELA - ADICIONAR CAMPO*/
ALTER TABLE TABELA ADD CAMPO3 INTEGER;

/*ALTERAR TABELA - REMOVER CAMPO*/
ALTER TABLE TABELA DROP CAMPO3;

ALTER TABLE TABELA ADD CAMPO3 INTEGER NOT NULL;
ALTER TABLE TABELA ADD CAMPO4 INTEGER NOT NULL UNIQUE;
