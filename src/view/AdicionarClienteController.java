package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Cliente;
import model.Funcionario;
import model.TableLoader;

public class AdicionarClienteController implements Initializable {
	private Funcionario f1 = new Funcionario();
	@FXML
	private JFXTextField tfNome;

	@FXML
	private JFXButton btSalvar;

	@FXML
	private JFXButton btCancelar;

	@FXML
	private JFXTextField tfTelefone;

	@FXML
	private JFXTextField tfCelular;

	@FXML
	private JFXTextField tfEmail;

	@FXML
	private JFXDatePicker dpData;

	@FXML
	private JFXComboBox<Integer> cbEndereco;

	@FXML
	private JFXButton btAdicionarEndereco;

	@FXML
	private JFXButton btAlterarEndereco;

	@FXML
	private Label lblCodigoCliente;
	@FXML
	private StackPane root;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbEndereco.setItems(TableLoader.getEnderecos(tfEmail.getText()));
		setActions();
	}

	private void setActions() {
		btSalvar.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			JFXDialogLayout dialogLayout = new JFXDialogLayout();
			JFXButton button = new JFXButton("Ok");
			JFXDialog dialog = new JFXDialog(root, dialogLayout, JFXDialog.DialogTransition.TOP);
			button.addEventHandler(MouseEvent.MOUSE_CLICKED, e1 -> {
				dialog.close();
			});
			try {
				if (!lblCodigoCliente.getText().equals(null)) {
					Cliente c2 = new Cliente(Integer.parseInt(lblCodigoCliente.getText()), tfNome.getText(),
							tfCelular.getText(), tfEmail.getText(), tfTelefone.getText(), dpData.getValue().toString());
					dialogLayout.setHeading(new Label(f1.gerenciarCliente(c2, 4)));
				} else {
					Cliente c1 = new Cliente(tfNome.getText(), tfCelular.getText(), tfEmail.getText(),
							tfTelefone.getText(), dpData.getValue().toString());
					dialogLayout.setHeading(new Label(f1.gerenciarCliente(c1, 3)));
				}
			} catch (NullPointerException e1) {
				System.out.println(e1.toString());
			}

			dialogLayout.setActions(button);
			dialog.show();
			MainFormController.peList.clear();
			TableLoader.loadPedidos(MainFormController.peList);

			Stage stage = (Stage) tfCelular.getScene().getWindow();
			stage.close();
		});
		btCancelar.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			Stage stage = (Stage) tfCelular.getScene().getWindow();
			stage.close();
		});
		btAdicionarEndereco.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			try {
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("/view/AdicionarEndereco.fxml").openStream());
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/view/pizza.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.setTitle("Adicionar Endereco");
				primaryStage.setResizable(false);
				primaryStage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		btAlterarEndereco.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			try {
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("/view/AdicionarEndereco.fxml").openStream());
				AdicionarEnderecoController enderecoControle = (AdicionarEnderecoController) loader.getController();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/view/pizza.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.setTitle("Adicionar Endereco");
				primaryStage.setResizable(false);
				TableLoader.setEnderecoFields(cbEndereco.getSelectionModel().getSelectedItem(),
						enderecoControle.getTfRua(), enderecoControle.getTfCep(), enderecoControle.getTfNum(),
						enderecoControle.getTfBairro(), enderecoControle.getTfComplemento(),
						enderecoControle.getLblCodigoEndereco());
				primaryStage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}

	public JFXTextField getTfNome() {
		return tfNome;
	}

	public void setTfNome(JFXTextField tfNome) {
		this.tfNome = tfNome;
	}

	public JFXTextField getTfTelefone() {
		return tfTelefone;
	}

	public void setTfTelefone(JFXTextField tfTelefone) {
		this.tfTelefone = tfTelefone;
	}

	public JFXTextField getTfCelular() {
		return tfCelular;
	}

	public void setTfCelular(JFXTextField tfCelular) {
		this.tfCelular = tfCelular;
	}

	public JFXTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JFXTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JFXDatePicker getDpData() {
		return dpData;
	}

	public void setDpData(JFXDatePicker dpData) {
		this.dpData = dpData;
	}

	public JFXComboBox<Integer> getCbEndereco() {
		return cbEndereco;
	}

	public void setCbEndereco(JFXComboBox<Integer> cbEndereco) {
		this.cbEndereco = cbEndereco;
	}

	public Label getLblCodigoCliente() {
		return lblCodigoCliente;
	}

	public void setLblCodigoCliente(Label lblCodigoCliente) {
		this.lblCodigoCliente = lblCodigoCliente;
	}

}
