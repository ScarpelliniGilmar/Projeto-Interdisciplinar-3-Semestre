package model;

import java.sql.SQLException;

import services.BD;
import view.MainFormController;

/**
 * Classe de modelo e de manipulacao de dados, referenciando a entidade
 * Funcionario no banco de dados, mas tratado como um super usuario no sistema.
 * Implementa a interface Gerenciador, na qual a classe ira tratar das suas
 * atividades de gerenciamento do sistema. Tambem herda a classe Funcionario,
 * permitindo que as mesmas acoes executadas pela outra classe, sejam aqui
 * levadas alem com a interface de gerenciamento.
 * 
 * @author Bruno Gino
 *
 */
public class Admin extends Funcionario implements Gerenciador {
	private BD bd = new BD();
	public static final byte NIVEL_ACESSO = 2;
	public static final byte EXCLUSAO = 5;
	private String sql, ret;

	/**
	 * Cria um usuario administrador com base nos atributos herdados da classe
	 * Funcionario.
	 * 
	 * @param id    Identificador do administrador
	 * @param nome  Nome do administrador
	 * @param cpf   CPF do administrador
	 * @param senha Senha utilizada pelo usuario administrador para logar no
	 *              sistema.
	 */
	public Admin(String nome, String cpf, Integer nivelAcesso, String senha) {
		super(nome, cpf, nivelAcesso, senha);
	}
	/**
	 * Construtor para uma instância vazia de um usuário administrador.
	 */
	public Admin() {

	}

	@Override
	public String gerenciarCardapio(Produto produto, final int operacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gerenciarFornecedor(Fornecedor fornecedor, final int operacao) {
		switch (operacao) {
		case 3:
			sql = "INSERT INTO Fornecedor (cnpj_Fornecedor, razao_Social, nome_Social, tel_Fornecedor1, tel_Fornecedor2, email_Fornecedor)values(?,?,?,?,?,?)";
			try {
				bd.getConnection();
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setString(1, fornecedor.getCnpj());
				bd.st.setString(2, fornecedor.getRazaoSocial());
				bd.st.setString(3, fornecedor.getNomeSocial());
				bd.st.setString(4, fornecedor.getTel1());
				bd.st.setString(5, fornecedor.getTel2());
				bd.st.setString(6, fornecedor.getEmail());
				bd.st.executeUpdate();
				MainFormController.fList.add(fornecedor);
				ret = "Sucesso na inclusao";
			} catch (Exception e) {
				sql = "UPDATE Fornecedor SET cnpj_Fornecedor=?,razao_Social=?,nome_Social=?,tel_Fornecedor1=?,tel_Fornecedor2=?, email_Fornecedor=? WHERE id_Fornecedor=?";
				try {
					bd.getConnection();
					bd.st = bd.con.prepareStatement(sql);
					bd.st.setString(1, fornecedor.getCnpj());
					bd.st.setString(2, fornecedor.getRazaoSocial());
					bd.st.setString(3, fornecedor.getNomeSocial());
					bd.st.setString(4, fornecedor.getTel1());
					bd.st.setString(5, fornecedor.getTel2());
					bd.st.setString(6, fornecedor.getEmail());
					bd.st.setInt(7, fornecedor.getId());
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
			sql = "UPDATE Fornecedor SET cnpj_Fornecedor=?,razao_Social=?,nome_Social=?,tel_Fornecedor1=?,tel_Fornecedor2=?, email_Fornecedor=? WHERE cnpj_Fornecedor=?";
			try {
				bd.getConnection();
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setString(1, fornecedor.getCnpj());
				bd.st.setString(2, fornecedor.getRazaoSocial());
				bd.st.setString(3, fornecedor.getNomeSocial());
				bd.st.setString(4, fornecedor.getTel1());
				bd.st.setString(5, fornecedor.getTel2());
				bd.st.setString(6, fornecedor.getEmail());
				bd.st.setString(7, fornecedor.getCnpj());
				bd.st.executeUpdate();
				ret = "Sucesso na alteracao";
			} catch (Exception e2) {
				e2.printStackTrace();
				ret = "Falhou";
			}
			break;
		case 5:
			sql = "DELETE FROM Fornecedor WHERE id_Fornecedor = ?";
			try {
				bd.getConnection();
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(1, fornecedor.getId());
				bd.st.executeUpdate();
				ret = "Sucesso ao deletar";
			} catch (SQLException e) {
				e.printStackTrace();
				ret = "Falhou";
			}
			break;
		}
		return ret;
	}

	@Override
	public String gerenciarEstoque(Estoque estoque, final int operacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gerenciarFuncionario(Funcionario funcionario, final int operacao) {
		switch (operacao) {
		case 3:
			sql = "INSERT INTO Fornecedor values(?,?,?,?)";
			try {
				bd.getConnection();
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setString(1, funcionario.getNome());
				bd.st.setString(2, funcionario.getCpf());
				bd.st.setInt(3, funcionario.getNivelAcesso());
				bd.st.setString(4, funcionario.getSenha());
				bd.st.executeUpdate();
				ret = "Sucesso na inclusao";
			} catch (Exception e) {
				sql = "UPDATE produtos SET nome_Funcionario=?,cpf_Funcionario=?,nivel_Acesso=?,senha_Funcionario=? WHERE id_Funcionario=?";
				try {
					bd.getConnection();
					bd.st = bd.con.prepareStatement(sql);
					bd.st.setString(1, funcionario.getNome());
					bd.st.setString(2, funcionario.getCpf());
					bd.st.setInt(3, funcionario.getNivelAcesso());
					bd.st.setString(4, funcionario.getSenha());
					bd.st.setInt(5, funcionario.getId());
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
			sql = "UPDATE produtos SET nome_Funcionario=?,cpf_Funcionario=?,nivel_Acesso=?,senha_Funcionario=? WHERE id_Funcionario=?";
			try {
				bd.getConnection();
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setString(1, funcionario.getNome());
				bd.st.setString(2, funcionario.getCpf());
				bd.st.setInt(3, funcionario.getNivelAcesso());
				bd.st.setString(4, funcionario.getSenha());
				bd.st.setInt(5, funcionario.getId());
				bd.st.executeUpdate();
				ret = "Sucesso na alteracao";
			} catch (Exception e2) {
				e2.printStackTrace();
				ret = "Falhou";
			}
			break;
		case 5:
			// TODO
			break;
		}
		return ret;
	}

}
