CREATE TABLE cadastro(
    id BIGINT primary key auto_increment,
    nome VARCHAR(100) not null,
    sobrenome VARCHAR(100) not null,
    cpfcnpj VARCHAR(18) not null unique,
    rg VARCHAR(20) null,
    datanascimento TIMESTAMP not null,
    email VARCHAR(100) NOT NULL,
    telefonecelular VARCHAR(15) NOT NULL,
    sexo CHAR(1) NULL,
    cadastroativo BOOLEAN,
    rua VARCHAR(150) NULL,
    numero INT NULL,
    bairro VARCHAR(50) NULL,
    cep VARCHAR(10) NULL,
    estado CHAR(2) NULL,
    datacadastro TIMESTAMP NOT NULL,
    dataupdate TIMESTAMP NOT NULL
);

CREATE TABLE usuarios(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    cadastro_id BIGINT NOT NULL,
    datacadastro TIMESTAMP NOT NULL,
    dataupdate TIMESTAMP NOT NULL,
    FOREIGN KEY (cadastro_id) REFERENCES cadastro (id)
);

ALTER TABLE cadastro ADD COLUMN usuario_id BIGINT NOT NULL;
ALTER TABLE cadastro ADD FOREIGN KEY (usuario_id) REFERENCES usuarios(id);

CREATE TABLE cliente(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cadastro_id BIGINT NOT NULL,
    preferencias VARCHAR(2000) NOT NULL,
    observacoes VARCHAR(1000) NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (cadastro_id) REFERENCES cadastro(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE proprietario(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cadastro_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (cadastro_id) REFERENCES cadastro(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE comissao(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    percentual DOUBLE(5,2) NOT NULL,
    tipocomissao VARCHAR(20) NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE corretor(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cadastro_id BIGINT NOT NULL,
    numeroregistro VARCHAR(20) NOT NULL,
    comissao_id BIGINT NOT NULL,
    especialidade VARCHAR(500) NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (cadastro_id) REFERENCES cadastro(id),
    FOREIGN KEY (comissao_id) REFERENCES comissao(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE funcionario(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cadastro_id BIGINT NOT NULL,
    salario DOUBLE(7,2) NOT NULL,
    comissao_id BIGINT NOT NULL,
    funcao VARCHAR(30) NOT NULL,
    dataadmissao TIMESTAMP NOT NULL,
    datademissao TIMESTAMP NULL,
    datacadastro TIMESTAMP NOT NULL,
    dataupdate TIMESTAMP NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (cadastro_id) REFERENCES cadastro(id),
    FOREIGN KEY (comissao_id) REFERENCES comissao(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);