package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Classe responsaveis por acoplar os pedidos solicitados pelos Clientes,
 * enderecando-os e baixando o estoque conforme novos pedidos sao efetuados.
 * 
 * @author Bruno Gino
 *
 */
public class Pedido {
	private SimpleIntegerProperty id;
	private SimpleDoubleProperty precoTotal;
	private SimpleStringProperty data;
	private SimpleIntegerProperty pagamento;
	private SimpleStringProperty anotacao;
	private SimpleDoubleProperty troco;
	private SimpleIntegerProperty cliente;
	private SimpleStringProperty produtos;
	private SimpleIntegerProperty funcionario;
	private SimpleStringProperty tamanho;
	private SimpleIntegerProperty quantidade;

	/**
	 * Cria uma instância de um pedido com todos os seus atributos.
	 * 
	 * @param id          Identificador do pedido.
	 * @param cliente     Código do cliente que fez a solicitacao do pedido.
	 * @param produto     Nome do produto solicitado pelo cliente.
	 * @param funcionario Código do funcionario responsavel pelo registro do pedido.
	 * @param tamanho     Tamanho da pizza solicitada.
	 * @param quantidade  Quantidade de itens solicitados no pedido.
	 * @param pagamento   Tipo de pagamento do pedido, podendo ser : 1 - Dinheiro ;
	 *                    2 - Cartão ; 3 - Cheque.
	 * @param data        Data e hora na qual o pedido foi efetuado.
	 * @param anotacao    Anotacoes referentes ao pedido. Ex.: Exclusao de um
	 *                    ingrediente, ou anotacoes referentes a  entrega.
	 * @param troco       Troco baseado no pagamento do cliente.
	 * @param total       Preco total dos itens.
	 */
	public Pedido(Integer id, Integer cliente, String produto, Integer funcionario, String tamanho, Integer quantidade,
			Integer pagamento, String data, String anotacao, Double troco, Double total) {
		this.id = new SimpleIntegerProperty(id);
		this.cliente = new SimpleIntegerProperty(cliente);
		this.produtos = new SimpleStringProperty(produto);
		this.funcionario = new SimpleIntegerProperty(funcionario);
		this.tamanho = new SimpleStringProperty(tamanho);
		this.quantidade = new SimpleIntegerProperty(quantidade);
		this.pagamento = new SimpleIntegerProperty(pagamento);
		this.data = new SimpleStringProperty(data);
		this.anotacao = new SimpleStringProperty(anotacao);
		this.troco = new SimpleDoubleProperty(troco);
		this.precoTotal = new SimpleDoubleProperty(total);
	}

	/**
	 * Gera uma instância de um produto sem código identificador.
	 * 
	 * @param cliente     Código do cliente que fez a solicitacao do pedido.
	 * @param produto     Nome do produto solicitado pelo cliente.
	 * @param funcionario Código do funcionario responsavel pelo registro do pedido.
	 * @param tamanho     Tamanho da pizza solicitada.
	 * @param quantidade  Quantidade de itens solicitados no pedido.
	 * @param pagamento   Tipo de pagamento do pedido, podendo ser : 1 - Dinheiro ;
	 *                    2 - Cartão ; 3 - Cheque.
	 * @param data        Data e hora na qual o pedido foi efetuado.
	 * @param anotacao    Anotacoes referentes ao pedido. Ex.: Exclusao de um
	 *                    ingrediente, ou anotacoes referentes a  entrega.
	 * @param troco       Troco baseado no pagamento do cliente.
	 * @param total       Preco total dos itens.
	 */
	public Pedido(Integer cliente, String produto, Integer funcionario, String tamanho, Integer quantidade,
			Integer pagamento, String data, String anotacao, Double troco, Double total) {
		this.cliente = new SimpleIntegerProperty(cliente);
		this.produtos = new SimpleStringProperty(produto);
		this.funcionario = new SimpleIntegerProperty(funcionario);
		this.tamanho = new SimpleStringProperty(tamanho);
		this.quantidade = new SimpleIntegerProperty(quantidade);
		this.pagamento = new SimpleIntegerProperty(pagamento);
		this.data = new SimpleStringProperty(data);
		this.anotacao = new SimpleStringProperty(anotacao);
		this.troco = new SimpleDoubleProperty(troco);
		this.precoTotal = new SimpleDoubleProperty(total);
	}

	/**
	 * Metodo responsavel por executar a baixa automatica no estoque, com base nos
	 * itens selecionados.
	 */
	public void baixarEstoque() {

	}

	/**
	 * Retorna o ID do pedido no formato de um objeto SimpleIntegerProperty.
	 * 
	 * @return ID do pedido em formato SimpleIntegerProperty.
	 */
	public final SimpleIntegerProperty idProperty() {
		return this.id;
	}

	/**
	 * Retorna o valor do atributo ID do pedido.
	 * 
	 * @return ID do pedido.
	 */
	public final int getId() {
		return this.idProperty().get();
	}

	public final void setId(final Integer id) {
		this.idProperty().set(id);
	}

	/**
	 * Retorna o preco total do pedido em formato de um objeto SimpleFloatProperty
	 * 
	 * @return Preco total do pedido em formato SimpleFloatProperty.
	 */
	public final SimpleDoubleProperty precoTotalProperty() {
		return this.precoTotal;
	}

	/**
	 * Retorna o valor do preco total do pedido.
	 * 
	 * @return Preco total do pedido.
	 */
	public final double getPrecoTotal() {
		return this.precoTotalProperty().get();
	}

	/**
	 * Define o valor do preco total do pedido
	 * 
	 * @param precoTotal Valor a ser atribui­do.
	 */
	public final void setPrecoTotal(final double precoTotal) {
		this.precoTotalProperty().set(precoTotal);
	}

	/**
	 * Retorna a anotacao do pedido em formato de um objeto SimpleStringProperty.
	 * 
	 * @return Anotacao do pedido em formato SimpleStringProperty.
	 */
	public final SimpleStringProperty anotacaoProperty() {
		return this.anotacao;
	}

	/**
	 * Retorna o valor de String da anotacao do pedido.
	 * 
	 * @return Anotacao do pedido em formato de String.
	 */
	public final java.lang.String getAnotacao() {
		return this.anotacaoProperty().get();
	}

	/**
	 * Define a anotacao do pedido.
	 * 
	 * @param anotacao Conteudo a ser armazenado como anotacao.
	 */
	public final void setAnotacao(final java.lang.String anotacao) {
		this.anotacaoProperty().set(anotacao);
	}

	/**
	 * Retorna o troco do pedido em formato de um objeto SimpleFloatProperty.
	 * 
	 * @return Troco em formato SimpleFloatProperty.
	 */
	public final SimpleDoubleProperty trocoProperty() {
		return this.troco;
	}

	/**
	 * Retorna o valor do troco.
	 * 
	 * @return Troco do pedido.
	 */
	public final double getTroco() {
		return this.trocoProperty().get();
	}

	/**
	 * Define o valor do troco do pedido.
	 * 
	 * @param troco Valor a ser atribui­do como troco.
	 */
	public final void setTroco(final double troco) {
		this.trocoProperty().set(troco);
	}

	/**
	 * 
	 * @return
	 */
	public final SimpleIntegerProperty clienteProperty() {
		return this.cliente;
	}

	public final int getCliente() {
		return this.clienteProperty().get();
	}

	public final void setCliente(final int cliente) {
		this.clienteProperty().set(cliente);
	}

	public final SimpleStringProperty produtosProperty() {
		return this.produtos;
	}

	public final String getProdutos() {
		return this.produtosProperty().get();
	}

	public final void setProdutos(final String produtos) {
		this.produtosProperty().set(produtos);
	}

	public final SimpleIntegerProperty funcionarioProperty() {
		return this.funcionario;
	}

	public final Integer getFuncionario() {
		return this.funcionarioProperty().get();
	}

	public final void setFuncionario(final Integer funcionario) {
		this.funcionarioProperty().set(funcionario);
	}

	public final SimpleStringProperty tamanhoProperty() {
		return this.tamanho;
	}

	public final String getTamanho() {
		return this.tamanhoProperty().get();
	}

	public final void setTamanho(final String tamanho) {
		this.tamanhoProperty().set(tamanho);
	}

	public final SimpleIntegerProperty quantidadeProperty() {
		return this.quantidade;
	}

	public final int getQuantidade() {
		return this.quantidadeProperty().get();
	}

	public final void setQuantidade(final int quantidade) {
		this.quantidadeProperty().set(quantidade);
	}

	public final SimpleStringProperty dataProperty() {
		return this.data;
	}

	public final String getData() {
		return this.dataProperty().get();
	}

	public final void setData(final String data) {
		this.dataProperty().set(data);
	}

	public final SimpleIntegerProperty pagamentoProperty() {
		return this.pagamento;
	}

	public final int getPagamento() {
		return this.pagamentoProperty().get();
	}

	public final void setPagamento(final int pagamento) {
		this.pagamentoProperty().set(pagamento);
	}

}
