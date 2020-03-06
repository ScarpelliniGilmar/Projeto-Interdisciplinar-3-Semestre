package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Classe representadora do estoque do estabelecimento. Apresenta todas as
 * caracteristicas referentes a  dados cruciais do estoque para manter o
 * controle dos insumos, cadastrados no banco de dados no sistema. A baixa dos
 * itens do estoque se dao pelo metodo baixarEstoque() da classe Pedido, pois
 * somente ao efetuar um pedido, a classe Estoque podera receber as informacoes
 * concedidas pela classe de Pedido,na qual irao executar a baixa
 * automaticamente.
 * 
 * @author Bruno Gino
 *
 */
public class Estoque {
	private SimpleIntegerProperty idInsumo;
	private SimpleStringProperty descricao;
	private SimpleDoubleProperty precoInsumo;
	private SimpleStringProperty unidadeMedida;
	private SimpleIntegerProperty quantidadeDisp;

	private SimpleStringProperty fornecedor;

	/**
	 * Construtor para uma instância de um Estoque com atributos vazios.
	 */
	public Estoque() {

	}

	/**
	 * Construtor para geração de uma instância de Estoque com todos os atributos.A
	 * instância não é em sí um estoque, mas sim insumos to estoque do
	 * estabelecimento. O nome social do fornecedor é colocado aqui como parâmetro,
	 * facilitando assim o retorno de uma consulta com junção no banco de dados.
	 * 
	 * @param id            Código do insumo do estoque.
	 * @param descricao     Descrição/Logomarca do produto.
	 * @param preco         Preço unitário do produto.
	 * @param unidadeMedida Unidade de medida do insumo.
	 * @param quantidade    Quantidade disponível deste insumo no estoque.
	 * @param fornecedor    Nome do fornecedor do insumo.
	 */
	public Estoque(Integer id, String descricao, Double preco, String unidadeMedida, Integer quantidade,
			String fornecedor) {
		this.idInsumo = new SimpleIntegerProperty(id);
		this.descricao = new SimpleStringProperty(descricao);
		this.precoInsumo = new SimpleDoubleProperty(preco);
		this.unidadeMedida = new SimpleStringProperty(unidadeMedida);
		this.quantidadeDisp = new SimpleIntegerProperty(quantidade);
		this.fornecedor = new SimpleStringProperty(fornecedor);
	}

	/**
	 * Retorna o ID do insumo como um objeto do tipo SimpleIntegerProperty.
	 * 
	 * @return ID do insumo no formato SimpleIntegerProperty.
	 */
	public final SimpleIntegerProperty idProperty() {
		return this.idInsumo;
	}

	/**
	 * Retorna o ID do insumo como um numero inteiro.
	 * 
	 * @return ID do insumo.
	 */
	public final int getIdInsumo() {
		return this.idProperty().get();
	}

	/**
	 * Atribui um ID ao insumo.
	 * 
	 * @param id ID a  ser atribuido.
	 */
	public final void setId(final int id) {
		this.idProperty().set(id);
	}

	/**
	 * Retorna a descricao do insumo como um objeto SimpleStringProeperty.
	 * 
	 * @return Descricao do insumo no formato SimpleStringProperty.
	 */
	public final SimpleStringProperty descricaoProperty() {
		return this.descricao;
	}

	/**
	 * Traz a descricao do insumo como uma string.
	 * 
	 * @return Descricao do insumo.
	 */
	public final java.lang.String getDescricao() {
		return this.descricaoProperty().get();
	}

	/**
	 * Estabelece uma descricao para o item do estoque.
	 * 
	 * @param descricao Descricao a  ser concedida.
	 */
	public final void setDescricao(final java.lang.String descricao) {
		this.descricaoProperty().set(descricao);
	}

	/**
	 * Traz o o valor unitario do insumo como um objeto SimpleFloatProperty.
	 * 
	 * @return Preco unitario do insumo no formato SimpleFloatProperty.
	 */
	public final SimpleDoubleProperty precoProperty() {
		return this.precoInsumo;
	}

	/**
	 * Retorna o valor unitario como um Float.
	 * 
	 * @return Preco unitario do item.
	 */
	public final double getPrecoInsumo() {
		return this.precoProperty().get();
	}

	/**
	 * Concede um preco ao item.
	 * 
	 * @param preco Preco a ser atribuido.
	 */
	public final void setPreco(final double preco) {
		this.precoProperty().set(preco);
	}

	/**
	 * Proporciona a unidade de medida do item como um objeto SimpleStringProperty.
	 * 
	 * @return Unidade de medida do item no formato SimpleStringProperty.
	 */
	public final SimpleStringProperty unidadeMedidaProperty() {
		return this.unidadeMedida;
	}

	/**
	 * Traza a unidade de medida do produto como uma string.
	 * 
	 * @return Unidade de medida do produto.
	 */
	public final java.lang.String getUnidadeMedida() {
		return this.unidadeMedidaProperty().get();
	}

	/**
	 * Imputa uma unidade de medida ao insumo.
	 * 
	 * @param unidadeMedida Unidade de medida a ser atribuida.
	 */
	public final void setUnidadeMedida(final java.lang.String unidadeMedida) {
		this.unidadeMedidaProperty().set(unidadeMedida);
	}

	/**
	 * Traz a quantidade disponivel do item no estoque como um objeto do tipo
	 * SimpleIntegerProperty.
	 * 
	 * @return Quantidade disponivel no formato SimpleIntegerProperty.
	 */
	public final SimpleIntegerProperty quantidadeProperty() {
		return this.quantidadeDisp;
	}

	/**
	 * Retorna a quantidade disponivel do item no estoque como um valor inteiro.
	 * 
	 * @return Quantidade disponivel do item.
	 */
	public final float getQuantidadeDisp() {
		return this.quantidadeProperty().get();
	}

	/**
	 * Altera a quantidade disponivel de um item registrado no estoque.
	 * 
	 * @param quantidade Nova quantidade a ser atribuida.
	 */
	public final void setQuantidade(final int quantidade) {
		this.quantidadeProperty().set(quantidade);
	}

	/**
	 * Retorna o valor de propriedade JavaFX do nome do fornecedor, pode ser usado
	 * na implementação de componenetes do framework.
	 * 
	 * @return Propriedade de nome do fornecedor.
	 */
	public final SimpleStringProperty fornecedorProperty() {
		return this.fornecedor;
	}

	/**
	 * Retorna o valor de String do nome social do fornecedor.
	 * 
	 * @return Nome do fornecedor.
	 */
	public final String getFornecedor() {
		return this.fornecedorProperty().get();
	}

	/**
	 * Atribui um valor de String como nome social do fornecedor.
	 * 
	 * @param fornecedor Nome social à ser atribuído.
	 */
	public final void setFornecedor(final String fornecedor) {
		this.fornecedorProperty().set(fornecedor);
	}

}
