/*
Created		26/11/2008
Modified		26/11/2008
Project		
Model			
Company		
Author		
Version		
Database		PostgreSQL 8.1 
*/


/* Create Tables */


Create table "socios"
(
	"id" Smallint NOT NULL,
	"nome" Varchar(50),
	"cpf" Varchar(11) Constraint "UCPF" UNIQUE,
	"saldo" Numeric(10,2) Default 0.00,
	"endereco" Varchar(100),
	"cep" Varchar(9),
	"bairro" Varchar(50),
	"cidade" Varchar(30),
	"uf" Varchar(20),
 primary key ("id")
) Without Oids;


Create table "socios_dependentes"
(
	"id" Smallint NOT NULL,
	"id_socio" Smallint NOT NULL,
	"nome" Varchar(50) NOT NULL,
 primary key ("id","id_socio")
) Without Oids;


Create table "produtos"
(
	"id" Smallint NOT NULL,
	"nome" Varchar(80) Constraint "UNOME" UNIQUE,
	"valor" Numeric(10,2),
	"descricao" Varchar(200),
 primary key ("id")
) Without Oids;



/* Create Alternate Keys */



/* Create Foreign Keys */

Alter table "socios_dependentes" add  foreign key ("id_socio") references "socios" ("id") on update restrict on delete restrict;





