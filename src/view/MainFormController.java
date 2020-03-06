package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import controller.LoginFormController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cliente;
import model.Estoque;
import model.Fornecedor;
import model.Funcionario;
import model.Pedido;
import model.Produto;
import model.TableLoader;

public class MainFormController implements Initializable {
	@FXML
	public AnchorPane anchorPane = new AnchorPane();
	@FXML
	public JFXTabPane tabPane;
	@FXML
	public Tab pedidos;

	@FXML
	public Tab cardapio;

	@FXML
	public Tab estoque;

	@FXML
	public Tab fornecedores;

	@FXML
	public Tab clientes;

	@FXML
	public Tab funcionarios;

	@FXML
	public Tab estatisticas;
	@FXML
	private JFXDrawer drawerC = new JFXDrawer();
	@FXML
	private JFXDrawer drawerPr = new JFXDrawer();
	@FXML
	private JFXDrawer drawerPe = new JFXDrawer();
	@FXML
	private JFXDrawer drawerE = new JFXDrawer();
	@FXML
	private JFXDrawer drawerF = new JFXDrawer();
	@FXML
	private JFXDrawer drawerFu = new JFXDrawer();
	@FXML
	private JFXHamburger hamCliente;
	@FXML
	private JFXHamburger hamProduto;
	@FXML
	private JFXHamburger hamPedido;
	@FXML
	private JFXHamburger hamEstoque;
	@FXML
	private JFXHamburger hamFuncionario;
	@FXML
	private JFXHamburger hamFornecedor;
	@FXML
	private AnchorPane toolbarC = new AnchorPane();
	@FXML
	private AnchorPane toolbarPr = new AnchorPane();
	@FXML
	private AnchorPane toolbarPe = new AnchorPane();
	@FXML
	private AnchorPane toolbarE = new AnchorPane();
	@FXML
	private AnchorPane toolbarFu = new AnchorPane();
	@FXML
	private StackPane toolbarFor = new StackPane();
	@FXML
	private TableColumn<Fornecedor, Integer> idFornecedor;
	@FXML
	private TableColumn<Fornecedor, String> razaoSocial;
	@FXML
	private TableColumn<Fornecedor, String> nomeSocial;
	@FXML
	private TableColumn<Fornecedor, String> cnpj;
	@FXML
	private TableColumn<Fornecedor, String> emailFornecedor;
	@FXML
	private TableColumn<Fornecedor, String> tel1;
	@FXML
	private TableColumn<Fornecedor, String> tel2;
	@FXML
	private TableColumn<Funcionario, Integer> id;
	@FXML
	private TableColumn<Funcionario, String> nome;
	@FXML
	private TableColumn<Funcionario, String> cpf;
	@FXML
	private TableColumn<Funcionario, Integer> nivelAcesso;
	@FXML
	private TableColumn<Funcionario, String> senha;
	@FXML
	private TableColumn<Estoque, Integer> idInsumo;
	@FXML
	private TableColumn<Estoque, String> descricao;
	@FXML
	private TableColumn<Estoque, Double> precoInsumo;
	@FXML
	private TableColumn<Estoque, String> unidadeMedida;
	@FXML
	private TableColumn<Estoque, Integer> quantidadeDisp;
	@FXML
	private TableColumn<Estoque, Integer> fornecedor;
	@FXML
	private TableColumn<Cliente, Integer> idCliente;
	@FXML
	private TableColumn<Cliente, String> nomeCliente;
	@FXML
	private TableColumn<Cliente, String> celularCliente;
	@FXML
	private TableColumn<Cliente, String> emailCliente;
	@FXML
	private TableColumn<Cliente, String> telefoneCliente;
	@FXML
	private TableColumn<Cliente, String> dataNascCliente;
	@FXML
	private TableColumn<Pedido, Integer> codigoPedido;
	@FXML
	private TableColumn<Pedido, Integer> idCPedido;
	@FXML
	private TableColumn<Pedido, Integer> idProduto;
	@FXML
	private TableColumn<Pedido, Integer> idFuPedido;
	@FXML
	private TableColumn<Pedido, String> tamPedido;
	@FXML
	private TableColumn<Pedido, Integer> qtdPedido;
	@FXML
	private TableColumn<Pedido, Integer> formaPag;
	@FXML
	private TableColumn<Pedido, String> dataPedido;
	@FXML
	private TableColumn<Pedido, String> anotacaoPe;
	@FXML
	private TableColumn<Pedido, Double> trocoPe;
	@FXML
	private TableColumn<Pedido, Double> precoTotal;
	@FXML
	private TableColumn<Produto, Integer> codProduto;
	@FXML
	private TableColumn<Produto, String> nomeProduto;
	@FXML
	private TableColumn<Produto, Float> preco;
	@FXML
	private TableColumn<Produto, Integer> funcionarioProduto;
	@FXML
	private TableView<Pedido> tbPedido;
	@FXML
	private TableView<Produto> tbCardapio;
	@FXML
	private TableView<Estoque> tbEstoque;
	@FXML
	private TableView<Cliente> tbCliente;
	@FXML
	private TableView<Fornecedor> tbFornecedores;
	@FXML
	private TableView<Funcionario> tbFuncionarios;
	@FXML
	public static ObservableList<Pedido> peList = FXCollections.observableArrayList();
	@FXML
	public static ObservableList<Produto> pList = FXCollections.observableArrayList();
	@FXML
	public static ObservableList<Estoque> eList = FXCollections.observableArrayList();
	@FXML
	public static ObservableList<Fornecedor> fList = FXCollections.observableArrayList();
	@FXML
	public static ObservableList<Cliente> cList = FXCollections.observableArrayList();
	@FXML
	public static ObservableList<Funcionario> fuList = FXCollections.observableArrayList();
	@FXML
	private MenuBar menuBar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		anchorPane.setStyle("-fx-background-image:url(\"/view/1.jpg\");");
		try {
			toolbarC = FXMLLoader.load(getClass().getResource("ClientBarra.fxml"));
			toolbarE = FXMLLoader.load(getClass().getResource("EstoqueBarra.fxml"));
			toolbarFu = FXMLLoader.load(getClass().getResource("FuncionarioBarra.fxml"));
			toolbarFor = FXMLLoader.load(getClass().getResource("FornecedorBarra.fxml"));
			toolbarPe = FXMLLoader.load(getClass().getResource("PedidoBarra.fxml"));
			toolbarPr = FXMLLoader.load(getClass().getResource("ProdutoBarra.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		drawerPr.setSidePane(toolbarPr);
		drawerPe.setSidePane(toolbarPe);
		drawerF.setSidePane(toolbarFor);
		drawerFu.setSidePane(toolbarFu);
		drawerE.setSidePane(toolbarE);
		drawerC.setSidePane(toolbarC);
		openToolbars();
		setFornecedores();
		setFuncionarios();
		setEstoque();
		setClientes();
		setPedidos();
		setCardapio();
		setDrawers();
		if (LoginFormController.login.getNivelAceso() == 1) {
			funcionarios.setText("");
			funcionarios.setDisable(true);
		}
	}

	private void setFornecedores() {
		idFornecedor.setCellValueFactory(new PropertyValueFactory<Fornecedor, Integer>("id"));
		cnpj.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("cnpj"));
		razaoSocial.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("razaoSocial"));
		nomeSocial.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("nomeSocial"));
		tel1.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("tel1"));
		tel2.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("tel2"));
		emailFornecedor.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("email"));
		TableLoader.loadFornecedores(fList);
		tbFornecedores.setItems(fList);
	}

	private void setFuncionarios() {
		id.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("id"));
		nome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
		cpf.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cpf"));
		nivelAcesso.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("nivelAcesso"));
		senha.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("senha"));
		TableLoader.loadFuncionarios(fuList);
		this.tbFuncionarios.setItems(fuList);
	}

	private void setEstoque() {
		idInsumo.setCellValueFactory(new PropertyValueFactory<Estoque, Integer>("idInsumo"));
		descricao.setCellValueFactory(new PropertyValueFactory<Estoque, String>("descricao"));
		precoInsumo.setCellValueFactory(new PropertyValueFactory<Estoque, Double>("precoInsumo"));
		unidadeMedida.setCellValueFactory(new PropertyValueFactory<Estoque, String>("unidadeMedida"));
		quantidadeDisp.setCellValueFactory(new PropertyValueFactory<Estoque, Integer>("quantidadeDisp"));
		fornecedor.setCellValueFactory(new PropertyValueFactory<Estoque, Integer>("fornecedor"));
		TableLoader.loadEstoque(eList);
		this.tbEstoque.setItems(eList);
	}

	private void setClientes() {
		idCliente.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("idCliente"));
		nomeCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nomeCliente"));
		celularCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("celular"));
		emailCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("emailCliente"));
		telefoneCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));
		dataNascCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("dataNascimento"));
		TableLoader.loadClientes(cList);
		this.tbCliente.setItems(cList);
	}

	private void setPedidos() {
		codigoPedido.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("id"));
		idCPedido.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("cliente"));
		idProduto.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("produtos"));
		idFuPedido.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("funcionario"));
		tamPedido.setCellValueFactory(new PropertyValueFactory<Pedido, String>("tamanho"));
		qtdPedido.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("quantidade"));
		formaPag.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("pagamento"));
		dataPedido.setCellValueFactory(new PropertyValueFactory<Pedido, String>("data"));
		anotacaoPe.setCellValueFactory(new PropertyValueFactory<Pedido, String>("anotacao"));
		trocoPe.setCellValueFactory(new PropertyValueFactory<Pedido, Double>("troco"));
		precoTotal.setCellValueFactory(new PropertyValueFactory<Pedido, Double>("precoTotal"));
		TableLoader.loadPedidos(peList);
		this.tbPedido.setItems(peList);
	}

	private void setCardapio() {
		codProduto.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("id"));
		nomeProduto.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
		preco.setCellValueFactory(new PropertyValueFactory<Produto, Float>("preco"));
		funcionarioProduto.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("funcionario"));
		TableLoader.loadCardapio(pList);
		this.tbCardapio.setItems(pList);
	}

	@FXML
	private void fornecedorEdit() {
		Fornecedor f1 = tbFornecedores.getSelectionModel().getSelectedItem();
		if (f1.equals(null)) {
			JOptionPane.showMessageDialog(null, "Item não selecionado!\nSelecione um item para a edição", "", 2);
			return;
		}
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AdicionarFornecedor.fxml"));
			Pane root = loader.load();
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.setScene(new Scene(root));
			stage.show();

			stage.setOnCloseRequest((e) -> {
				fList.clear();
				setFornecedores();
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void funcionarioEdit() {
		Funcionario f1 = tbFuncionarios.getSelectionModel().getSelectedItem();
		if (f1.equals(null)) {
			JOptionPane.showMessageDialog(null, "Item não selecionado!\nSelecione um item para a edição", "", 2);
			return;
		}
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AdicionarFuncionario.fxml"));
			Pane root = loader.load();
			AdicionarFuncionarioController controller = (AdicionarFuncionarioController) loader.getController();
			controller.infalteUI(f1);
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.setScene(new Scene(root));
			stage.show();

			stage.setOnCloseRequest((e) -> {
				fList.clear();
				setFornecedores();
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void openToolbars() {
		drawerC.open();
		drawerE.open();
		drawerFu.open();
		drawerF.open();
		drawerPe.open();
		drawerPr.open();
	}

	private void setDrawers() {
		HamburgerBackArrowBasicTransition t1 = new HamburgerBackArrowBasicTransition(hamCliente);
		t1.setRate(-1);
		hamCliente.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			t1.setRate(t1.getRate() * -1);
			t1.play();

			if (drawerC.isOpened()) {
				drawerC.close();
			} else {
				drawerC.open();
			}
		});
		HamburgerBackArrowBasicTransition t2 = new HamburgerBackArrowBasicTransition(hamEstoque);
		t2.setRate(-1);
		hamEstoque.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			t2.setRate(t2.getRate() * -1);
			t2.play();

			if (drawerE.isOpened()) {
				drawerE.close();
			} else {
				drawerE.open();
			}
		});

		HamburgerBackArrowBasicTransition t3 = new HamburgerBackArrowBasicTransition(hamFuncionario);
		t3.setRate(-1);
		hamFuncionario.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			t3.setRate(t3.getRate() * -1);
			t3.play();

			if (drawerFu.isOpened()) {
				drawerFu.close();
			} else {
				drawerFu.open();
			}
		});
		HamburgerBackArrowBasicTransition t4 = new HamburgerBackArrowBasicTransition(hamProduto);
		t4.setRate(-1);
		hamProduto.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			t4.setRate(t4.getRate() * -1);
			t4.play();

			if (drawerPr.isOpened()) {
				drawerPr.close();
			} else {
				drawerPr.open();
			}
		});

		HamburgerBackArrowBasicTransition t5 = new HamburgerBackArrowBasicTransition(hamPedido);
		t5.setRate(-1);
		hamPedido.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			t5.setRate(t5.getRate() * -1);
			t5.play();

			if (drawerPe.isOpened()) {
				drawerPe.close();
			} else {
				drawerPe.open();
			}
		});
		HamburgerBackArrowBasicTransition t6 = new HamburgerBackArrowBasicTransition(hamFornecedor);
		t6.setRate(-1);
		hamFornecedor.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			t6.setRate(t6.getRate() * -1);
			t6.play();

			if (drawerF.isOpened()) {
				drawerF.close();
			} else {
				drawerF.open();
			}
		});
	}

	public void closeWindow(ActionEvent e) {
		Platform.exit();
		System.exit(0);
	}
}
