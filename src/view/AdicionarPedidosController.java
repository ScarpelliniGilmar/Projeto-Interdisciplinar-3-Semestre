package view;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import controller.LoginFormController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Funcionario;
import model.Pedido;
import model.TableLoader;

public class AdicionarPedidosController implements Initializable {
	private Funcionario f1 = new Funcionario();

	@FXML
	private JFXComboBox<Integer> cbPagamento = new JFXComboBox<>();

	@FXML
	private JFXComboBox<String> cbCardapio;

	@FXML
	private Label lbQuantidade = new Label();

	@FXML
	private JFXButton btMais = new JFXButton();

	@FXML
	private JFXButton btMenos = new JFXButton();

	@FXML
	private JFXComboBox<String> cbTamanho;

	@FXML
	private JFXTextArea taAnotacao;

	@FXML
	private JFXButton btSalvar;

	@FXML
	private JFXButton btCancelar;
	@FXML
	private JFXTextField tfTroco;
	@FXML
	private Label lbTotal = new Label();
	@FXML
	private JFXComboBox<Integer> cbCliente;
	@FXML
	private Label lblCodigoPedido;
//	Integer cliente, String produto, Integer funcionario, String tamanho, Integer quantidade,
//	Integer pagamento, String data, String anotacao, Double troco, Double total
	@FXML
	private StackPane mainContainer;
	private Integer[] pagamento = { 1, 2, 3 };
	private Integer quantidade = 0;
	private String[] tamanho = { "Pequeno", "Médio", "Grande" };
	private String anotacao;
	private Double troco;
	private Double total;
	private LocalDateTime date = LocalDateTime.now();
	private Integer cliente;
	private String produto;
	private Integer funcionario;
	private String tamanhoPedido;
	private Integer pagamentoPedido;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> tamanhos = FXCollections.observableArrayList();
		tamanhos.addAll(tamanho);
		ObservableList<Integer> pagamentos = FXCollections.observableArrayList();
		pagamentos.addAll(pagamento);
		cbCardapio.setItems(TableLoader.getProdutoNomes());
		cbCliente.setItems(TableLoader.getClienteId());
		cbTamanho.setItems(tamanhos);
		cbPagamento.setItems(pagamentos);
		cbPagamento.setTooltip(new Tooltip("1 - Dinheiro\n2 - Cartão\n3 - Cheque"));
		try {
			troco = Double.parseDouble(tfTroco.getText());
			lbTotal.setText(total.toString());
		} catch (NumberFormatException e) {
			tfTroco.setText("Insira apenas números !");
		}

		setActions();

	}

	private void setActions() {
		btMais.setOnAction(e -> {
			quantidade++;
			lbQuantidade.setText(quantidade.toString());
		});

		btMenos.setOnAction(e -> {
			if (!checkQuantidade(quantidade)) {
				quantidade = 0;
				throw new IllegalArgumentException("Não é possível ter quantidade negativa");
			} else {
				quantidade--;
				lbQuantidade.setText(quantidade.toString());
			}

		});

		btSalvar.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			this.cliente = cbCliente.getSelectionModel().getSelectedItem();
			this.produto = cbCardapio.getSelectionModel().getSelectedItem();
			this.funcionario = LoginFormController.login.getId();
			this.tamanhoPedido = cbTamanho.getSelectionModel().getSelectedItem();
			this.quantidade = Integer.parseInt(lbQuantidade.getText());
			this.pagamentoPedido = cbPagamento.getSelectionModel().getSelectedItem();
			this.anotacao = taAnotacao.getText();
			this.troco = Double.parseDouble(tfTroco.getText());
			this.total = quantidade * TableLoader.getProdutoPreco(produto);

			JFXDialogLayout dialogLayout = new JFXDialogLayout();
			JFXButton button = new JFXButton("Ok");
			JFXDialog dialog = new JFXDialog(mainContainer, dialogLayout, JFXDialog.DialogTransition.TOP);
			button.addEventHandler(MouseEvent.MOUSE_CLICKED, e1 -> {
				dialog.close();
			});
			try {
				if (!lblCodigoPedido.getText().equals(null)) {
					Pedido p2 = new Pedido(Integer.parseInt(lblCodigoPedido.getText()), cliente, produto, funcionario,
							tamanhoPedido, quantidade, pagamentoPedido, date.toString(), anotacao, total, troco);
					dialogLayout.setHeading(new Label(f1.gerenciarPedido(p2, 4)));
				} else {
					Pedido pedido = new Pedido(cliente, produto, funcionario, tamanhoPedido, quantidade,
							pagamentoPedido, date.toString(), anotacao, total, troco);
					dialogLayout.setHeading(new Label(f1.gerenciarPedido(pedido, 3)));
				}
			} catch (NullPointerException e1) {
				System.out.println(e1.toString());
			}

			dialogLayout.setActions(button);
			dialog.show();
			MainFormController.peList.clear();
			TableLoader.loadPedidos(MainFormController.peList);

			Stage stage = (Stage) cbCardapio.getScene().getWindow();
			stage.close();
		});
		btCancelar.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			Stage stage = (Stage) cbCardapio.getScene().getWindow();
			stage.close();
		});

	}

	public JFXComboBox<Integer> getCbPagamento() {
		return this.cbPagamento;
	}

	public JFXComboBox<String> getCbCardapio() {
		return this.cbCardapio;
	}

	public Label getLblQuantidade() {
		return this.lbQuantidade;
	}

	public JFXComboBox<String> getCbTamanho() {
		return this.cbTamanho;
	}

	public JFXTextArea getTaAnotacao() {
		return this.taAnotacao;
	}

	public JFXTextField getTfTroco() {
		return this.tfTroco;
	}

	public Label getLblTotal() {
		return this.lbTotal;
	}

	public JFXComboBox<Integer> getCbCliente() {
		return this.cbCliente;
	}

	public Label getLblCodigoPedido() {
		return this.lblCodigoPedido;
	}

	public Integer getIdPedido() {
		return Integer.parseInt(this.lblCodigoPedido.getText());
	}

	private boolean checkQuantidade(Integer quantidade) {
		return quantidade > 0;
	}

}
