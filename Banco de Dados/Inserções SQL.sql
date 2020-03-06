INSERT INTO Cliente (nome_cliente, tel_Cliente, cel_Cliente, data_Nasc, email_Cliente) 
VALUES ('Rodrigo Maia', '(19)3333-3333','(19)99999-9999', '1998/11/03', 'romaia@gmail.com'), 
       ('Marcelo Cruz', '(19)1234-5678','(19)12345-5678', '1995/07/02', 'macruz@gmail.com'), 
       ('Jose da Silva','(19)1234-5678','(19)12345-5678', '1980/06/04', 'josilva@gmail.com'), 
       ('Mia Bini',     '(19)1234-5678','(19)12345-5678', '1990/08/09', 'miabini@gmail.com'), 
       ('Nelson Nerd',  '(19)1234-5678','(19)12345-5678', '1998/05/10', 'nerso@gmail.com');

INSERT INTO Endereco (id_Cliente, rua_Endereco, numero_Endereco, bairro_Endereco, cep_Endereco, complemento_Endereco) 
VALUES  (1, 'Rua Dario',  69, 'Cidade Nova',            '13335234', ''), 
        (2, 'Rua Peixe',  420,'Cecap',                  '13335233', ''), 
        (3, 'Rua Bola',   24, 'Recreio Jóia',           '13335232', 'AP108 Bl02'), 
        (4, 'Rua Gato',   13, 'Parque das Leguminosas', '13335231', ''), 
        (5, 'Rua Jacaré', 17, 'Cidade Nova',            '13335238', '');

INSERT INTO Fornecedor (cnpj_Fornecedor, razao_Social, nome_Social, tel_Fornecedor1, tel_Fornecedor2, email_Fornecedor) 
VALUES  ('61.141.783/0001-18', 'Tião das Carnes comércio de alimentos LTDA',    'Atacado das Carnes',        '(19)1111-1111', '(19)2222-2222', 'tiaocarnes@gmail.com'), 
        ('23.598.115/0001-25', 'Maria Legumes comércio de alimentos LTDA',      'Atacado das Verduras',      '(19)1111-1111', '(19)2222-2222', 'verduras@gmail.com'), 
        ('90.704.349/0001-05', 'João Refris comércio de alimentos LTDA',        'Atacado dos Refrigerantes', '(19)1111-1111', '(19)2222-2222', 'refris@gmail.com'), 
        ('71.726.612/0001-04', 'Seo Miguel Massas comércio de alimentos LTDA',  'Atacado das Massas',        '(19)1111-1111', '(19)2222-2222', 'massas@gmail.com'), 
        ('06.321.070/0001-28', 'Gino Condimentos comércio de alimentos LTDA',   'Atacado dos Condimentos',   '(19)1111-1111', '(19)2222-2222', 'condimentos@gmail.com');

INSERT INTO Funcionario (nome_Funcionario, cpf_Funcionario, nivel_Acesso, senha_Funcionario) 
VALUES ('Mariana Souza',    '326.562.620-20', 1, '123'), 
       ('Carlos Horácio',   '154.587.965-10', 1, '123'), 
       ('Jane Louveira',    '111.627.390-02', 1, '123'), 
       ('Marcos Almeida',   '700.141.150-70', 1, '123'), 
       ('Jeferson Maverick','422.825.830-19', 1, '123');

INSERT INTO Estoque (desc_Insumo, unidade_Medida, preco_Insumo, qtde_Insumo, id_Fornecedor, id_Funcionario) 
VALUES ('Queijo Mussarela',          'KG', 10.00, 10, 1, 1), 
       ('Tomate',                    'KG', 6.00,  5,  2, 2), 
       ('Refrigerante Coca-Cola 2L', 'UN', 8.00,  20, 3, 2), 
       ('Farinha',                   'KG', 5.00,  50, 4, 1), 
       ('Cebola',                    'KG', 3.00,  20, 5, 1), 
       ('Atum',                      'KG', 8.00,  10, 1, 1), 
       ('Abacaxi',                   'KG', 4.00,  8,  2, 2), 
       ('Ovo',                       'UN', 0.50,  50, 5, 2), 
       ('Calabresa',                 'KG', 6.00,  10, 1, 1);

INSERT INTO Produto (nome_Produto, preco_Produto, id_Funcionario) 
VALUES ('Pizza de Calabresa',   20.00, 1), 
       ('Pizza de Atum',        23.00, 1), 
       ('Pizza de Mussarela',   24.00, 2), 
       ('Pizza Portuguesa',     23.00, 2), 
       ('Pizza Abacaxi',        23.00, 2);

INSERT INTO SolicitaPedido (id_Cliente, id_Produto, id_Funcionario, tamanho_Pedido, qtde_Pedido, forma_Pgto, data_SolicitaPedido, anotacao, troco_Pedido, preco_Total) 
VALUES (1, 1, 1, 2, 1, 1, '2018-11-06 21:13:00', 'Sem azeitonas', 4.00, 16.00), 
       (2, 2, 1, 1, 1, 2, '2018-11-06 21:20:00', 'Sem orégano',   0,    23.00), 
       (3, 3, 2, 3, 1, 2, '2018-11-06 21:40:00', 'Sem cebola',    0,    16.80), 
       (4, 4, 2, 2, 1, 2, '2018-11-07 19:10:00', '',              0,    18.40), 
       (5, 5, 1, 1, 1, 1, '2018-11-07 20:03:00', '',              7.00, 23.00);

INSERT INTO PossuiIngrediente (id_Produto, id_Insumo, quantidade) 
VALUES (1, 1, 0.2), 
       (1, 2, 0.2), 
       (1, 4, 0.5),  --Pizza de Calabresa
       (1, 5, 0.2), 
       (1, 9, 0.3), 

       (2, 1, 0.2), 
       (2, 2, 0.2), 
       (2, 4, 0.5),  --Pizza de Atum
       (2, 5, 0.2), 
       (2, 6, 0.3), 

       (3, 1, 0.4), 
       (3, 2, 0.2), 
       (3, 4, 0.5),  --Pizza de Mussarela
       (3, 5, 0.2), 

       (4, 1, 0.2), 
       (4, 2, 0.2), 
       (4, 4, 0.5),  --Pizza Portuguesa
       (4, 5, 0.2), 
       (4, 8, 0.3), 

       (5, 1, 0.2), 
       (5, 2, 0.2), 
       (5, 4, 0.5), --Pizza de Abacaxi
       (5, 5, 0.2), 
       (5, 7, 0.4); 

INSERT INTO Baixa (id_Pedido, id_Insumo) 
VALUES (1, 1), 
       (1, 2), 
       (1, 4),  --Pizza de Calabresa
       (1, 5), 
       (1, 9), 

       (2, 1), 
       (2, 2), 
       (2, 4),  --Pizza de Atum
       (2, 5), 
       (2, 6), 

       (3, 1), 
       (3, 2), 
       (3, 4),  --Pizza de Mussarela
       (3, 5), 

       (4, 1), 
       (4, 2), 
       (4, 4),  --Pizza Portuguesa
       (4, 5), 
       (4, 8), 

       (5, 1), 
       (5, 2), 
       (5, 4), --Pizza de Abacaxi
       (5, 5), 
       (5, 7);
 
INSERT INTO Edita (id_Funcionario, id_Estoque, data_Edita) 
VALUES  (1, 1, 2018-11-06 21:54:00), 
	(1, 2, 2018-11-07 21:58:00), 
	(2, 3, 2018-11-07 19:22:00), 
	(2, 4, 2018-11-09 20:31:00), 
	(1, 5, 2018-11-09 21:14:00), 
	(2, 6, 2018-11-12 18:50:00), 
	(1, 7, 2018-11-12 22:15:00), 
	(1, 8, 2018-11-14 19:50:00), 
	(2, 9, 2018-11-14 20:06:00);
