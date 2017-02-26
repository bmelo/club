-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE socios (
id smallint PRIMARY KEY,
cpf character varying(11) UNIQUE,
nome character varying(50),
saldo numeric(10,2),
endereco character varying(100),
cep character varying(9),
bairro character varying(50),
cidade character varying(30),
uf character varying(2)
)

CREATE TABLE socios_dependentes (
id smallint PRIMARY KEY,
id_socio smallint,
nome character varying(50),
FOREIGN KEY(id_socio) REFERENCES socios (id)
)

CREATE TABLE produtos (
id smallint PRIMARY KEY,
nome character varying(80) UNIQUE,
valor numeric(10,2),
descricao character varying(200)
)

