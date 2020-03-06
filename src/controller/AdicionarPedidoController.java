package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.*;
import javafx.scene.control.Label;
import model.Produto;

public class AdicionarPedidoController implements Initializable {
	@FXML
	private JFXTextField tfcpfCliente, tfTroco;
	@FXML
	private JFXComboBox<String> cbformaPagamento;
	@FXML
	private JFXComboBox<Produto> cbitensCardapio = new JFXComboBox<>();
	@FXML
	private Label lbQuantidade, lbPrecoTotal;
	@FXML
	private JFXButton btMais, btMenos, btAdd, btSalvar, btCancelar;
	@FXML
	private JFXComboBox<String> cbTamanho;
	@FXML
	private JFXTextArea taAnotacao;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
