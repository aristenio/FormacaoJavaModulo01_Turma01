CREATE DATABASE SYSBANK;

USE SYSBANK;

CREATE TABLE BANCO(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(50),
	SIGLE VARCHAR(3),
	CODIGO VARCHAR(4) UNIQUE
);

INSERT INTO BANCO (NOME,SIGLE,CODIGO) VALUES ("BANCO DO BRASIL","BB","001");
INSERT INTO BANCO (NOME,SIGLE,CODIGO) VALUES ("CAIXA ECONOMICA","CXE","002");
INSERT INTO BANCO (NOME,SIGLE,CODIGO) VALUES ("BRADESCO","BRA","004");

SELECT * FROM BANCO;

CREATE TABLE AGENCIA(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(50),
	CODIGO VARCHAR(4),
	BANCO_ID BIGINT,
	FOREIGN KEY(BANCO_ID) REFERENCES BANCO(ID),
	UNIQUE INDEX(CODIGO,BANCO_ID)
);

INSERT INTO AGENCIA (NOME,CODIGO,BANCO_ID) VALUES ("AGE1","001",1);
INSERT INTO AGENCIA (NOME,CODIGO,BANCO_ID) VALUES ("AGE2","002",1);
INSERT INTO AGENCIA (NOME,CODIGO,BANCO_ID) VALUES ("AGE3","003",1);
INSERT INTO AGENCIA (NOME,CODIGO,BANCO_ID) VALUES ("AGE12","001",2);
INSERT INTO AGENCIA (NOME,CODIGO,BANCO_ID) VALUES ("AGE22","002",2);
INSERT INTO AGENCIA (NOME,CODIGO,BANCO_ID) VALUES ("AGE33","003",2);
INSERT INTO AGENCIA (NOME,CODIGO,BANCO_ID) VALUES ("AGE13","001",3);

SELECT * FROM AGENCIA;

CREATE TABLE CLIENTE(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(255),
	EMAIL VARCHAR(100) UNIQUE,
	SEXO ENUM("M","F")
);

CREATE TABLE PERFIL(
	ID BIGINT PRIMARY KEY,
	PROFISSAO VARCHAR(255),
	HOBBIES VARCHAR(255),
	GOSTO_MUSICAL VARCHAR(255),
	FOREIGN KEY(ID) REFERENCES CLIENTE(ID)
);

CREATE TABLE CONTABANCARIA(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	ID_AGENCIA BIGINT NOT NULL,
	ID_CLIENTE BIGINT NOT NULL,
	SALDO DOUBLE,
	LIMITE DOUBLE,
	FOREIGN KEY(ID_AGENCIA) REFERENCES AGENCIA(ID),
	FOREIGN KEY(ID_CLIENTE) REFERENCES CLIENTE(ID)
);

SELECT * FROM AGENCIA;

INSERT INTO CLIENTE (NOME,EMAIL,SEXO) VALUES ("ARISTENIO","ARISTENIO@GMAIL.COM","M");
INSERT INTO CLIENTE (NOME,EMAIL,SEXO) VALUES ("ANTONIO","ANTONIO@GMAIL.COM","M");
INSERT INTO CLIENTE (NOME,EMAIL,SEXO) VALUES ("MARIA","MARIA@GMAIL.COM","F");
INSERT INTO CLIENTE (NOME,EMAIL,SEXO) VALUES ("JOANA","JOANA@GMAIL.COM","F");

INSERT INTO PERFIL VALUES (1,"ANALISTA DE SISTEMAS","LEITURA","ROCK");
INSERT INTO PERFIL VALUES (2,"MEDICO","BICICLETA","SAMBA");
INSERT INTO PERFIL VALUES (3,"RECEPCIONISTA","LEITURA","PAGODE");

INSERT INTO CONTABANCARIA (ID_AGENCIA, ID_CLIENTE, SALDO, LIMITE) VALUES (1,1,1500,1000);
INSERT INTO CONTABANCARIA (ID_AGENCIA, ID_CLIENTE, SALDO, LIMITE) VALUES (1,2,2500,1000);
INSERT INTO CONTABANCARIA (ID_AGENCIA, ID_CLIENTE, SALDO, LIMITE) VALUES (2,3,700,1000);
INSERT INTO CONTABANCARIA (ID_AGENCIA, ID_CLIENTE, SALDO, LIMITE) VALUES (2,4,1200,1000);

SELECT * FROM CLIENTE AS C, PERFIL AS P 
WHERE P.ID = C.ID 
AND C.ID = 1;

SELECT * 
FROM CLIENTE AS C
JOIN PERFIL AS P
ON C.ID = P.ID
WHERE C.SEXO = "M";

SELECT * 
FROM CLIENTE AS C
JOIN PERFIL AS P
ON C.ID = P.ID
JOIN CONTABANCARIA AS CB
ON C.ID = CB.ID_CLIENTE;

SELECT C.NOME,C.EMAIL,C.SEXO,
P.PROFISSAO, CB.SALDO, CB.LIMITE 
FROM CLIENTE AS C
JOIN PERFIL AS P
ON C.ID = P.ID
JOIN CONTABANCARIA AS CB
ON C.ID = CB.ID_CLIENTE;

SELECT C.NOME,C.EMAIL,C.SEXO,
P.PROFISSAO, A.NOME, CB.SALDO, CB.LIMITE
FROM CLIENTE AS C
JOIN PERFIL AS P
ON C.ID = P.ID
JOIN CONTABANCARIA AS CB
ON C.ID = CB.ID_CLIENTE
JOIN AGENCIA AS A
ON CB.ID_AGENCIA = A.ID
ORDER BY C.NOME;

SELECT C.NOME,C.EMAIL,C.SEXO,
P.PROFISSAO, A.NOME, CB.SALDO, CB.LIMITE
FROM CLIENTE AS C
LEFT OUTER JOIN PERFIL AS P
ON C.ID = P.ID
JOIN CONTABANCARIA AS CB
ON C.ID = CB.ID_CLIENTE
JOIN AGENCIA AS A
ON CB.ID_AGENCIA = A.ID
ORDER BY C.NOME;

SELECT C.NOME,C.EMAIL,C.SEXO,
P.PROFISSAO, A.NOME, CB.SALDO, CB.LIMITE
FROM CLIENTE AS C
LEFT OUTER JOIN PERFIL AS P
ON C.ID = P.ID
JOIN CONTABANCARIA AS CB
ON C.ID = CB.ID_CLIENTE
JOIN AGENCIA AS A
ON CB.ID_AGENCIA = A.ID
WHERE P.ID IS NULL
ORDER BY C.NOME;

CREATE TABLE PROFISSOES(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	DESCRICAO VARCHAR(255) 
);

INSERT INTO PROFISSOES (DESCRICAO) VALUES ("ENGENHEIRO");
INSERT INTO PROFISSOES (DESCRICAO) VALUES ("MEDICO");
INSERT INTO PROFISSOES (DESCRICAO) VALUES ("ANALISTA DE SISTEMAS");
INSERT INTO PROFISSOES (DESCRICAO) VALUES ("CONTADOR");

ALTER TABLE PERFIL ADD ID_PROFISSAO BIGINT NOT NULL DEFAULT 1;
ALTER TABLE PERFIL ADD FOREIGN KEY(ID_PROFISSAO) REFERENCES PROFISSOES(ID);

SELECT C.NOME,C.EMAIL,C.SEXO,
PRF.DESCRICAO, A.NOME, CB.SALDO, CB.LIMITE
FROM CLIENTE AS C
LEFT OUTER JOIN PERFIL AS P
ON C.ID = P.ID
INNER JOIN CONTABANCARIA AS CB
ON C.ID = CB.ID_CLIENTE
INNER JOIN AGENCIA AS A
ON CB.ID_AGENCIA = A.ID
INNER JOIN PROFISSOES PRF
ON P.ID_PROFISSAO = PRF.ID
ORDER BY C.NOME;

UPDATE PERFIL SET ID_PROFISSAO = 2 WHERE ID = 2;
UPDATE PERFIL SET ID_PROFISSAO = 3 WHERE ID = 3;

SELECT C.NOME,C.EMAIL,C.SEXO,
PRF.DESCRICAO
FROM CLIENTE AS C
INNER JOIN PERFIL AS P
ON C.ID = P.ID
INNER JOIN PROFISSOES PRF
ON P.ID_PROFISSAO = PRF.ID;

SELECT C.NOME,C.EMAIL,C.SEXO,
PRF.DESCRICAO
FROM CLIENTE AS C
INNER JOIN PERFIL AS P
ON C.ID = P.ID
RIGHT OUTER JOIN PROFISSOES PRF
ON P.ID_PROFISSAO = PRF.ID;

SELECT C.NOME,C.EMAIL,C.SEXO,
PRF.DESCRICAO
FROM CLIENTE AS C
INNER JOIN PERFIL AS P
ON C.ID = P.ID
RIGHT OUTER JOIN PROFISSOES PRF
ON P.ID_PROFISSAO = PRF.ID
WHERE P.ID IS NULL;

SELECT C.NOME,C.EMAIL,C.SEXO,
PRF.DESCRICAO
FROM CLIENTE AS C
INNER JOIN PERFIL AS P
ON C.ID = P.ID
INNER JOIN PROFISSOES PRF
ON P.ID_PROFISSAO = PRF.ID
UNION
SELECT C.NOME,C.EMAIL,C.SEXO,
PRF.DESCRICAO
FROM CLIENTE AS C
INNER JOIN PERFIL AS P
ON C.ID = P.ID
RIGHT OUTER JOIN PROFISSOES PRF
ON P.ID_PROFISSAO = PRF.ID;


CREATE VIEW VW_CONTABANCARIACOMPLETA AS
SELECT C.NOME AS NOME_CLI,C.EMAIL AS EMAIL_CLI,C.SEXO AS SEX_CLI,
PRF.DESCRICAO PRF_DESC
FROM CLIENTE AS C
INNER JOIN PERFIL AS P
ON C.ID = P.ID
INNER JOIN PROFISSOES PRF
ON P.ID_PROFISSAO = PRF.ID
UNION
SELECT C.NOME,C.EMAIL,C.SEXO,
PRF.DESCRICAO
FROM CLIENTE AS C
INNER JOIN PERFIL AS P
ON C.ID = P.ID
RIGHT OUTER JOIN PROFISSOES PRF
ON P.ID_PROFISSAO = PRF.ID;

SELECT * FROM VW_CONTABANCARIACOMPLETA;

DROP VIEW VW_CONTABANCARIACOMPLETA;

CREATE VIEW VW_CLIENTE AS 
SELECT C.ID AS CLI_ID, C.NOME AS NOME_CLI,C.EMAIL AS EMAIL_CLI,C.SEXO AS SEX_CLI
FROM CLIENTE AS C
INNER JOIN PERFIL AS P
ON C.ID = P.ID;

ALTER VIEW VW_CLIENTE AS 
SELECT C.ID AS CLI_ID, C.NOME AS NOME_CLI,C.EMAIL AS EMAIL_CLI,C.SEXO AS SEX_CLI, P.HOBBIES CLI_HOBBIES
FROM CLIENTE AS C
INNER JOIN PERFIL AS P
ON C.ID = P.ID;

DROP VIEW VW_CLIENTE;


SELECT * 
FROM VW_CLIENTE VW_C
INNER JOIN contabancaria CB ON CB.ID_CLIENTE = VW_C.CLI_ID

