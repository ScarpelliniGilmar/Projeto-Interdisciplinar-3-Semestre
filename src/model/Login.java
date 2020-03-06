package model;

import java.sql.SQLException;

import services.BD;

public class Login {
	private BD bd = new BD();
	private int nivelAceso = 0;
	private int id = 0;

	/**
	 * Verifica se as credenciais s�o v�lidas. Caso o usu�rio erre ou n�o esteja
	 * cadastrado no sistema, o m�todo retorna false. � feito uma consulta no banco
	 * de dados, para verificar se as credenciais cadastradas s�o v�lidas, com base
	 * no CPF e na senha fornecidas como par�metro. Se o Result Set encontrar esses
	 * dados, os valores de n�vel de acesso e identificador s�o atribu�dos �s
	 * vari�ves que representam os mesmos, com inten��o de facilitar a comunica��o
	 * com estes atributos.
	 * 
	 * @param cpf      CPF do funcion�rio cadastrado no sistema.
	 * @param password Senha do funcion�rio.
	 * @return Retorna false se o funcion�rio errar suas credenciais ou n�o estiver
	 *         cadastrado no sistema. Retorna true se o mesmo estiver cadastrado no
	 *         sistema e n�o errar suas credenciais.
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
	 * Retorna o objeto do usu�rio atual no sistema. Deve ser utilizada em seguida
	 * ap�s o uso do m�todo de login. O CPF tamb�m � utilizado como meio de filtro
	 * de resultados na consulta do banco. Se o Result Set encontrar o usu�rio, gera
	 * uma inst�ncia de um funcion�rio com o fornecedor que utiliza de todos os
	 * atributos da classe. Esses atributos s�o atribu�dos ao objeto de acordo com
	 * as colunas do Result Set da consulta.
	 * 
	 * @param CPF
	 * @return Objeto funcion�rio, o usu�rio atual do sistema.
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
	 * Retorna o identificador do funcion�rio.
	 * 
	 * @return C�digo do funcion�rio.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Retorna o valor de n�vel de acesso do funcion�rio.
	 * 
	 * @return N�vel de acesso do funcion�rio.
	 */
	public Integer getNivelAceso() {
		return nivelAceso;
	}

}
