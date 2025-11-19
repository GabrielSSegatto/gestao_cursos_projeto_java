-- 1. DELETAR E RE-CRIAR (COMEÇANDO DO ZERO)
DROP DATABASE IF EXISTS gerenciador_cursos;
CREATE DATABASE gerenciador_cursos;
USE gerenciador_cursos;

-- 2. CRIAÇÃO DAS TABELAS (AGORA COM BIGINT PARA OS IDs)
CREATE TABLE instrutor (
    -- ID e PK alterados para BIGINT para compatibilidade com Java Long
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    formacao VARCHAR(200) NOT NULL,
    idade INT NOT NULL
);

CREATE TABLE curso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    carga_horaria INT NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    
    -- Foreign Key (FK) alterada para BIGINT para compatibilidade com instrutor.id
    id_instrutor BIGINT NOT NULL,
    FOREIGN KEY (id_instrutor) REFERENCES instrutor(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    matricula VARCHAR(200) NOT NULL,
    idade INT NOT NULL
);

CREATE TABLE curso_aluno (
    -- Chaves Estrangeiras alteradas para BIGINT
    id_curso BIGINT NOT NULL,
    id_aluno BIGINT NOT NULL,
    data_matricula DATE DEFAULT (CURRENT_DATE),
    PRIMARY KEY (id_curso, id_aluno),
    FOREIGN KEY (id_curso) REFERENCES curso(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (id_aluno) REFERENCES aluno(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- 3. INSERÇÃO DOS DADOS DE TESTE
INSERT INTO instrutor (nome, formacao, idade) VALUES
('Carlos Silva', 'Engenharia de Software', 35),
('Mariana Souza', 'Ciência da Computação', 29),
('João Pereira', 'Análise e Desenvolvimento de Sistemas', 42);

INSERT INTO curso (nome, carga_horaria, descricao, id_instrutor) VALUES
('Lógica de Programação', 40, 'Introdução à lógica e algoritmos', 1),
('Banco de Dados', 60, 'Modelagem e SQL prático', 2),
('Desenvolvimento Web', 80, 'HTML, CSS, JavaScript e frameworks', 2),
('Segurança da Informação', 50, 'Princípios de segurança e criptografia', 3);

INSERT INTO aluno (nome, matricula, idade) VALUES
('Gabriel Soares', '2025001', 18),
('Ana Lima', '2025002', 21),
('Pedro Santos', '2025003', 23),
('Julia Alves', '2025004', 20),
('Lucas Mendes', '2025005', 19);

INSERT INTO curso_aluno (id_curso, id_aluno, data_matricula) VALUES
(1, 1, '2025-01-10'), (2, 1, '2025-02-05'), (3, 2, '2025-03-01'), 
(1, 3, '2025-02-10'), (4, 3, '2025-03-15'), (3, 4, '2025-03-20'), 
(2, 5, '2025-04-01');