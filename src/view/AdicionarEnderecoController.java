package view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Endereco;
import model.Fornecedor;
import model.Funcionario;
import model.TableLoader;

public class AdicionarEnderecoController implements Initializable {
	private Funcionario f1 = new Funcionario();
	@FXML
	private JFXTextField tfRua;

	@FXML
	private JFXButton btSalvar;

	@FXML
	private JFXButton btCancelar;

	@FXML
	private JFXTextField tfCep;

	@FXML
	private JFXTextField tfNum;

	@FXML
	private JFXTextField tfBairro;

	@FXML
	private JFXTextField tfComplemento;

	@FXML
	private Label lblCodigoEndereco;
	@FXML
	private JFXComboBox<Integer> cbCliente;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbCliente.setItems(TableLoader.getIdClientes());
		setActions();
	}

	private void setActions() {

		btSalvar.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			Endereco e1 = new Endereco(tfRua.getText(), Integer.parseInt(tfNum.getText()), tfBairro.getText(),
					tfCep.getText(), tfComplemento.getText(), cbCliente.getSelectionModel().getSelectedItem());
			System.out.println(f1.gerenciarEnderecos(e1, 3, cbCliente.getSelectionModel().getSelectedItem()));
			MainFormController.fList.clear();
			TableLoader.loadFornecedores(MainFormController.fList);

		});
		btCancelar.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->

		{
			Stage stage = (Stage) cbCliente.getScene().getWindow();
			stage.close();
		});
	}

	public JFXTextField getTfRua() {
		return tfRua;
	}

	public void setTfRua(JFXTextField tfRua) {
		this.tfRua = tfRua;
	}

	public JFXTextField getTfCep() {
		return tfCep;
	}

	public void setTfCep(JFXTextField tfCep) {
		this.tfCep = tfCep;
	}

	public JFXTextField getTfNum() {
		return tfNum;
	}

	public void setTfNum(JFXTextField tfNum) {
		this.tfNum = tfNum;
	}

	public JFXTextField getTfBairro() {
		return tfBairro;
	}

	public void setTfBairro(JFXTextField tfBairro) {
		this.tfBairro = tfBairro;
	}

	public JFXTextField getTfComplemento() {
		return tfComplemento;
	}

	public void setTfComplemento(JFXTextField tfComplemento) {
		this.tfComplemento = tfComplemento;
	}

	public Label getLblCodigoEndereco() {
		return lblCodigoEndereco;
	}

	public void setLblCodigoEndereco(Label lblCodigoEndereco) {
		this.lblCodigoEndereco = lblCodigoEndereco;
	}

	public JFXComboBox<Integer> getCbCliente() {
		return cbCliente;
	}

	public void setCbCliente(JFXComboBox<Integer> cbCliente) {
		this.cbCliente = cbCliente;
	}

}
