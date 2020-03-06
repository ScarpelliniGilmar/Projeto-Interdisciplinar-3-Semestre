package model;

/**
 * Interface que permite implementar as funcoes de gerenciamento do
 * estabelecimento. Cabe diretamente ao usuario administrador implementar tal
 * interface para executar sua funcao, por se tratar de funcoes que exigem maior
 * hierarquia.
 * 
 * @author Bruno Gino
 *
 */
public interface Gerenciador {
	/**
	 * Gerencia o cardapio do estabelecimento a partir de varias operacoes. Tais
	 * operacoes envolvem a manipulacao completa dos dados, com intervencoes ma­nimas
	 * de integridade para preservar a seguranca do banco de dados.
	 * 
	 * @param produto  Item do cardapio a ser alterado.
	 * @param operacao Operacao escolhida para ser executada.Recebe uma constante
	 *                 numerica que identifica a operacao.
	 * @return Mensagem informando a conclusao da operacao selecionada.
	 */
	public String gerenciarCardapio(Produto produto, final int operacao);

	/**
	 * Metodo que permite a administracao de todos os fornecedores cadastrados no
	 * sistema.
	 * 
	 * @param fornecedor Fornecedor cadastrado a ser modificado pelo administrador.
	 * @param operacao   Operacao selecionada a ser executada. Recebe uma constante
	 *                   numerica que identifica qual operacao de manipulacao de
	 *                   dados a ser executada.
	 * @return Mensagem informando a conclusao da operacao selecionada.
	 */
	public String gerenciarFornecedor(Fornecedor fornecedor, final int operacao);

	/**
	 * Gerencia os itens cadastrados no estoque a  partir de uma operacao.
	 * 
	 * @param estoque  Item do estoque a ser manipulado.
	 * @param operacao Operacao selecionada a ser executada. Recebe uma constante
	 *                 numerica que identifica qual operacao de manipulacao de dados
	 *                 a ser executada.
	 * @return Mensagem informando a conclusao da operacao selecionada.
	 */
	public String gerenciarEstoque(Estoque estoque, final int operacao);

	/**
	 * Gerencia os funcionarios cadastrados no sistema.
	 * 
	 * @param funcionario Funcionario a ser utilizado na operacao de manipulacao.
	 * @param operacao    Operacao selecionada a ser executada. Recebe uma constante
	 *                    numerica que identifica qual operacao de manipulacao de
	 *                    dados a ser executada.
	 * @return Mensagem informando a conclusao da operacao selecionada.
	 */
	public String gerenciarFuncionario(Funcionario funcionario, final int operacao);

}
