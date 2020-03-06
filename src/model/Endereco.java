package model;

import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Classe de modelo que referencia a entidade Endereco do banco de dados. Contem
 * uma lista de clientes, no qual permite que varios clientes sejam adicionados
 * no mesmo endereco para flexibilizar a geracao de pedidos.
 * 
 * @author Bruno Gino
 *
 */
public class Endereco {
	private SimpleIntegerProperty id;
	private SimpleStringProperty rua;
	private SimpleIntegerProperty numero;
	private SimpleStringProperty bairro;
	private SimpleStringProperty cep;
	private SimpleStringProperty complemento;
	private SimpleIntegerProperty idCliente;
	private ArrayList<Cliente> cliente = new ArrayList<Cliente>();

	/**
	 * Cria uma instancia de um endereco.
	 * 
	 * @param id          Identificador do endereco.
	 * @param rua         Rua localizada no endereco
	 * @param numero      Numero da residencia
	 * @param bairro      Bairro na qual a residencia se situa.
	 * @param cep         CEP do local.
	 * @param complemento Complemento de endereco do cliente. Ex.: Casa, apartamento
	 *                    ...
	 * @param cliente     Lista de clientes que residem no local.
	 */
	public Endereco(String rua, Integer numero, String bairro, String cep, String complemento) {
		this.rua = new SimpleStringProperty(rua);
		this.numero = new SimpleIntegerProperty(numero);
		this.bairro = new SimpleStringProperty(bairro);
		this.cep = new SimpleStringProperty(cep);
		this.complemento = new SimpleStringProperty(complemento);
	}

	/**
	 * Construtor para geração de uma instância de endereço, com o identificador do
	 * código do cliente para indicar à qual cliente este endereço pertence.
	 * 
	 * @param rua         Rua do endereço.
	 * @param numero      Número do endereço.
	 * @param bairro      Bairro do endereço.
	 * @param cep         CEP do endereço.
	 * @param complemento Complemento do endereço, podendo ser casa, apartamento,
	 *                    etc.
	 * @param idCliente   Código do cliente que é dono deste endereço.
	 */
	public Endereco(String rua, Integer numero, String bairro, String cep, String complemento, Integer idCliente) {
		this.rua = new SimpleStringProperty(rua);
		this.numero = new SimpleIntegerProperty(numero);
		this.bairro = new SimpleStringProperty(bairro);
		this.cep = new SimpleStringProperty(cep);
		this.complemento = new SimpleStringProperty(complemento);
		this.idCliente = new SimpleIntegerProperty(idCliente);
	}

	/**
	 * Retorna a lista de clientes pertencentes ao endereco.
	 * 
	 * @return Objeto da lista de clientes.
	 */
	public ArrayList<Cliente> getCliente() {
		return cliente;
	}

	/**
	 * Define qual objeto cliente ira pertencer ao endereco.
	 * 
	 * @param cliente Cliente a ser adicionado ao endereco.
	 */
	public void addCliente(Cliente cliente) {
		this.cliente.add(cliente);
	}

	/**
	 * Retorna o ID do endereco como um objeto do tipo SimpleIntegerProperty.
	 * 
	 * @return ID do endereco no formato SimpleIntegerProperty.
	 */
	public final SimpleIntegerProperty idProperty() {
		return this.id;
	}

	/**
	 * Retorna o valor base do ID do endereco.
	 * 
	 * @return ID do endereco.
	 */
	public final int getId() {
		return this.idProperty().get();
	}

	/**
	 * Retorna o atributo rua do endereco como um objeto SimpleStringProperty.
	 * 
	 * @return Rua do endereco no formato SimpleStringProperty.
	 */
	public final SimpleStringProperty ruaProperty() {
		return this.rua;
	}

	/**
	 * Retorna a string que informa a rua do endereco.
	 * 
	 * @return Rua do endereco.
	 */
	public final java.lang.String getRua() {
		return this.ruaProperty().get();
	}

	/**
	 * Define qual rua o endereco esta vinculado.
	 * 
	 * @param rua Rua a ser atribuida.
	 */
	public final void setRua(final java.lang.String rua) {
		this.ruaProperty().set(rua);
	}

	/**
	 * Retorna o numero da residencia no formato de um objeto
	 * SimpleIntegerProperrty.
	 * 
	 * @return Numero da residencia como SimpleIntegerProperty.
	 */
	public final SimpleIntegerProperty numeroProperty() {
		return this.numero;
	}

	/**
	 * Retorna o numero da residencia como um valor base.
	 * 
	 * @return Numero do endereco.
	 */
	public final int getNumero() {
		return this.numeroProperty().get();
	}

	/**
	 * Define o numero cujo identifica a residencia.
	 * 
	 * @param numero Numero a ser atribuido ao endereco.
	 */
	public final void setNumero(final int numero) {
		this.numeroProperty().set(numero);
	}

	/**
	 * Traz o bairro cujo o endereco e pertencente como um objeto
	 * SimpleStringProperty.
	 * 
	 * @return Bairro do endereco como objeto SimpleIntegerProperty.
	 */
	public final SimpleStringProperty bairroProperty() {
		return this.bairro;
	}

	/**
	 * Traz o bairro que contem o endereco, como um valor de String.
	 * 
	 * @return Bairro vinculado ao endereco.
	 */
	public final java.lang.String getBairro() {
		return this.bairroProperty().get();
	}

	/**
	 * Define o bairro a  ser vinculado com o endereco.
	 * 
	 * @param bairro Bairro a ser atribuido.
	 */
	public final void setBairro(final java.lang.String bairro) {
		this.bairroProperty().set(bairro);
	}

	/**
	 * Concede o CEP do endereco como um objeto do tipo SimpleStringProperty.
	 * 
	 * @return CEP do endereco como SimpleStringProperty.
	 */
	public final SimpleStringProperty cepProperty() {
		return this.cep;
	}

	/**
	 * Retorna o CEP como uma string.
	 * 
	 * @return CEP do endereco.
	 */
	public final java.lang.String getCep() {
		return this.cepProperty().get();
	}

	/**
	 * Imputa um CEP ao endereco.
	 * 
	 * @param cep CEP a ser imputado.
	 */
	public final void setCep(final java.lang.String cep) {
		this.cepProperty().set(cep);
	}

	/**
	 * Retorna o complemento do endereco como um objeto SimpleStringProperty.
	 * 
	 * @return Complemento no formato SimpleStringProperty.
	 */
	public final SimpleStringProperty complementoProperty() {
		return this.complemento;
	}

	/**
	 * Traz o complemento do endereco como uma string.
	 * 
	 * @return Complemento do endereco.
	 */
	public final java.lang.String getComplemento() {
		return this.complementoProperty().get();
	}

	/**
	 * Imputa o complemento ao endereco.
	 * 
	 * @param complemento Complemento a ser imputado.
	 */
	public final void setComplemento(final java.lang.String complemento) {
		this.complementoProperty().set(complemento);
	}

	/**
	 * Retorna o valor propriedade do código do cliente, requisitado pelo framework
	 * JavaFX na utilização de seus componentes.
	 * 
	 * @return Propriedade do identificador do cliente.
	 */
	public final SimpleIntegerProperty idClienteProperty() {
		return this.idCliente;
	}

	/**
	 * Retorna o código do cliente como um inteiro.
	 * 
	 * @return Código do cliente.
	 */
	public final int getIdCliente() {
		return this.idClienteProperty().get();
	}

	/**
	 * Atribui um valor inteiro como código do cliente.
	 * 
	 * @param idCliente Código à ser atribuído.
	 */
	public final void setIdCliente(final int idCliente) {
		this.idClienteProperty().set(idCliente);
	}

}
