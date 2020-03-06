package model;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JTextField;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import services.BD;

public class TableLoader {
	private static BD bd = new BD();

	/**
	 * Carrega todos os fornecedores cadastrados no banco de dados. Como parâmetro
	 * recebe uma ObservableList, componente do JavaFX. Esta lista irá receber os
	 * objetos Fornecedores que serão instanciados na medida que a consulta
	 * encontra-los. Ao final disto, esta lista pode ser apresentada em componentes
	 * do framework JavaFX como ListView e TableView.
	 * 
	 * @param lista Lista de fornecedores à receber os fornecedores cadastrados no
	 *              sistema.
	 */
	public static void loadFornecedores(final ObservableList<Fornecedor> lista) {
		final String QUERY = "SELECT * FROM Fornecedor";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.rs = bd.st.executeQuery();
			System.out.println("Fornecedores");
			while (bd.rs.next()) {
				Fornecedor f1 = new Fornecedor(bd.rs.getInt(1), bd.rs.getString(2), bd.rs.getString(3),
						bd.rs.getString(4), bd.rs.getString(5), bd.rs.getString(6), bd.rs.getString(7));
				lista.add(f1);
				System.out.println(f1.getIdFornecedor() + " | " + f1.getNomeSocial());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			;
		} finally {
			bd.close();
		}
	}

	/**
	 * Carrega todos os funcionários cadastrados no banco de dados, instancia os
	 * objetos Funcionário e adiciona os mesmo na lista que vem como parâmetro. Ao
	 * final do carregamento, esta lista pode ser apresentada em alguns dos
	 * componentes do framework JavaFX, como ListView e TableView.
	 * 
	 * @param lista Lista de funcionários à receber os funcionários encontrados na
	 *              consulta ao banco.
	 */
	public static void loadFuncionarios(final ObservableList<Funcionario> lista) {
		final String QUERY = "SELECT * FROM Funcionario";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.rs = bd.st.executeQuery();
			System.out.println("Funcionarios");
			while (bd.rs.next()) {
				Funcionario f1 = new Funcionario(bd.rs.getInt(1), bd.rs.getString(2), bd.rs.getString(3),
						bd.rs.getInt(4), bd.rs.getString(5));
				lista.add(f1);
				System.out.println(f1.getId() + " | " + f1.getNome());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			;
		} finally {
			bd.close();
		}
	}

	/**
	 * Carrega todos os clientes cadastrados no banco de dados, instancia os objetos
	 * Clientes e adiciona os mesmo na lista que vem como parâmetro. Ao final do
	 * carregamento, esta lista pode ser apresentada em alguns dos componentes do
	 * framework JavaFX, como ListView e TableView.
	 * 
	 * @param lista Lista de clientes à receber os registros de clientes encontrados
	 *              na consulta ao banco.
	 */
	public static void loadClientes(final ObservableList<Cliente> lista) {
		final String QUERY = "SELECT * FROM Cliente";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.rs = bd.st.executeQuery();
			System.out.println("Clientes");
			while (bd.rs.next()) {
				Cliente c1 = new Cliente(bd.rs.getInt(1), bd.rs.getString(2), bd.rs.getString(3), bd.rs.getString(4),
						bd.rs.getString(5), bd.rs.getString(6));
				lista.add(c1);

				System.out.println(c1.getIdCliente() + " | " + c1.getNomeCliente());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			;
		} finally {
			bd.close();
		}
	}

	/**
	 * Carrega todos os itens do cardápio cadastrados no banco de dados, instancia
	 * os objetos Cardapio e adiciona os mesmo na lista que vem como parâmetro. Ao
	 * final do carregamento, esta lista pode ser apresentada em alguns dos
	 * componentes do framework JavaFX, como ListView e TableView.
	 * 
	 * @param lista Lista de itens do cardápio à receber os registros de itens do
	 *              cardápio encontrados na consulta ao banco.
	 */
	public static void loadCardapio(final ObservableList<Produto> lista) {
		final String QUERY = "SELECT id_Produto,nome_Produto,preco_Produto,nome_Funcionario FROM Produto P,Funcionario F \n"
				+ "WHERE P.id_Funcionario = F.id_Funcionario;";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.rs = bd.st.executeQuery();
			System.out.println("Produtos");
			while (bd.rs.next()) {
				Produto p1 = new Produto(bd.rs.getInt(1), bd.rs.getString(2), bd.rs.getFloat(3), bd.rs.getString(4));
				lista.add(p1);
				System.out.println(p1.getId() + " | " + p1.getNome());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			;
		} finally {
			bd.close();
		}
	}

	/**
	 * Carrega todos os pedidos cadastrados no banco de dados, instancia os objetos
	 * Pedido e adiciona os mesmo na lista que vem como parâmetro. Ao final do
	 * carregamento, esta lista pode ser apresentada em alguns dos componentes do
	 * framework JavaFX, como ListView e TableView.
	 * 
	 * @param lista Lista de pedidos à receber os registros de pedidos encontrados
	 *              na consulta ao banco.
	 */
	public static void loadPedidos(final ObservableList<Pedido> lista) {
		final String QUERY = "SELECT id_Pedido,P.id_Cliente,nome_Produto,P.id_Funcionario,tamanho_Pedido,qtde_Pedido,forma_Pgto,data_SolicitaPedido,anotacao,troco_Pedido,preco_Total FROM SolicitaPedido P,Cliente C,Produto Pr WHERE P.id_Cliente = C.id_Cliente AND P.id_Produto = Pr.id_Produto";

		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.rs = bd.st.executeQuery();
			System.out.println("Pedidos");

			while (bd.rs.next()) {
				Pedido p1 = new Pedido(bd.rs.getInt(1), bd.rs.getInt(2), bd.rs.getString(3), bd.rs.getInt(4),
						bd.rs.getString(5), bd.rs.getInt(6), bd.rs.getInt(7), bd.rs.getString(8), bd.rs.getString(9),
						bd.rs.getDouble(10), bd.rs.getDouble(11));
				lista.add(p1);
				System.out.println(p1.getId() + " | " + p1.getCliente() + " | " + p1.getProdutos());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			;
		} finally {
			bd.close();
		}
	}

	/**
	 * Carrega todos os itens do estoque cadastrados no banco de dados, instancia os
	 * objetos Estoque e adiciona os mesmo na lista que vem como parâmetro. Ao final
	 * do carregamento, esta lista pode ser apresentada em alguns dos componentes do
	 * framework JavaFX, como ListView e TableView.
	 * 
	 * @param lista Lista de insumos do estoque à receber os registros de itens do
	 *              estoque encontrados na consulta ao banco.
	 */
	public static void loadEstoque(final ObservableList<Estoque> lista) {
		final String QUERY = "SELECT id_Insumo,desc_Insumo,preco_Insumo,unidade_Medida,qtde_Insumo,F.nome_Social FROM "
				+ "Estoque E, Fornecedor F WHERE E.id_Fornecedor = F.id_Fornecedor";

		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.rs = bd.st.executeQuery();
			System.out.println("Estoque");
			while (bd.rs.next()) {
				Estoque e1 = new Estoque(bd.rs.getInt(1), bd.rs.getString(2), bd.rs.getDouble(3), bd.rs.getString(4),
						bd.rs.getInt(5), bd.rs.getString(6));
				lista.add(e1);
				System.out.println(e1.getIdInsumo() + " | " + e1.getDescricao());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			;
		} finally {
			bd.close();
		}
	}

	/**
	 * Retorna uma lista no formato ObservableList dos IDs de todos os fornecedores
	 * cadastrados no banco de dados.
	 * 
	 * @return ObservableList de IDs de fornecedores.
	 */
	public static ObservableList<Integer> getFornecedorIds() {
		final String QUERY = "SELECT id_Fornecedor FROM Fornecedor";
		ObservableList<Integer> ids = FXCollections.observableArrayList();
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.rs = bd.st.executeQuery();
			System.out.println("ids fornecedores");
			while (bd.rs.next()) {
				ids.add(bd.rs.getInt(1));
			}
			return ids;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			bd.close();
		}
	}

	/**
	 * Retorna uma lista no formato ObservableList dos IDs de todos os pedidos
	 * cadastrados no banco de dados.
	 * 
	 * @return ObservableList dos IDs dos pedidos.
	 */
	public static ObservableList<Integer> getPedidosIds() {
		final String QUERY = "SELECT id_Pedido FROM SolicitaPedido";
		ObservableList<Integer> ids = FXCollections.observableArrayList();
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.rs = bd.st.executeQuery();
			System.out.println("ids pedido");
			while (bd.rs.next()) {
				ids.add(bd.rs.getInt(1));
			}
			return ids;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			bd.close();
		}
	}

	/**
	 * Retorna uma lista no formato ObservableList dos preços de todos os itens do
	 * cardápio cadastrados no banco de dados.
	 * 
	 * @return ObservableList de preços dos itens do cardápio.
	 */
	public static Double getProdutoPreco(String produto) {
		final String QUERY = "SELECT preco_Produto FROM Produto WHERE nome_Produto LIKE ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.st.setString(1, produto);
			bd.rs = bd.st.executeQuery();
			if (bd.rs.next()) {
				return bd.rs.getDouble(1);
			} else {
				System.out.println("Produto nao encontrado");
				return 0.0;
			}
		} catch (Exception e) {
			System.out.println("Produto nao encontrado!\n" + e.toString());
			return 0.0;
		}
	}

	/**
	 * Retorna uma lista no formato ObservableList dos nomes de todos os itens do
	 * cardápio cadastrados no banco de dados.
	 * 
	 * @return ObservableList dos nomes dos itens do cardápio.
	 */
	public static ObservableList<String> getProdutoNomes() {
		final String QUERY = "SELECT nome_Produto FROM Produto";
		ObservableList<String> nomes = FXCollections.observableArrayList();
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.rs = bd.st.executeQuery();
			System.out.println("Nomes produtos");
			while (bd.rs.next()) {
				nomes.add(bd.rs.getString(1));
				System.out.println(nomes);
			}
			return nomes;
		} catch (Exception e) {
			System.out.println("Produtos nao encontrados\n" + e.toString());
			return null;
		}
	}

	/**
	 * Retorna uma lista no formato ObservableList dos IDs de todos os clientes
	 * cadastrados no banco de dados.
	 * 
	 * @return ObservableList de IDs dos clientes.
	 */
	public static ObservableList<Integer> getClienteId() {
		final String QUERY = "SELECT id_Cliente FROM Cliente ";
		ObservableList<Integer> ids = FXCollections.observableArrayList();
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) {
				ids.add(bd.rs.getInt(1));
			}
			return ids;
		} catch (Exception e) {
			System.out.println("Clientes nao encontrados\n" + e.toString());
			return null;
		}
	}

	/**
	 * Retorna uma lista no formato ObservableList dos IDs todos os produtos
	 * cadastrados no banco de dados.
	 * 
	 * @return ObservableList dos IDs dos itens do cardápio.
	 */
	public static Integer getProductId(String nome) {
		final String QUERY = "SELECT id_Produto FROM Produto WHERE nome_Produto LIKE ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.st.setString(1, nome);
			bd.rs = bd.st.executeQuery();
			if (bd.rs.next()) {
				return bd.rs.getInt(1);
			}
			return 0;
		} catch (Exception e) {
			System.out.println("Produto nao encontrado \n" + e.toString());
			return 0;
		}
	}

	/**
	 * Carrega os componentes JavaFX fornecidos com os dados dos fornecedores
	 * encontrados no banco de dados. Os componentes utilizados foram criados pela
	 * iniciativa JFoenix, que cria componentes para interfaces gráficas utilizando
	 * o JavaFX. Este método recebe somente estes componentes : JFXTextField e
	 * Label.
	 * 
	 * @param id     Id do fornecedor utilizado na consulta no banco de dados. Pode
	 *               ser conseguido através de um label (como é o caso).
	 * @param razaoS Campo de texto à receber a String de razão social do
	 *               fornecedor.
	 * @param nomeS  Campo de texto à receber a String de nome social do fornecedor.
	 * @param cnpj   Campo de texto à receber o CNPJ do fornecedor.
	 * @param tel1   Campo de texto à receber o telefone primário do fornecedor.
	 * @param tel2   Campo de texto à receber o telefone secundário do fornecedor.
	 * @param email  Campo de texto à receber o e-mail do telefone.
	 * @param codigo Label à receber o código do fornecedor.
	 */
	public static void fornecedorFields(Integer id, JFXTextField razaoS, JFXTextField nomeS, JFXTextField cnpj,
			JFXTextField tel1, JFXTextField tel2, JFXTextField email, Label codigo) {
		final String QUERY = "SELECT * FROM Fornecedor WHERE id_Fornecedor = ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.st.setInt(1, id);
			bd.rs = bd.st.executeQuery();
			if (bd.rs.next()) {
				codigo.setText(String.valueOf(bd.rs.getInt(1)));
				cnpj.setText(bd.rs.getString(2));
				razaoS.setText(bd.rs.getString(3));
				nomeS.setText(bd.rs.getString(4));
				tel1.setText(bd.rs.getString(5));
				tel2.setText(bd.rs.getString(6));
				email.setText(bd.rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bd.close();
		}
	}

	/**
	 * Carrega os componentes JavaFX fornecidos com os dados dos pedidos encontrados
	 * no banco de dados. Os componentes utilizados foram criados pela iniciativa
	 * JFoenix, que cria componentes para interfaces gráficas utilizando o JavaFX.
	 * Este método recebe somente estes componentes : JFXTextField,
	 * JFXComboBox,JFXTextArea e Label. A consulta resulta em um registro de um
	 * pedido de acordo com o código do mesmo.
	 * 
	 * @param id           Código do produto à ser utilizado na consulta ao banco.
	 * @param cliente      JFXComboBox à receber o código do cliente cadastrado no
	 *                     sistema.
	 * @param produto      JFXComboBox à receber o nome do produto pedido.
	 * @param tamanho      JFXComboBox à receber o tamanho da pizza.
	 * @param quantidade   Label à receber a quantidade de pizzas no pedido. Este é
	 *                     decrementado e incrementado por um botão na interface
	 *                     gráfica.
	 * @param pagamento    JFXComboBox à receber o tipo de pagamento.
	 * @param anotacao     JFXTextArea à receber as anotações do pedido.
	 * @param troco        JFXTextField à receber a quantidade de troco solicitado
	 *                     pelo cliente.
	 * @param total        Label à receber o valor total do pedido.
	 * @param codigoPedido Label à receber o código do pedido.
	 */
	public static void pedidoFields(Integer id, JFXComboBox<Integer> cliente, JFXComboBox<String> produto,
			JFXComboBox<String> tamanho, Label quantidade, JFXComboBox<Integer> pagamento, JFXTextArea anotacao,
			JFXTextField troco, Label total, Label codigoPedido) {
		final String QUERY = "SELECT id_Pedido,P.id_Cliente,nome_Produto,tamanho_Pedido,qtde_Pedido,forma_Pgto,"
				+ "anotacao,troco_Pedido,preco_Total FROM "
				+ "SolicitaPedido P,Cliente C,Produto Pr WHERE P.id_Cliente = C.id_Cliente AND id_Pedido = ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.st.setInt(1, id);
			bd.rs = bd.st.executeQuery();
			if (bd.rs.next()) {
				codigoPedido.setText(String.valueOf(bd.rs.getInt(1)));
				cliente.getSelectionModel().select(bd.rs.getInt(2));
				produto.getSelectionModel().select(bd.rs.getString(3));
				tamanho.getSelectionModel().select(bd.rs.getString(4));
				quantidade.setText(bd.rs.getString(5));
				pagamento.getSelectionModel().select(bd.rs.getInt(6));
				anotacao.setText(bd.rs.getString(7));
				troco.setText(String.valueOf(bd.rs.getDouble(8)));
				total.setText(String.valueOf(bd.rs.getDouble(9)));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			bd.close();
		}
	}

	/**
	 * Retorna uma ObservableList contendo todos os IDs dos clientes cadastrados no
	 * baco de dados.
	 * 
	 * @return ObservableList de códigos de clientes.
	 */
	public static ObservableList<Integer> getIdClientes() {
		final String QUERY = "SELECT id_Cliente FROM Cliente";
		ObservableList<Integer> ids = FXCollections.observableArrayList();
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) {
				ids.add(bd.rs.getInt(1));
			}
			return ids;
		} catch (SQLException e) {

			System.out.println(e.toString());
			return ids;
		}
	}

	/**
	 * Retorna uma ObservableList contento todos os endereços correspondentes à um
	 * cliente. O endereço é verificado através do endereço de e-mail do cliente.
	 * 
	 * @param email E-mail do cliente à ser utilizado na consulta ao banco de dados.
	 * @return ObservableList contendo todos os códigos dos endereços de um cliente.
	 */
	public static ObservableList<Integer> getEnderecos(String email) {
		final String QUERY = "SELECT id_Endereco FROM Endereco WHERE email_Cliente LIKE ?";
		ObservableList<Integer> idEnderecos = FXCollections.observableArrayList();
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.st.setString(1, email);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) {
				idEnderecos.add(bd.rs.getInt(1));
			}
			return idEnderecos;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		} finally {
			bd.close();
		}
	}

	/**
	 * Carrega os componentes JavaFX fornecidos com os dados do cliente encontrado
	 * no banco de dados. Os componentes utilizados foram criados pela iniciativa
	 * JFoenix, que cria componentes para interfaces gráficas utilizando o JavaFX.
	 * Este método recebe somente estes componentes : JFXTextField,
	 * JFXComboBox,JFXDatePicker e Label. A consulta resulta em um registro de um
	 * cliente de acordo com o código do mesmo.
	 * 
	 * @param idCliente Código do cliente à ser utilizado na consulta ao banco.
	 * @param nome      JFXTextField à receber o nome do cliente.
	 * @param telefone  JFXTextField à receber o telefone do cliente.
	 * @param celular   JFXTextField à receber o celular do cliente.
	 * @param email     JFXTextField à receber o e-mail do cliente.
	 * @param data      JFXDatePicker à receber a data de nascimento do cliente.
	 * @param endereco  JFXComboBox à receber os códigos dos endereços deste
	 *                  cliente.
	 * @param codigo    Label à receber o código deste cliente.
	 */
	public static void setClienteFields(Integer idCliente, JFXTextField nome, JFXTextField telefone,
			JFXTextField celular, JFXTextField email, JFXDatePicker data, JFXComboBox<Integer> endereco, Label codigo) {
		final String QUERY = "SELECT C.*,id_Endereco FROM Cliente C,Endereco E WHERE C.id_Cliente = ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.st.setInt(1, idCliente);
			bd.rs = bd.st.executeQuery();
			if (bd.rs.next()) {
				codigo.setText(String.valueOf(bd.rs.getInt(1)));
				nome.setText(bd.rs.getString(2));
				telefone.setText(bd.rs.getString(3));
				celular.setText(bd.rs.getString(4));
				email.setText(bd.rs.getString(6));
				data.setValue(LocalDate.parse((CharSequence) bd.rs.getDate(5)));
				endereco.getSelectionModel().select(bd.rs.getInt(7));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			bd.close();
		}
	}

	/**
	 * Carrega os componentes JavaFX fornecidos com os dados dos endereços de um
	 * cliente encontrados no banco de dados. Os componentes utilizados foram
	 * criados pela iniciativa JFoenix, que cria componentes para interfaces
	 * gráficas utilizando o JavaFX. Este método recebe somente estes componentes :
	 * JFXTextField e Label. A consulta resulta em um registro de um endereço de
	 * acordo com o código do mesmo.
	 * 
	 * @param id            Código do endereço à ser utilizado na consulta ao banco.
	 * @param jfxTextField  TextField à receber a rua do endereço.
	 * @param jfxTextField2 TextField à receber o número do endereço.
	 * @param jfxTextField3 TextField à receber o bairro do endereço.
	 * @param jfxTextField4 TextField à receber o CEP do endereço.
	 * @param jfxTextField5 TextField à receber o complemento do endereço.
	 * @param codigo        Label à receber o código do endereço
	 */
	public static void setEnderecoFields(Integer id, JFXTextField jfxTextField, JFXTextField jfxTextField2,
			JFXTextField jfxTextField3, JFXTextField jfxTextField4, JFXTextField jfxTextField5, Label codigo) {
		final String QUERY = "SELECT * FROM Endereco WHERE id_Endereco = ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.st.setInt(1, id);
			bd.rs = bd.st.executeQuery();
			if (bd.rs.next()) {
				jfxTextField.setText(bd.rs.getString(3));
				jfxTextField2.setText(bd.rs.getString(6));
				jfxTextField3.setText(String.valueOf(bd.rs.getInt(4)));
				jfxTextField4.setText(bd.rs.getString(5));
				jfxTextField5.setText(bd.rs.getString(7));
				codigo.setText(String.valueOf(bd.rs.getInt(1)));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			bd.close();
		}
	}
}
