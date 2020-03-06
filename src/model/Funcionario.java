package model;

import java.text.SimpleDateFormat;

import controller.LoginFormController;
import services.BD;

/**
 * Classe de modelo que referencia a entidade Funcionario no banco de dados. É
 * um usuario do sistema. Executa atividades operacionais, de menor teor
 * administrativo. Herda a classe abstrata Usuario para integracao dos campos.
 * 
 * @author Bruno Gino
 *
 */
public class Funcionario extends Usuario {
	public final byte INCLUSAO = 3;
	public final byte ALTERACAO = 4;
	private String sql, ret;
	private BD bd = new BD();

	/**
	 * * Cria um funcionario com base em todos os atributos da classe abstrata que
	 * herda. Este construtor é indicado em casos de alterações no registro de um
	 * funcionário, podendo ter seu ID utilizado como filtro para a atualização da
	 * tupla no banco de dados.
	 * 
	 * @param id          Código do funcionário.
	 * @param nome        Nome do funcionário.
	 * @param cpf         CPF do funcionário.
	 * @param nivelAcesso Nível de acesso do funcionário
	 * @param senha       Senha do funcionário.
	 */
	public Funcionario(Integer id, String nome, String cpf, Integer nivelAcesso, String senha) {
		super(id, nome, cpf, nivelAcesso, senha);
	}

	/**
	 * Gera uma instância de funcionário sem identificador, indicado no caso de uma
	 * instância nova, pois assim, o código será automaticamente gerado pelo banco.
	 * 
	 * @param nome        Nome do funcionário.
	 * @param cpf         CPF do funcionárip.
	 * @param nivelAcesso Nível de acesso do funcionário.
	 * @param senha       Senha do funcionário.
	 */
	public Funcionario(String nome, String cpf, Integer nivelAcesso, String senha) {
		super(nome, cpf, nivelAcesso, senha);
	}

	/**
	 * Gera uma instância vazia de um funcionário.
	 */
	public Funcionario() {

	}

	/**
	 * Metodo para o gerenciamento total de pedidos
	 * 
	 * @param pedido   O pedido a ser manipulado
	 * @param operacao Operacao a  ser executada. 3 - Adicao\n 4 - Alteracao
	 * @return Mensagem informando a conclusao da operacao
	 */
	public String gerenciarPedido(Pedido pedido, int operacao) {
		switch (operacao) {
		case 3:
			sql = "INSERT INTO SolicitaPedido (id_Cliente, id_Produto, id_Funcionario, tamanho_Pedido, qtde_Pedido, forma_Pgto, data_SolicitaPedido, anotacao, troco_Pedido, preco_Total)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
			try {
				bd.getConnection();
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(1, pedido.getCliente());
				bd.st.setInt(2, TableLoader.getProductId(pedido.getProdutos()));
				bd.st.setInt(3, LoginFormController.login.getId());
				bd.st.setString(4, pedido.getTamanho());
				bd.st.setInt(5, pedido.getQuantidade());
				bd.st.setInt(6, pedido.getPagamento());
				bd.st.setString(7, pedido.getData());
				bd.st.setString(8, pedido.getAnotacao());
				bd.st.setDouble(9, pedido.getTroco());
				bd.st.setDouble(10, pedido.getQuantidade() * TableLoader.getProdutoPreco(pedido.getProdutos()));
				bd.st.executeUpdate();
				ret = "Sucesso na inclusao";
			} catch (Exception e) {
				sql = "UPDATE SolicitaPedido SET id_Cliente= ?,id_Produto= ?,tamanho_Pedido= ?,qtde_Pedido = ?,forma_Pgto = ?, data_SolicitaPedido = ?,"
						+ "anotacao = ?,troco_Pedido = ? WHERE id_Pedido = ?";
				try {
					bd.getConnection();
					bd.st = bd.con.prepareStatement(sql);
					bd.st.setInt(1, pedido.getCliente());
					bd.st.setInt(2, TableLoader.getProductId(pedido.getProdutos()));
					bd.st.setString(3, pedido.getTamanho());
					bd.st.setInt(4, pedido.getQuantidade());
					bd.st.setInt(5, pedido.getPagamento());
					bd.st.setString(6, pedido.getData());
					bd.st.setString(7, pedido.getAnotacao());
					bd.st.setDouble(8, pedido.getTroco());
					bd.st.setInt(9, pedido.getId());
					bd.st.executeUpdate();
					ret = "Sucesso na alteracao";
				} catch (Exception e2) {
					e2.printStackTrace();
					ret = "Falhou";
				}
				e.printStackTrace();
				ret = "Falhou";
			} finally {
				bd.close();

			}
			break;
		case 4:
			sql = "UPDATE SolicitaPedido SET id_Cliente= ?,id_Produto= ?,tamanho_Pedido= ?,qtde_Pedido = ?,forma_Pgto = ?, data_SolicitaPedido = ?,"
					+ "anotacao = ?,troco_Pedido = ? WHERE id_Pedido = ?";
			try {
				bd.getConnection();
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(1, pedido.getCliente());
				bd.st.setInt(2, TableLoader.getProductId(pedido.getProdutos()));
				bd.st.setString(3, pedido.getTamanho());
				bd.st.setInt(4, pedido.getQuantidade());
				bd.st.setInt(5, pedido.getPagamento());
				bd.st.setString(6, pedido.getData());
				bd.st.setString(7, pedido.getAnotacao());
				bd.st.setDouble(8, pedido.getTroco());
				bd.st.setInt(9, pedido.getId());
				bd.st.executeUpdate();
				ret = "Sucesso na alteracao";
			} catch (Exception e2) {
				e2.printStackTrace();
				ret = "Falhou";

			} finally {
				bd.close();

			}
			break;
		case 5:
			sql = "DELETE FROM SolicitaPedido WHERE id_Pedido = ?";
			try {
				bd.getConnection();
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(1, pedido.getId());
				bd.st.executeUpdate();
				ret = "Sucesso ao deletar";
			} catch (Exception e) {
				e.printStackTrace();
				ret = "Falhou";
			}
		}
		return ret;
	}

	/**
	 * Metodo de gerencialmento geral de clientes.
	 * 
	 * @param cliente  Cliente a ser manipulado
	 * @param operacao Operacao a  ser executada. 3 - Adicao\n 4 - Alteracao
	 * @return Mensagem informando a conclusao da operacao
	 */
	public String gerenciarCliente(Cliente cliente, int operacao) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// Primeiro cria o usuario, depois é necessario adicionar uma lista de enderecos
		// a  ele(set).
		switch (operacao) {
		case 3:
			sql = "INSERT INTO Cliente(nome_cliente, tel_Cliente, cel_Cliente, data_Nasc, email_Cliente)  values(?,?,?,?,?)";
			try {
				bd.getConnection();
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setString(1, cliente.getNomeCliente());
				bd.st.setString(2, cliente.getTelefone());
				bd.st.setString(3, cliente.getCelular());
				bd.st.setString(4, dateFormat.format(cliente.getDataNascimento()));
				bd.st.setString(5, cliente.getEmailCliente());
				bd.st.executeUpdate();
				ret = "Sucesso na inclusao";
			} catch (Exception e) {
				sql = "UPDATE Cliente SET nome_Cliente=?,tel_Cliente=?,cel_Cliente=?,data_Nasc=?,email_Cliente=? WHERE id_Cliente=?";
				try {
					bd.getConnection();
					bd.st = bd.con.prepareStatement(sql);
					bd.st.setString(1, cliente.getNomeCliente());
					bd.st.setString(2, cliente.getTelefone());
					bd.st.setString(3, cliente.getCelular());
					bd.st.setString(4, dateFormat.format(cliente.getDataNascimento()));
					bd.st.setString(5, cliente.getEmailCliente());
					bd.st.setInt(6, cliente.getIdCliente());
					bd.st.executeUpdate();
					ret = "Sucesso na alteracao";
				} catch (Exception e2) {
					e2.printStackTrace();
					ret = "Falhou";
				}
				e.printStackTrace();
				ret = "Falhou";
			} finally {
				bd.close();

			}
			break;
		case 4:
			sql = "UPDATE Cliente SET nome_Cliente=?,tel_Cliente=?,cel_Cliente=?,data_Nasc=?,email_Cliente=? WHERE id_Cliente=?";
			try {
				bd.getConnection();
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setString(1, cliente.getNomeCliente());
				bd.st.setString(2, cliente.getTelefone());
				bd.st.setString(3, cliente.getCelular());
				bd.st.setString(4, dateFormat.format(cliente.getDataNascimento()));
				bd.st.setString(5, cliente.getEmailCliente());
				bd.st.setInt(6, cliente.getIdCliente());
				bd.st.executeUpdate();
				ret = "Sucesso na alteracao";
			} catch (Exception e2) {
				e2.printStackTrace();
				ret = "Falhou";
			}
			break;
		}
		return ret;
	}

	/**
	 * Metodo gerenciador de enderecos cadastrados no banco
	 * 
	 * @param endereco Objeto endereco a ser manipulado
	 * @param operacao Operacao a  ser executada. 3 - Adicao\n 4 - Alteracao
	 * @param cliente  Cliente cujo pertence a  um enderecao
	 * @return Mensagem informando a conclusao da operacao
	 */
	public String gerenciarEnderecos(Endereco endereco, int operacao, final Integer cliente) {
		// Precisa de uma instancia de cliente atrelada, lista ou objeto. Aqui deve ser
		// feito um join p/ mostrar o nome do cliente
		switch (operacao) {
		case 3:
			sql = "INSERT INTO Endereco(id_Cliente, rua_Endereco, numero_Endereco, bairro_Endereco, cep_Endereco, complemento_Endereco)  values(?,?,?,?,?,?)";
			try {
				bd.getConnection();
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(1, cliente);
				bd.st.setString(2, endereco.getRua());
				bd.st.setInt(3, endereco.getNumero());
				bd.st.setString(4, endereco.getBairro());
				bd.st.setString(5, endereco.getCep());
				bd.st.setString(6, endereco.getComplemento());
				bd.st.executeUpdate();
				ret = "Sucesso na inclusao";

			} catch (Exception e) {
				sql = "UPDATE Endereco SET id_Cliente=?,rua_Endereco=?,numero_Endereco=?,bairro_Endereco=?,cep_Endereco=?,complemento_Endereco=? WHERE id_Endereco=?";
				try {
					bd.getConnection();
					bd.st.setInt(1, cliente);
					bd.st.setString(2, endereco.getRua());
					bd.st.setInt(3, endereco.getNumero());
					bd.st.setString(4, endereco.getBairro());
					bd.st.setString(5, endereco.getCep());
					bd.st.setString(6, endereco.getComplemento());
					bd.st.setInt(7, endereco.getId());
					bd.st.executeUpdate();
					ret = "Sucesso na alteracao";
				} catch (Exception e2) {
					e2.printStackTrace();
					ret = "Falhou";
				}
				e.printStackTrace();
				ret = "Falhou";
			} finally {
				bd.close();

			}
			break;
		case 4:
			sql = "UPDATE Endereco SET id_Cliente=?,rua_Endereco=?,numero_Endereco=?,bairro_Endereco=?,cep_Endereco=?,complemento_Endereco=? WHERE id_Endereco=?";
			try {
				bd.getConnection();
				bd.st.setInt(1, cliente);
				bd.st.setString(2, endereco.getRua());
				bd.st.setInt(3, endereco.getNumero());
				bd.st.setString(4, endereco.getBairro());
				bd.st.setString(5, endereco.getCep());
				bd.st.setString(6, endereco.getComplemento());
				bd.st.setInt(7, endereco.getId());
				bd.st.executeUpdate();
				ret = "Sucesso na alteracao";
			} catch (Exception e2) {
				e2.printStackTrace();
				ret = "Falhou";
			}
			break;
		}
		return ret;
	}
}
