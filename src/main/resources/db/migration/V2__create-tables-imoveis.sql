CREATE TABLE caracteristicas(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    andares INT NULL,
    casaalvenaria BOOLEAN,
    casamadeira BOOLEAN,
    casamista BOOLEAN,
    pisomadeira BOOLEAN,
    pisoceramica BOOLEAN,
    pisoporcelanato BOOLEAN,
    telhadotelha BOOLEAN,
    telhadofibrocimento BOOLEAN,
    telhadoaluzinco BOOLEAN,
    sacadafechada BOOLEAN,
    churrasqueirainterna BOOLEAN,
    piscina BOOLEAN,
    permiteanimais BOOLEAN,
    vagasdegaragem INT NULL,
    asfalto BOOLEAN,
    cor VARCHAR(100) NULL,
    energiaeletrica BOOLEAN,
    aguapoco BOOLEAN,
    aguacomunitaria BOOLEAN,
    facilacesso BOOLEAN,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);

CREATE TABLE imovel(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(500) NOT NULL,
    proprietario_id BIGINT NOT NULL,
    tipoimovel VARCHAR(50) NOT NULL,
    finalidadeimovel VARCHAR(20) NOT NULL,
    valorvendaminimo DOUBLE(12,2) NOT NULL,
    valorminimoaluguel DOUBLE(12,2) NOT NULL,
    comissao_id BIGINT NOT NULL,
    datacadastro TIMESTAMP NOT NULL,
    rua VARCHAR(150) NULL,
    numero INT NULL,
    lote VARCHAR(10) NULL,
    bairro VARCHAR(50) NULL,
    cep VARCHAR(10) NULL,
    estado CHAR(2) NULL,
    usuario_id BIGINT NOT NULL,
    dataupdate TIMESTAMP NOT NULL,
    observacoes VARCHAR(500) NULL,
    statusimovel VARCHAR(20) NOT NULL,
    caracteristicas_id BIGINT NOT NULL,
    tamanhoterreno INT NULL,
    tamanhocasa INT NULL,
    aceitacarro BOOLEAN,
    aceitaimovel BOOLEAN,
    FOREIGN KEY (proprietario_id) REFERENCES proprietario(id),
    FOREIGN KEY (comissao_id) REFERENCES comissao(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
    FOREIGN KEY (caracteristicas_id) REFERENCES caracteristicas(id)
);

CREATE TABLE foto_imovel(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    imovel_id BIGINT NOT NULL,
    enderecopastafoto VARCHAR(300) NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (imovel_id) REFERENCES imovel(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);

CREATE TABLE vistoria(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    imovel_id BIGINT NOT NULL,
    datavistoria TIMESTAMP NOT NULL,
    liberado BOOLEAN,
    observacoes VARCHAR(2000) NOT NULL,
    usuario_id BIGINT NOT NULL,
    corretor_id BIGINT NOT NULL,
    tipovistoria VARCHAR(20) NOT NULL,
    FOREIGN KEY (imovel_id) REFERENCES imovel (id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
    FOREIGN KEY (corretor_id) REFERENCES corretor (id)
);

CREATE TABLE venda_imovel(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    imovel_id BIGINT NOT NULL,
    valorvenda DOUBLE(12,2) NOT NULL,
    comissao_id BIGINT NOT NULL,
    comissaocorretor DOUBLE(12,2) NOT NULL,
    comissaovalorimobiliaria DOUBLE(12,2) NOT NULL,
    observacoes VARCHAR(2000) NULL,
    datavenda TIMESTAMP NOT NULL,
    corretor_id BIGINT NOT NULL,
    cliente_id BIGINT NOT NULL,
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
    valoraluguel DOUBLE(7,2) NOT NULL,
    comissaocorretor DOUBLE(7,2) NOT NULL,
    comissaovalorimobiliaria DOUBLE(7,2) NOT NULL,
    datainiciocontrato TIMESTAMP NOT NULL,
    datafinalcontrato TIMESTAMP NOT NULL,
    corretor_id BIGINT NOT NULL,
    cliente_id BIGINT NOT NULL,
    vistoria_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (corretor_id) REFERENCES corretor (id),
    FOREIGN KEY (cliente_id) REFERENCES cliente (id),
    FOREIGN KEY (vistoria_id) REFERENCES vistoria (id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);