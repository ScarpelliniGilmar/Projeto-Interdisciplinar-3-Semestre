package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD {
	public Connection con = null;
	public PreparedStatement st = null;
	public ResultSet rs = null;
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String BANCO = "Pizza";
	private final String URL = "jdbc:mysql://localhost:3306/" + BANCO;
	private final String LOGIN = "root";
	private final String SENHA = "241099@";

	public boolean getConnection() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			System.out.println("Conectou");
			return true;
		} catch (SQLException erro) {
			System.out.println("Falha " + erro.getMessage());
			return false;
		} catch (ClassNotFoundException erro) {
			System.out.println("Driver n�o encontrado!");
			return false;
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException erro) {
		}
		;

		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException erro) {
		}
		;

		try {
			if (con != null) {
				con.close();
				System.out.println("Desconectou");
			}
		} catch (SQLException erro) {
		}
		;
	}
}