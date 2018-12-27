
--
-- TOC entry 171 (class 1259 OID 25599)
-- Name: tb_categoria_evento; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE tb_categoria_evento (
    id_categoria_evento serial NOT NULL,
    codigo bigint NOT NULL,
    descricao character varying(50) NOT NULL
);

--
-- TOC entry 172 (class 1259 OID 25604)
-- Name: tb_dispositivo_usuario; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE tb_dispositivo_usuario (
    id_dispositivo_usuario serial NOT NULL,
    token_dispositivo character varying(500) NOT NULL,
    id_usuario bigint
);


--
-- TOC entry 173 (class 1259 OID 25612)
-- Name: tb_evento; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE tb_evento (
    id_evento serial NOT NULL,
    data_fim timestamp without time zone NOT NULL,
    data_inicio timestamp without time zone NOT NULL,
    descricao character varying(500) NOT NULL,
    titulo character varying(250) NOT NULL,
    id_categoria bigint,
    id_localizacao bigint
);


--
-- TOC entry 174 (class 1259 OID 25620)
-- Name: tb_evento_palestrante; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE tb_evento_palestrante (
    id_evento_palestrante serial NOT NULL,
    id_evento bigint,
    id_palestrante bigint
);


--
-- TOC entry 175 (class 1259 OID 25625)
-- Name: tb_localizacao_evento; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE tb_localizacao_evento (
    id_localizacao_evento serial NOT NULL,
    descricao character varying(500) NOT NULL,
    latitude decimal(9,6) NOT NULL,
    longitude decimal(9,6) NOT NULL
);


--
-- TOC entry 176 (class 1259 OID 25633)
-- Name: tb_palestrante; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE tb_palestrante (
    id_palestrante serial NOT NULL,
    descricao character varying(500) NOT NULL,
    nome character varying(250) NOT NULL,
    url_foto character varying(500)
);


--
-- TOC entry 177 (class 1259 OID 25641)
-- Name: tb_perfil; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE tb_perfil (
    id_perfil serial NOT NULL,
    codigo integer NOT NULL,
    descricao character varying(50) NOT NULL
);


--
-- TOC entry 178 (class 1259 OID 25646)
-- Name: tb_token_usuario; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE tb_token_usuario (
    id_token_usuario serial NOT NULL,
    expirity bigint NOT NULL,
    token character varying(750) NOT NULL,
    id_usuario serial
);


--
-- TOC entry 179 (class 1259 OID 25654)
-- Name: tb_usuario; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE tb_usuario (
    id_usuario serial NOT NULL,
    email character varying(250) NOT NULL,
    senha character varying(500) NOT NULL,
    id_perfil serial
);


--
-- TOC entry 1866 (class 2606 OID 25603)
-- Name: tb_categoria_evento_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_categoria_evento
    ADD CONSTRAINT tb_categoria_evento_pkey PRIMARY KEY (id_categoria_evento);


--
-- TOC entry 1870 (class 2606 OID 25611)
-- Name: tb_dispositivo_usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_dispositivo_usuario
    ADD CONSTRAINT tb_dispositivo_usuario_pkey PRIMARY KEY (id_dispositivo_usuario);


--
-- TOC entry 1874 (class 2606 OID 25624)
-- Name: tb_evento_palestrante_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_evento_palestrante
    ADD CONSTRAINT tb_evento_palestrante_pkey PRIMARY KEY (id_evento_palestrante);


--
-- TOC entry 1872 (class 2606 OID 25619)
-- Name: tb_evento_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_evento
    ADD CONSTRAINT tb_evento_pkey PRIMARY KEY (id_evento);


--
-- TOC entry 1876 (class 2606 OID 25632)
-- Name: tb_localizacao_evento_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_localizacao_evento
    ADD CONSTRAINT tb_localizacao_evento_pkey PRIMARY KEY (id_localizacao_evento);


--
-- TOC entry 1878 (class 2606 OID 25640)
-- Name: tb_palestrante_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_palestrante
    ADD CONSTRAINT tb_palestrante_pkey PRIMARY KEY (id_palestrante);


--
-- TOC entry 1880 (class 2606 OID 25645)
-- Name: tb_perfil_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_perfil
    ADD CONSTRAINT tb_perfil_pkey PRIMARY KEY (id_perfil);


--
-- TOC entry 1884 (class 2606 OID 25653)
-- Name: tb_token_usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_token_usuario
    ADD CONSTRAINT tb_token_usuario_pkey PRIMARY KEY (id_token_usuario);


--
-- TOC entry 1886 (class 2606 OID 25661)
-- Name: tb_usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_usuario
    ADD CONSTRAINT tb_usuario_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 1882 (class 2606 OID 25665)
-- Name: uk_9i7gpbre9kkf9akrrld9ifcrn; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_perfil
    ADD CONSTRAINT uk_9i7gpbre9kkf9akrrld9ifcrn UNIQUE (codigo);


--
-- TOC entry 1868 (class 2606 OID 25663)
-- Name: uk_sno1hn8t2xfp106cdl0opo80w; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_categoria_evento
    ADD CONSTRAINT uk_sno1hn8t2xfp106cdl0opo80w UNIQUE (codigo);


--
-- TOC entry 1888 (class 2606 OID 25667)
-- Name: uk_spmnyb4dsul95fjmr5kmdmvub; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_usuario
    ADD CONSTRAINT uk_spmnyb4dsul95fjmr5kmdmvub UNIQUE (email);


--
-- TOC entry 1894 (class 2606 OID 25695)
-- Name: fk3cdb9h5kv65ev315tyyuk75md; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_token_usuario
    ADD CONSTRAINT fk3cdb9h5kv65ev315tyyuk75md FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario);


--
-- TOC entry 1892 (class 2606 OID 25685)
-- Name: fk3om1nlxx9knfe0damxeftvn7t; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_evento_palestrante
    ADD CONSTRAINT fk3om1nlxx9knfe0damxeftvn7t FOREIGN KEY (id_evento) REFERENCES tb_evento(id_evento);


--
-- TOC entry 1895 (class 2606 OID 25700)
-- Name: fk4vnmbh2ttieyby11hn7rbt9xo; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_usuario
    ADD CONSTRAINT fk4vnmbh2ttieyby11hn7rbt9xo FOREIGN KEY (id_perfil) REFERENCES tb_perfil(id_perfil);


--
-- TOC entry 1889 (class 2606 OID 25670)
-- Name: fk6ot5g728593m8lr0cy50yrryo; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_dispositivo_usuario
    ADD CONSTRAINT fk6ot5g728593m8lr0cy50yrryo FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario);


--
-- TOC entry 1890 (class 2606 OID 25675)
-- Name: fkd1in1jy3b20ngwuo1168rg4d5; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_evento
    ADD CONSTRAINT fkd1in1jy3b20ngwuo1168rg4d5 FOREIGN KEY (id_categoria) REFERENCES tb_categoria_evento(id_categoria_evento);


--
-- TOC entry 1891 (class 2606 OID 25680)
-- Name: fkj47dho0uo1itp8c4ogrjipwtt; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_evento
    ADD CONSTRAINT fkj47dho0uo1itp8c4ogrjipwtt FOREIGN KEY (id_localizacao) REFERENCES tb_localizacao_evento(id_localizacao_evento);


--
-- TOC entry 1893 (class 2606 OID 25690)
-- Name: fkq93i58y732601xjb0wft2vgo7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tb_evento_palestrante
    ADD CONSTRAINT fkq93i58y732601xjb0wft2vgo7 FOREIGN KEY (id_palestrante) REFERENCES tb_palestrante(id_palestrante);


-- Completed on 2018-12-27 16:32:37 -03

--
-- PostgreSQL database dump complete
--

-- INSERINDO DADOS NA TABELA DE DOMÍNIO


-- Perfis
insert into tb_perfil(codigo,descricao) values(1,'Administrador'),(2,'Usuário');

-- Usuários
insert into tb_usuario(email,senha,id_perfil) values ('jeferson@gmail.com','12345678',1);

insert into tb_usuario(email,senha,id_perfil) values ('carlos@gmail.com','12345678',2);

insert into tb_usuario(email,senha,id_perfil) values ('luiz@gmail.com','12345678',2);

-- Categoria de Eventos

insert into tb_categoria_evento(codigo,descricao) values(1,'Tecnologia da Informação');

insert into tb_categoria_evento(codigo,descricao) values(2,'Humanas');