package model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Classe que representa os produtos vendidos pelo estabelecimento, no caso as
 * pizzas.
 * 
 * @author Bruno Gino
 *
 */
public class Produto {
	private SimpleIntegerProperty id;
	private SimpleStringProperty nome;
	private SimpleFloatProperty preco;
	private SimpleIntegerProperty quantidade;
	private SimpleStringProperty funcionario;
	private List<Ingrediente> ingredientes = new ArrayList<>();

	/**
	 * Gera um item do cardapio.
	 * 
	 * @param id           Identificador da pizza.
	 * @param nome         Nome da pizza.
	 * @param preco        Preco da pizza.
	 * @param ingredientes Lista de ingredientes a ser utilizada no preparo da
	 *                     pizza.
	 */
	public Produto(Integer id, String nome, Float preco, String funcionario) {
		this.id = new SimpleIntegerProperty(id);
		this.nome = new SimpleStringProperty(nome);
		this.preco = new SimpleFloatProperty(preco);
		this.funcionario = new SimpleStringProperty(funcionario);
	}

	/**
	 * Traz a lista de ingredientes utilizados.
	 * 
	 * @return Lista de ingredientes da pizza.
	 */
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	/**
	 * Define os ingredientes da pizza.
	 * 
	 * @param ingredientes Lista de ingredientes a  ser atribui­da.
	 */
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	/**
	 * Retorna o identificador da pizza como um objeto SimpleIntegerProperty.
	 * 
	 * @return ID como SimpleIntegerProperty.
	 */
	public final SimpleIntegerProperty idProperty() {
		return this.id;
	}

	/**
	 * Traz o identificador da pizza como um valor inteiro.
	 * 
	 * @return ID da pizza.
	 */
	public final int getId() {
		return this.idProperty().get();
	}

	/**
	 * Traz o nome da pizza como um objeto SimpleStringProperty.
	 * 
	 * @return Nome da pizza como SimpleStringProperty.
	 */
	public final SimpleStringProperty nomeProperty() {
		return this.nome;
	}

	/**
	 * Traz o nome da pizza como uma String.
	 * 
	 * @return Nome da pizza.
	 */
	public final java.lang.String getNome() {
		return this.nomeProperty().get();
	}

	/**
	 * Designa um nome a  pizza.
	 * 
	 * @param nome Nome a  ser designado.
	 */
	public final void setNome(final java.lang.String nome) {
		this.nomeProperty().set(nome);
	}

	/**
	 * Retorna o preco da pizza como um objeto SimpleFloatProperty.
	 * 
	 * @return Preco da pizza, como SimpleFloatProperty.
	 */
	public final SimpleFloatProperty precoProperty() {
		return this.preco;
	}

	/**
	 * Retorna o preco da pizza, como um numero Float.
	 * 
	 * @return
	 */
	public final float getPreco() {
		return this.precoProperty().get();
	}

	/**
	 * Designa um valor como preco da pizza.
	 * 
	 * @param preco Preco da pizza a  ser atribui­do.
	 */
	public final void setPreco(final float preco) {
		this.precoProperty().set(preco);
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

	public final SimpleStringProperty funcionarioProperty() {
		return this.funcionario;
	}

	public final String getFuncionario() {
		return this.funcionarioProperty().get();
	}

	public final void setIdFuncionario(final String funcionario) {
		this.funcionarioProperty().set(funcionario);
	}

}
