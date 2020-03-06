package model;

import java.sql.SQLException;

import services.BD;

public class Login {
	private BD bd = new BD();
	private int nivelAceso = 0;
	private int id = 0;

	/**
	 * Verifica se as credenciais são válidas. Caso o usuário erre ou não esteja
	 * cadastrado no sistema, o método retorna false. É feito uma consulta no banco
	 * de dados, para verificar se as credenciais cadastradas são válidas, com base
	 * no CPF e na senha fornecidas como parâmetro. Se o Result Set encontrar esses
	 * dados, os valores de nível de acesso e identificador são atribuídos às
	 * variáves que representam os mesmos, com intenção de facilitar a comunicação
	 * com estes atributos.
	 * 
	 * @param cpf      CPF do funcionário cadastrado no sistema.
	 * @param password Senha do funcionário.
	 * @return Retorna false se o funcionário errar suas credenciais ou não estiver
	 *         cadastrado no sistema. Retorna true se o mesmo estiver cadastrado no
	 *         sistema e não errar suas credenciais.
	 */
	public boolean isLogin(final String cpf, final String password) {
		final String QUERY = "SELECT * FROM Funcionario WHERE cpf_Funcionario = ? AND Senha_Funcionario = ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.st.setString(1, cpf);
			bd.st.setString(2, password);
			bd.rs = bd.st.executeQuery();
			if (bd.rs.next()) {
				id = bd.rs.getInt(1);
				nivelAceso = bd.rs.getInt(4);
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			bd.close();
		}
	}

	/**
	 * Retorna o objeto do usuário atual no sistema. Deve ser utilizada em seguida
	 * após o uso do método de login. O CPF também é utilizado como meio de filtro
	 * de resultados na consulta do banco. Se o Result Set encontrar o usuário, gera
	 * uma instância de um funcionário com o fornecedor que utiliza de todos os
	 * atributos da classe. Esses atributos são atribuídos ao objeto de acordo com
	 * as colunas do Result Set da consulta.
	 * 
	 * @param CPF
	 * @return Objeto funcionário, o usuário atual do sistema.
	 */
	public Usuario setUserValues(final String CPF) {
		final String QUERY = "SELECT * FROM Funcionario WHERE cpf_Funcionario LIKE ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(QUERY);
			bd.st.setString(1, CPF);
			bd.rs = bd.st.executeQuery();
			System.out.println("Funcionarios");
			if (bd.rs.next()) {
				Funcionario f1 = new Funcionario(bd.rs.getInt(1), bd.rs.getString(2), bd.rs.getString(3),
						bd.rs.getInt(4), bd.rs.getString(5));
				System.out.println(f1.getId() + " | " + f1.getNome());
				return f1;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			bd.close();
		}
	}

	/**
	 * Retorna o identificador do funcionário.
	 * 
	 * @return Código do funcionário.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Retorna o valor de nível de acesso do funcionário.
	 * 
	 * @return Nível de acesso do funcionário.
	 */
	public Integer getNivelAceso() {
		return nivelAceso;
	}

}
