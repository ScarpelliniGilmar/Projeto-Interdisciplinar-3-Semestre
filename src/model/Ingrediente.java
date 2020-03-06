package model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * Representacao do ingrediente usado no produto, podendo identificar a
 * quantidade dos itens do estoque que serao utilizado no preparo da pizza.
 * 
 * @author Bruno Gino
 *
 */
public class Ingrediente {
	private SimpleIntegerProperty id;
	private SimpleIntegerProperty quantidade;
	private List<Estoque> insumo = new ArrayList<>();

	/**
	 * Produz uma instancia de um ingrediente que sera utilizado por uma instancia
	 * da classe Produto.
	 * 
	 * @param id         Identificador do ingrediente.
	 * @param quantidade Quantidade a ser utilizada no preparo.
	 * @param insumo     Lista de insumos que compoe o ingrediente.
	 */
	public Ingrediente(Integer id, Integer quantidade, List<Estoque> insumo) {
		this.id = new SimpleIntegerProperty(id);
		this.quantidade = new SimpleIntegerProperty(quantidade);
		this.insumo = insumo;
	}

	/**
	 * Traz a lista de itens do estoque utilizadas no ingrediente.
	 * 
	 * @return Lista de insumos.
	 */
	public List<Estoque> getInsumo() {
		return insumo;
	}

	/**
	 * Define os itens da lista de insumos.
	 * 
	 * @param insumo Insumos a serem adicionados.
	 */
	public void setInsumo(List<Estoque> insumo) {
		this.insumo = insumo;
	}

	/**
	 * Retorna o identificador do ingrediente no formato de um objeto
	 * SimpleIntegerProperty.
	 * 
	 * @return Identificador do ingrediente como SimpleIntegerProperty.
	 */
	public final SimpleIntegerProperty idProperty() {
		return this.id;
	}

	/**
	 * Retorna o valor do identificador como numero inteiro.
	 * 
	 * @return ID no formato de Integer.
	 */
	public final int getId() {
		return this.idProperty().get();
	}

	/**
	 * Define o identificador do ingrediente.
	 * 
	 * @param id ID a ser atribui­do.
	 */
	public final void setId(final int id) {
		this.idProperty().set(id);
	}

	/**
	 * Retorna a quantidade a ser utilizada no preparo do produto, como um objeto
	 * SimpleIntegerProperty.
	 * 
	 * @return Quantidade do ingrediente como SimpleIntegerProperty.
	 */
	public final SimpleIntegerProperty quantidadeProperty() {
		return this.quantidade;
	}

	/**
	 * Traz a quantidade do ingrediente a ser utilizada, como um valor inteiro.
	 * 
	 * @return Quantidade do ingrediente.
	 */
	public final int getQuantidade() {
		return this.quantidadeProperty().get();
	}

	/**
	 * Define a quantidade do item i  ser utilizado.
	 * 
	 * @param quantidade Quantidade requisitada a ser atribui­da.
	 */
	public final void setQuantidade(final int quantidade) {
		this.quantidadeProperty().set(quantidade);
	}

}
