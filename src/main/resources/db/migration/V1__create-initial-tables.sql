CREATE TABLE cadastro(
    id BIGINT primary key auto_increment,
    nome VARCHAR(100) not null,
    sobrenome VARCHAR(100) not null,
    cpf_cnpj VARCHAR(18) not null unique,
    rg VARCHAR(20) null,
    data_nascimento TIMESTAMP not null,
    email VARCHAR(100) NOT NULL,
    telefone_celular VARCHAR(15) NOT NULL,
    sexo CHAR(1) NULL,
    cadastro_ativo BOOLEAN,
    rua VARCHAR(150) NULL,
    numero INT NULL,
    bairro VARCHAR(50) NULL,
    cidade VARCHAR(80) NULL,
    cep VARCHAR(10) NULL,
    estado CHAR(2) NULL,
    data_cadastro TIMESTAMP NOT NULL,
    data_update TIMESTAMP NOT NULL
);

CREATE TABLE usuarios(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    cadastro_id BIGINT NOT NULL,
    data_cadastro TIMESTAMP NOT NULL,
    data_update TIMESTAMP NOT NULL,
    FOREIGN KEY (cadastro_id) REFERENCES cadastro (id)
);

CREATE TABLE comissao(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    percentual DOUBLE NOT NULL,
    tipo_comissao VARCHAR(20) NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE proprietario(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cadastro_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (cadastro_id) REFERENCES cadastro(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE corretor(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cadastro_id BIGINT NOT NULL,
    numero_registro VARCHAR(20) NOT NULL,
    comissao_id BIGINT NOT NULL,
    especialidade VARCHAR(500) NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (cadastro_id) REFERENCES cadastro(id),
    FOREIGN KEY (comissao_id) REFERENCES comissao(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE cliente(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cadastro_id BIGINT NOT NULL,
    preferencias VARCHAR(2000) NOT NULL,
    observacoes VARCHAR(1000) NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (cadastro_id) REFERENCES cadastro(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE inquilino(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cliente_id BIGINT NOT NULL,
    salario_mensal DOUBLE NOT NULL,
    empresa_trabalho VARCHAR(100) NOT NULL,
    funcao VARCHAR(100) NOT NULL,
    data_admissao TIMESTAMP NOT NULL,
    dependentes INT NOT NULL,
    observacoes VARCHAR(1000) NULL,
    data_cadastro TIMESTAMP NOT NULL,
    data_update TIMESTAMP NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente (id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE funcionario(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cadastro_id BIGINT NOT NULL,
    salario DOUBLE NOT NULL,
    comissao_id BIGINT NOT NULL,
    funcao VARCHAR(30) NOT NULL,
    data_admissao TIMESTAMP NOT NULL,
    data_demissao TIMESTAMP NULL,
    data_cadastro TIMESTAMP NOT NULL,
    data_update TIMESTAMP NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (cadastro_id) REFERENCES cadastro(id),
    FOREIGN KEY (comissao_id) REFERENCES comissao(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);