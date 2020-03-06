package model;

import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Classe de modelo que referencia a entidade Cliente no banco de dados.
 * 
 * @author Bruno Gino
 *
 */
public class Cliente {
	private SimpleIntegerProperty idCliente;
	private SimpleStringProperty nomeCliente;
	private SimpleStringProperty celular;
	private SimpleStringProperty emailCliente;
	private SimpleStringProperty telefone;
	private String dataNascimento;
	private ArrayList<Endereco> enderecos;

	/**
	 * Cria uma instancia de um cliente com código identificador.
	 * 
	 * @param idCliente      Identificador do cliente.
	 * @param nome           Nome do cliente.
	 * @param celular        Celular do cliente.
	 * @param email          Endereco de e-mail do cliente.
	 * @param telefone       Telefone do cliente.
	 * @param dataNascimento Data de nascimento do cliente.
	 */
	public Cliente(Integer idCliente, String nomeCliente, String celular, String emailCliente, String telefone,
			String dataNascimento) {
		this.idCliente = new SimpleIntegerProperty(idCliente);
		this.nomeCliente = new SimpleStringProperty(nomeCliente);
		this.celular = new SimpleStringProperty(celular);
		this.emailCliente = new SimpleStringProperty(emailCliente);
		this.telefone = new SimpleStringProperty(telefone);
		this.dataNascimento = dataNascimento;
	}

	/**
	 * Construtor para geração de uma instância de Cliente sem código identificador.
	 * 
	 * @param nomeCliente
	 * @param celular
	 * @param emailCliente
	 * @param telefone
	 * @param dataNascimento
	 */
	public Cliente(String nomeCliente, String celular, String emailCliente, String telefone, String dataNascimento) {
		this.nomeCliente = new SimpleStringProperty(nomeCliente);
		this.celular = new SimpleStringProperty(celular);
		this.emailCliente = new SimpleStringProperty(emailCliente);
		this.telefone = new SimpleStringProperty(telefone);
		this.dataNascimento = dataNascimento;
	}
	/**
	 * Retorna a lista de endereços cujo o cliente pertence.
	 * @return Lista de endereços, como ArrayList.
	 */
	public ArrayList<Endereco> getEnderecos() {
		return enderecos;
	}
	/**
	 * Adiciona um endereço à lista de endereços do cliente, cujo ao ser instanciado é criada vazia.
	 * @param enderecos Objeto endereço à ser adicionado.
	 */
	public void addEnderecos(Endereco enderecos) {
		this.enderecos.add(enderecos);
	}

	/**
	 * Retorna a data de nascimento do cliente em formato LocalDate.
	 * 
	 * @return Data de nascimento do cliente.
	 */
	public String getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * Modifica/define a data de nascimento do cliente.
	 * 
	 * @param dataNascimento Data de nascimento atual.
	 */
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * Retorna o ID do cliente em formato de um objeto SimpleIntegerProperty.
	 * 
	 * @return ID do cliente em formato SimpleIntegerProperty.
	 */
	public final SimpleIntegerProperty idProperty() {
		return this.idCliente;
	}

	/**
	 * Retorna o ID do cliente.
	 * 
	 * @return o ID do cliente.
	 */
	public final int getIdCliente() {
		return this.idProperty().get();
	}

	/**
	 * Modifica/define o valor de ID do cliente.
	 * 
	 * @param id ID a ser atribuido.
	 */
	public final void setId(final int id) {
		this.idProperty().set(id);
	}

	/**
	 * Retorna o nome do cliente em formato de um objeto SimpleStringProperty.
	 * 
	 * @return Nome do cliente em formato SimpleStringProperty.
	 */
	public final SimpleStringProperty nomeProperty() {
		return this.nomeCliente;
	}

	/**
	 * Retorna o valor de String do nome do cliente.
	 * 
	 * @return Nome do cliente.
	 */
	public final java.lang.String getNomeCliente() {
		return this.nomeProperty().get();
	}

	/**
	 * Modifica/define o nome do cliente.
	 * 
	 * @param nome Nome a ser atribuido.
	 */
	public final void setNome(final java.lang.String nome) {
		this.nomeProperty().set(nome);
	}

	/**
	 * Retorna o celular do cliente em formato de um objeto SimpleStringProperty.
	 * 
	 * @return Celular do cliente em formato SimpleStringProperty.
	 */
	public final SimpleStringProperty celularProperty() {
		return this.celular;
	}

	/**
	 * Retorna o valor de String do celular do cliente.
	 * 
	 * @return Celular do cliente.
	 */
	public final java.lang.String getCelular() {
		return this.celularProperty().get();
	}

	/**
	 * Modifica/define o celular do cliente.
	 * 
	 * @param celular Celular a ser atribuido.
	 */
	public final void setCelular(final java.lang.String celular) {
		this.celularProperty().set(celular);
	}

	/**
	 * Retorna o e-mail do cliente em formato um objeto SimpleStringProperty.
	 * 
	 * @return E-mail do cliente em formato SimpleStringProperty.
	 */
	public final SimpleStringProperty emailProperty() {
		return this.emailCliente;
	}

	/**
	 * Retorna o valor de String do e-mail do cliente.
	 * 
	 * @return E-mail do cliente.
	 */
	public final java.lang.String getEmailCliente() {
		return this.emailProperty().get();
	}

	/**
	 * Modifica/define o e-mail do cliente.
	 * 
	 * @param email E-mail a ser atribuido.
	 */
	public final void setEmail(final java.lang.String email) {
		this.emailProperty().set(email);
	}

	/**
	 * Retorna o telefone do cliente em formato um objeto SimpleStringProperty.
	 * 
	 * @return Telefone do cliente em formato SimpleStringProperty.
	 */
	public final SimpleStringProperty telefoneProperty() {
		return this.telefone;
	}

	/**
	 * Retorna o valor de String do telefone do cliente.
	 * 
	 * @return Telefone do cliente.
	 */
	public final java.lang.String getTelefone() {
		return this.telefoneProperty().get();
	}

	/**
	 * Modifica/define o telefone do cliente.
	 * 
	 * @param telefone Telefone a ser atribuido.
	 */
	public final void setTelefone(final java.lang.String telefone) {
		this.telefoneProperty().set(telefone);
	}

}
