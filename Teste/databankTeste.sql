--Database

--EDITADO POR ULTIMO:
--VINIE - 16/11/23

--************************************************************************************************
create database if not exists TesteJava;
use TesteJava;

CREATE TABLE if not exists Funcionario (
    idFuncionario int NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    idade int NOT NULL,
    email varchar(255),
    PRIMARY KEY (idFuncionario)
);

CREATE TABLE if not exists Cliente (
    idCliente int NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    idade int NOT NULL,
    PRIMARY KEY (idCliente)
);

CREATE TABLE if not exists Filme (
    idFilme int NOT NULL AUTO_INCREMENT,
    titulo varchar (255) NOT NULL,
    classificacao varchar(5) NOT NULL,
    genero varchar(255) NOT NULL,
    PRIMARY KEY (idFilme)
);

CREATE TABLE if not exists Sessao (
    idSessao int PRIMARY KEY AUTO_INCREMENT,
    idCliente int NOT NULL,
    idFilme int NOT NULL,
    idFuncionario int NOT NULL,
    preco decimal (3,2) NOT NULL,
    dataHora date NOT NULL,
    constraint fk_sessao_cliente
        FOREIGN KEY (idCliente)
        REFERENCES Cliente(idCliente)
        ON DELETE CASCADE,
    constraint fk_sessao_filme
        FOREIGN KEY (idFilme)
        REFERENCES Filme(idFilme)
        ON DELETE CASCADE,
    constraint fk_sessao_funcionario
        FOREIGN KEY (idFuncionario)
        REFERENCES Funcionario(idFuncionario)
        ON DELETE CASCADE
);

delete from Pessoa where idPessoa>0;