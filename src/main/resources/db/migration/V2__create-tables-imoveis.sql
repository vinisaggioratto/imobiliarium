CREATE TABLE caracteristicas(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    andares INT NULL,
    casa_alvenaria BOOLEAN,
    casa_madeira BOOLEAN,
    casa_mista BOOLEAN,
    cor_predominante VARCHAR(100) NULL,
    piso_madeira BOOLEAN,
    piso_ceramica BOOLEAN,
    piso_porcelanato BOOLEAN,
    telhado_telha BOOLEAN,
    telhado_fibrocimento BOOLEAN,
    telhado_aluzinco BOOLEAN,
    sacada_fechada BOOLEAN,
    churrasqueira_interna BOOLEAN,
    piscina BOOLEAN,
    permite_animais BOOLEAN,
    vagas_de_garagem INT NULL,
    asfalto BOOLEAN,
    facil_acesso BOOLEAN,
    energia_eletrica BOOLEAN,
    agua_poco BOOLEAN,
    agua_concessionaria BOOLEAN,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);

CREATE TABLE imovel(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(500) NOT NULL,
    proprietario_id BIGINT NOT NULL,
    tipo_imovel VARCHAR(50) NOT NULL,
    finalidade_imovel VARCHAR(20) NOT NULL,
    valor_minimo_venda DOUBLE NOT NULL,
    valor_minimo_aluguel DOUBLE NOT NULL,
    comissao_id BIGINT NOT NULL,
    rua VARCHAR(150) NULL,
    numero INT NULL,
    bairro VARCHAR(50) NULL,
    lote VARCHAR(10) NULL,
    cidade VARCHAR(80) NULL,
    cep VARCHAR(10) NULL,
    estado TINYINT NULL,
    observacoes VARCHAR(500) NULL,
    status_imovel VARCHAR(20) NOT NULL,
    caracteristicas_id BIGINT NOT NULL,
    tamanho_terreno DOUBLE NOT NULL,
    tamanho_casa DOUBLE NOT NULL,
    data_cadastro DATETIME NOT NULL,
    data_update DATETIME NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (proprietario_id) REFERENCES proprietario(id),
    FOREIGN KEY (comissao_id) REFERENCES comissao(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
    FOREIGN KEY (caracteristicas_id) REFERENCES caracteristicas(id)
);

CREATE TABLE foto_imovel(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    imovel_id BIGINT NOT NULL,
    endereco_foto VARCHAR(300) NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (imovel_id) REFERENCES imovel(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);

CREATE TABLE vistoria(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    imovel_id BIGINT NOT NULL,
    corretor_id BIGINT NOT NULL,
    data_vistoria DATETIME NOT NULL,
    tipo_vistoria VARCHAR(30) NOT NULL,
    liberado BOOLEAN,
    observacoes VARCHAR(2000) NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (imovel_id) REFERENCES imovel (id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
    FOREIGN KEY (corretor_id) REFERENCES corretor (id)
);

CREATE TABLE venda_imovel(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    imovel_id BIGINT NOT NULL,
    corretor_id BIGINT NOT NULL,
    cliente_id BIGINT NOT NULL,
    comissao_id BIGINT NOT NULL,
    valor_venda DOUBLE NOT NULL,
    comissao_imobiliaria DOUBLE NOT NULL,
    comissa_ocorretor DOUBLE NOT NULL,
    data_venda DATETIME NOT NULL,
    observacoes VARCHAR(2000) NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (imovel_id) REFERENCES imovel (id),
    FOREIGN KEY (comissao_id) REFERENCES comissao (id),
    FOREIGN KEY (corretor_id) REFERENCES corretor (id),
    FOREIGN KEY (cliente_id) REFERENCES cliente (id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);

CREATE TABLE aluguel_imovel(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    imovel_id BIGINT NOT NULL,
    corretor_id BIGINT NOT NULL,
    inquilino_id BIGINT NOT NULL,
    data_inicio_contrato DATETIME NOT NULL,
    data_final_contrato DATETIME NOT NULL,
    valor_aluguel DOUBLE NOT NULL,
    comissao_corretor DOUBLE NOT NULL,
    comissao_imobiliaria DOUBLE NOT NULL,
    vistoria_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (corretor_id) REFERENCES corretor (id),
    FOREIGN KEY (inquilino_id) REFERENCES inquilino (id),
    FOREIGN KEY (vistoria_id) REFERENCES vistoria (id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);