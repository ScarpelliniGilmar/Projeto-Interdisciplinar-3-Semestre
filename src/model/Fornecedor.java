package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Representatividade dos fornecedores de insumos como classe do sistema,
 * contendo todas a informacoes referenciadas na tabela de fornecedores.
 * 
 * @author Bruno Gino
 *
 */
public class Fornecedor {
	private SimpleIntegerProperty idFornecedor;
	private SimpleStringProperty razaoSocial;
	private SimpleStringProperty nomeSocial;
	private SimpleStringProperty cnpj;
	private SimpleStringProperty emailFornecedor;
	private SimpleStringProperty tel1;
	private SimpleStringProperty tel2;

	/**
	 * Construtor para geração de uma instância de um fornecedor , com atributos
	 * vazios.
	 */
	public Fornecedor() {

	}

	/**
	 * Construtor para geração de um objeto Fornecedor com todos os seus atributos.
	 * O uso deste construtor é indicado para modificação dos dados do fornecedor,
	 * pois o seu código pode ser utilizado como uma condição para aplicação de uma
	 * atualização de uma tupla no banco de dados, neste caso, obviamente, a
	 * sentença UPDATE.
	 * 
	 * @param idFornecedor Código do fornecedor.
	 * @param cnpj         CNPJ do fornecedor.
	 * @param nomeSocial   Nome social do fornecedor.
	 * @param razaoSocial  Razão social do fornecedor.
	 * @param tel1         Telefone 1 do fornecedor.
	 * @param tel2         Telefone 2 do fornecedor(Opcional).
	 * @param email        Endereço de e-mail do fornecedor.
	 */
	public Fornecedor(Integer idFornecedor, String cnpj, String nomeSocial, String razaoSocial, String tel1,
			String tel2, String email) {
		this.idFornecedor = new SimpleIntegerProperty(idFornecedor);
		this.razaoSocial = new SimpleStringProperty(razaoSocial);
		this.nomeSocial = new SimpleStringProperty(nomeSocial);
		this.cnpj = new SimpleStringProperty(cnpj);
		this.emailFornecedor = new SimpleStringProperty(email);
		this.tel1 = new SimpleStringProperty(tel1);
		this.tel2 = new SimpleStringProperty(tel2);
	}

	/**
	 * Construtor para geração de um objeto Fornecedor com todos os atributos
	 * principais, sem o código identificador. Este construtor é indicado para ser
	 * utilizado na criação de um novo fornecedor, pois o seu código de
	 * identificação é criado automaticamente no banco de dados por ser uma chave
	 * com atributo AUTO-INCREMENT. Ao ser criado um novo fornecedor, este terá um
	 * identificador atribuído automaticamente pelo banco de dados do sistema.
	 * 
	 * @param idFornecedor Código do fornecedor.
	 * @param cnpj         CNPJ do fornecedor.
	 * @param nomeSocial   Nome social do fornecedor.
	 * @param razaoSocial  Razão social do fornecedor.
	 * @param tel1         Telefone 1 do fornecedor.
	 * @param tel2         Telefone 2 do fornecedor(Opcional).
	 * @param email        Endereço de e-mail do fornecedor.
	 */
	public Fornecedor(String cnpj, String nomeSocial, String razaoSocial, String tel1, String tel2, String email) {
		this.razaoSocial = new SimpleStringProperty(razaoSocial);
		this.nomeSocial = new SimpleStringProperty(nomeSocial);
		this.cnpj = new SimpleStringProperty(cnpj);
		this.emailFornecedor = new SimpleStringProperty(email);
		this.tel1 = new SimpleStringProperty(tel1);
		this.tel2 = new SimpleStringProperty(tel2);
	}

	/**
	 * Retorna o identificador do fornecedor como objeto do tipo
	 * SimpleIntegerProperty.
	 * 
	 * @return ID como SimpleIntegerProperty.
	 */
	public final SimpleIntegerProperty idProperty() {
		return this.idFornecedor;
	}

	/**
	 * Retorna o valor do identificador como um numero inteiro.
	 * 
	 * @return ID do fornecedor como um Integer.
	 */
	public final int getId() {
		return this.idProperty().get();
	}

	/**
	 * Traz a razao social do fornecedor como um objeto do tipo
	 * SimpleStringProperty.
	 * 
	 * @return Razao social como SimpleStringProperty.
	 */
	public final SimpleStringProperty razaoSocialProperty() {
		return this.razaoSocial;
	}

	/**
	 * Traz a razao social do fornecedor como uma string.
	 * 
	 * @return Razao social como String.
	 */
	public final java.lang.String getRazaoSocial() {
		return this.razaoSocialProperty().get();
	}

	/**
	 * Concede o atributo de razao social ao fornecedor.
	 * 
	 * @param razaoSocial Razao social a  ser atribui­da.
	 */
	public final void setRazaoSocial(final java.lang.String razaoSocial) {
		this.razaoSocialProperty().set(razaoSocial);
	}

	/**
	 * Concede o nome social do fornecedor como SimpleStringProperty.
	 * 
	 * @return Nome do fornecedor no formato SimpleStringProperty.
	 */
	public final SimpleStringProperty nomeSocialProperty() {
		return this.nomeSocial;
	}

	/**
	 * Concede o nome social do fornecedor como uma string.
	 * 
	 * @return Nome social do fornecedor.
	 */
	public final java.lang.String getNomeSocial() {
		return this.nomeSocialProperty().get();
	}

	/**
	 * Define o nome social do fornecedor.
	 * 
	 * @param nomeSocial String informando o nome social.
	 */
	public final void setNomeSocial(final java.lang.String nomeSocial) {
		this.nomeSocialProperty().set(nomeSocial);
	}

	/**
	 * Retorna o CNPJ do fornecedor no formato de um objeto SimpleStringProperty.
	 * 
	 * @return CNPJ no formato SimpleStringProperty.
	 */
	public final SimpleStringProperty cnpjProperty() {
		return this.cnpj;
	}

	/**
	 * Retorna uma string contendo o CNPJ do fornecedor.
	 * 
	 * @return CNPJ do fornecedor.
	 */
	public final java.lang.String getCnpj() {
		return this.cnpjProperty().get();
	}

	/**
	 * Determina um CNPJ ao fornecedor no formato de String.
	 * 
	 * @param cnpj CNPJ a  ser atribui­do.
	 */
	public final void setCnpj(final java.lang.String cnpj) {
		this.cnpjProperty().set(cnpj);
	}

	/**
	 * Confere o e-mail do fornecedor no formato de um objeto SimpleStringProperty.
	 * 
	 * @return E-mail como SimpleStringProperty.
	 */
	public final SimpleStringProperty emailProperty() {
		return this.emailFornecedor;
	}

	/**
	 * Confere o e-mail do fornecedor como uma String.
	 * 
	 * @return E-mail do fornecedor.
	 */
	public final java.lang.String getEmail() {
		return this.emailProperty().get();
	}

	/**
	 * Atribui um e-mail ao fornecedor no formato de String.
	 * 
	 * @param email E-mail a ser atribui­do.
	 */
	public final void setEmail(final java.lang.String email) {
		this.emailProperty().set(email);
	}

	/**
	 * Fornece o telefone 1 do fornecedor como um objeto SimpleStringProperty.
	 * 
	 * @return Telefone 1 como SimpleStringProperty.
	 */
	public final SimpleStringProperty tel1Property() {
		return this.tel1;
	}

	/**
	 * Fornece o telefone 1 do fornecedor como uma String.
	 * 
	 * @return Telefone 1 do fornecedor.
	 */
	public final java.lang.String getTel1() {
		return this.tel1Property().get();
	}

	/**
	 * Designa o numero de telefone 1 ao fornecedor.
	 * 
	 * @param tel1 Telefone 1 do fornecedor no formato de String.
	 */
	public final void setTel1(final java.lang.String tel1) {
		this.tel1Property().set(tel1);
	}

	/**
	 * Fornece o telefone 2 do fornecedor como um objeto SimpleStringProperty.
	 * 
	 * @return Telefone 2 como SimpleStringProperty.
	 */
	public final SimpleStringProperty tel2Property() {
		return this.tel2;
	}

	/**
	 * Fornece o telefone 2 do fornecedor como uma String.
	 * 
	 * @return Telefone 2 do fornecedor.
	 */
	public final java.lang.String getTel2() {
		return this.tel2Property().get();
	}

	/**
	 * Designa o numero de telefone 2 ao fornecedor.
	 * 
	 * @param tel2 Telefone 2 do fornecedor no formato de String.
	 */
	public final void setTel2(final java.lang.String tel2) {
		this.tel2Property().set(tel2);
	}

	/**
	 * Retorna o valor property do id no padrao do framework JavaFX
	 * 
	 * @return property id
	 */
	public final SimpleIntegerProperty idFornecedorProperty() {
		return this.idFornecedor;
	}

	/**
	 * Retorna o id do fornecedor.
	 * 
	 * @return Retorna o id do fornecedor.
	 */
	public final int getIdFornecedor() {
		return this.idFornecedorProperty().get();
	}

	/**
	 * Define o id do fornecedor.
	 * 
	 * @param idFornecedor id a  ser atribui­do.
	 */
	public final void setIdFornecedor(final int idFornecedor) {
		this.idFornecedorProperty().set(idFornecedor);
	}

	/**
	 * Retorna o valor property do e-mail no padrao do framework JavaFX
	 * 
	 * @return property e-mail
	 */
	public final SimpleStringProperty emailFornecedorProperty() {
		return this.emailFornecedor;
	}

	/**
	 * Retorna o e-mail do fornecedor.
	 * 
	 * @return e-mail do fornecedor.
	 */
	public final String getEmailFornecedor() {
		return this.emailFornecedorProperty().get();
	}

	/**
	 * Define o e-mail do fornecedor.
	 * 
	 * @param idFornecedor id a  ser atribui­do.
	 */
	public final void setEmailFornecedor(final String emailFornecedor) {
		this.emailFornecedorProperty().set(emailFornecedor);
	}

}
