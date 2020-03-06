CREATE DATABASE Pizza;
USE Pizza;

CREATE TABLE Cliente (
id_Cliente INT AUTO_INCREMENT PRIMARY KEY,
nome_Cliente VARCHAR(50) NOT NULL,
tel_Cliente VARCHAR(14),
cel_Cliente VARCHAR(14),
data_Nasc DATE,
email_Cliente VARCHAR(50)
);

CREATE TABLE Endereco (
id_Endereco INT AUTO_INCREMENT PRIMARY KEY,
id_Cliente INT NOT NULL,

rua_Endereco VARCHAR (50),
numero_Endereco VARCHAR(10),
bairro_Endereco VARCHAR(50),
cep_Endereco VARCHAR(8),
complemento_Endereco VARCHAR(50),

FOREIGN KEY (id_Cliente) REFERENCES Cliente (id_Cliente)
);

CREATE TABLE Fornecedor (
id_Fornecedor INT AUTO_INCREMENT PRIMARY KEY,
cnpj_Fornecedor VARCHAR(18) NOT NULL,
razao_Social VARCHAR(50),
nome_Social VARCHAR(50),
tel_Fornecedor1 VARCHAR(14),
tel_Fornecedor2 VARCHAR(14),
email_Fornecedor VARCHAR(50)
);

CREATE TABLE Funcionario (
id_Funcionario INT AUTO_INCREMENT PRIMARY KEY,
nome_Funcionario VARCHAR(50) NOT NULL,
cpf_Funcionario VARCHAR(14) NOT NULL,
nivel_Acesso INT NOT NULL,
senha_Funcionario VARCHAR(32) NOT NULL
);

CREATE TABLE Estoque (
id_Insumo INT AUTO_INCREMENT PRIMARY KEY,
desc_Insumo VARCHAR(50),
unidade_Medida CHAR(2),
preco_Insumo DOUBLE,
qtde_Insumo INT,

id_Fornecedor INT NOT NULL,
id_Funcionario INT NOT NULL,

FOREIGN KEY(id_Fornecedor) REFERENCES Fornecedor (id_Fornecedor), 
FOREIGN KEY(id_Funcionario) REFERENCES Funcionario (id_Funcionario)
);

CREATE TABLE Produto (
id_Produto INT AUTO_INCREMENT PRIMARY KEY,
nome_Produto VARCHAR(50),
preco_Produto DOUBLE,

id_Funcionario INT NOT NULL,

FOREIGN KEY(id_Funcionario) REFERENCES Funcionario (id_Funcionario)
);

CREATE TABLE SolicitaPedido (
id_Pedido INT AUTO_INCREMENT PRIMARY KEY,
id_Cliente INT,
id_Produto INT,
id_Funcionario INT,
tamanho_Pedido VARCHAR(15),
qtde_Pedido INT,
forma_Pgto INT,
data_SolicitaPedido DATETIME,
anotacao VARCHAR(50),
troco_Pedido DOUBLE,
preco_Total DOUBLE,

FOREIGN KEY(id_Cliente) REFERENCES Cliente (id_Cliente),
FOREIGN KEY(id_Produto) REFERENCES Produto (id_Produto),
FOREIGN KEY(id_Funcionario) REFERENCES Funcionario (id_Funcionario)
);

CREATE TABLE Baixa (
id_PedidoInsumo INT AUTO_INCREMENT PRIMARY KEY,
id_Pedido INT,
id_Insumo INT,

FOREIGN KEY(id_Pedido) REFERENCES SolicitaPedido (id_Pedido),
FOREIGN KEY(id_Insumo) REFERENCES Estoque (id_Insumo)
);

CREATE TABLE PossuiIngrediente (
id_Ingrediente INT AUTO_INCREMENT PRIMARY KEY,
id_Produto INT,
id_Insumo INT,
quantidade DOUBLE,

FOREIGN KEY(id_Insumo) REFERENCES Estoque (id_Insumo),
FOREIGN KEY(id_Produto) REFERENCES Produto (id_Produto)
);

CREATE TABLE Edita (
id_FuncionarioEstoque INT AUTO_INCREMENT PRIMARY KEY,
id_Funcionario INT,
id_Estoque INT,
data_Edita DATETIME,

FOREIGN KEY(id_Funcionario) REFERENCES Funcionario (id_Funcionario),
FOREIGN KEY(id_Estoque) REFERENCES Estoque (id_Insumo)
);

