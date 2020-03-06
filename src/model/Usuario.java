package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe abstrata de base para a implementacao das classes de usuario
 * especializadas.
 * 
 * @author Bruno Gino
 *
 */
public abstract class Usuario {
	private IntegerProperty id;
	private StringProperty nome;
	private StringProperty cpf;
	private IntegerProperty nivelAcesso;
	private StringProperty senha;

	/**
	 * Cria uma instância de usuário com todos os atributos.
	 * 
	 * @param id          Identificador do usuário.
	 * @param nome        Nome do usuário.
	 * @param cpf         CPF do usuário
	 * @param nivelAcesso Nível de acesso do usuário.
	 * @param senha       Senha do usuário.
	 */
	public Usuario(Integer id, String nome, String cpf, Integer nivelAcesso, String senha) {
		this.id = new SimpleIntegerProperty(id);
		this.nome = new SimpleStringProperty(nome);
		this.cpf = new SimpleStringProperty(cpf);
		this.nivelAcesso = new SimpleIntegerProperty(nivelAcesso);
		this.senha = new SimpleStringProperty(senha);
	}

	/**
	 * Cria uma instância de usuário sem o código identificador.
	 * 
	 * @param nome        Nome do usuário.
	 * @param cpf         CPF do usuário.
	 * @param nivelAcesso Nível de acesso do usuário.
	 * @param senha       Senha do usuário.
	 */
	public Usuario(String nome, String cpf, Integer nivelAcesso, String senha) {
		this.nome = new SimpleStringProperty(nome);
		this.cpf = new SimpleStringProperty(cpf);
		this.nivelAcesso = new SimpleIntegerProperty(nivelAcesso);
		this.senha = new SimpleStringProperty(senha);
	}

	/**
	 * Cria uma instância de um usuário com valores default.
	 */
	public Usuario() {

	}

	/**
	 * Retorna o valor da senha no formato de SimpleStringProperty, nao retornando
	 * apenas a String base informada, mas como no seguinte exemplo: "StringProperty
	 * [value: 123]".
	 * 
	 * @return Valor da senha em formato SimpleStringProperty.
	 */
	public final IntegerProperty nivelAcessoProperty() {
		return this.nivelAcesso;
	}

	/**
	 * Retorna o id do usuario em formato base numerico.
	 * 
	 * @return O identificador do usuario.
	 */
	public final int getNivelAcesso() {
		return this.nivelAcessoProperty().get();
	}

	/**
	 * Modifica/define o identificador do usuario
	 * 
	 * @param id Identificador a ser atribuido.
	 */
	public final void setNivelAcesso(final int nivelAcesso) {
		this.nivelAcessoProperty().set(nivelAcesso);
	}

	/**
	 * Retorna o valor do nome no formato de SimpleStringProperty.
	 * 
	 * @return Nome em formato SimpleStringProperty.
	 */
	public final StringProperty nomeProperty() {
		return this.nome;
	}

	/**
	 * Retorna o nome do usuario em formato de String.
	 * 
	 * @return O nome do usuario.
	 */
	public final java.lang.String getNome() {
		return this.nomeProperty().get();
	}

	/**
	 * Modifica/define o nome do usuario
	 * 
	 * @param nome Nome a ser atribuido.
	 */
	public final void setNome(final java.lang.String nome) {
		this.nomeProperty().set(nome);
	}

	/**
	 * Retorna o valor do CPF no formato de SimpleStringProperty.
	 * 
	 * @return CPF em formato SimpleStringProperty.
	 */
	public final StringProperty cpfProperty() {
		return this.cpf;
	}

	/**
	 * Retorna o CPF do usuario em formato de String.
	 * 
	 * @return O CPF do usuario.
	 */
	public final java.lang.String getCpf() {
		return this.cpfProperty().get();
	}

	/**
	 * Modifica/define o CPF do usuario
	 * 
	 * @param cpf CPF a ser atribuido.
	 */
	public final void setCpf(final java.lang.String cpf) {
		this.cpfProperty().set(cpf);
	}

	/**
	 * Retorna o valor da senha no formato de SimpleStringProperty.
	 * 
	 * @return Senha em formato SimpleStringProperty.
	 */
	public final StringProperty senhaProperty() {
		return this.senha;
	}

	/**
	 * Retorna a senha do usuario em formato de String.
	 * 
	 * @return A senha do usuario.
	 */
	public final java.lang.String getSenha() {
		return this.senhaProperty().get();
	}

	/**
	 * Modifica/define a senha do usuario
	 * 
	 * @param senha Senha a ser atribuida.
	 */
	public final void setSenha(final java.lang.String senha) {
		this.senhaProperty().set(senha);
	}

	/**
	 * Retorna o identificador de propriedade JavaFX do Id
	 * 
	 * @return id no formato IntegerProperty
	 */
	public final IntegerProperty idProperty() {
		return this.id;
	}

	/**
	 * Returna o id do usuario.
	 * 
	 * @return id a  ser retornado.
	 */
	public final int getId() {
		return this.idProperty().get();
	}

	/**
	 * Define o id do usuario
	 * 
	 * @param id id a  ser atribuido
	 */
	public final void setId(final int id) {
		this.nivelAcessoProperty().set(id);
	}
}