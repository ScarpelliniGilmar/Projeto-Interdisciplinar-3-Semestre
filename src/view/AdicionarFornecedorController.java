package view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Admin;
import model.Fornecedor;
import model.TableLoader;

public class AdicionarFornecedorController implements Initializable {
	private Admin a1 = new Admin();

	@FXML
	private JFXTextField tfRazaoS = new JFXTextField();

	@FXML
	private JFXButton btSalvar = new JFXButton();

	@FXML
	private JFXButton btCancelar = new JFXButton();

	@FXML
	private JFXTextField tfEmail = new JFXTextField();

	@FXML
	private JFXTextField tfNomeS = new JFXTextField();

	@FXML
	private JFXTextField tfCNPJ = new JFXTextField();

	@FXML
	private JFXTextField tfTel1 = new JFXTextField();

	@FXML
	private JFXTextField tfTel2 = new JFXTextField();
	@FXML
	private StackPane mainContainer;

	@FXML
	private Label lblCodigo;
	private String razaoS;
	private String nomeS;
	private String cnpj;
	private String tel1;
	private String tel2;
	private String email;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setActions();
	}

	private void setActions() {

		btSalvar.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			Boolean flag = tfRazaoS.getText().equals(null) || tfNomeS.getText().equals(null)
					|| tfCNPJ.getText().equals(null) || tfTel1.getText().equals(null);
			if (flag) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Complete todos os campos com asterisco (*)");
				alert.showAndWait();
				return;
			} else {
				this.razaoS = tfRazaoS.getText();
				this.nomeS = tfNomeS.getText();
				this.cnpj = tfCNPJ.getText();
				this.tel1 = tfTel1.getText();
				this.tel2 = tfTel2.getText();
				this.email = tfEmail.getText();
				JFXDialogLayout dialogLayout = new JFXDialogLayout();
				JFXButton button = new JFXButton("Ok");
				JFXDialog dialog = new JFXDialog(mainContainer, dialogLayout, JFXDialog.DialogTransition.TOP);
				button.addEventHandler(MouseEvent.MOUSE_CLICKED, e1 -> {
					dialog.close();
				});
				if (lblCodigo.getText().equals(null)) {
					Fornecedor f1 = new Fornecedor(cnpj, nomeS, razaoS, tel1, tel2, email);
					dialogLayout.setHeading(new Label(a1.gerenciarFornecedor(f1, 3)));
				} else {
					Fornecedor f1 = new Fornecedor(Integer.parseInt(lblCodigo.getText()), cnpj, nomeS, razaoS, tel1,
							tel2, email);
					dialogLayout.setHeading(new Label(a1.gerenciarFornecedor(f1, 4)));
				}
				dialogLayout.setActions(button);
				dialog.show();
				MainFormController.fList.clear();
				TableLoader.loadFornecedores(MainFormController.fList);
			}
		});
		btCancelar.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			Stage stage = (Stage) tfCNPJ.getScene().getWindow();
			stage.close();
		});
	}

	public JFXTextField getTfRazaoS() {
		return tfRazaoS;
	}

	public JFXTextField getTfEmail() {
		return tfEmail;
	}

	public JFXTextField getTfNomeS() {
		return tfNomeS;
	}

	public JFXTextField getTfCNPJ() {
		return tfCNPJ;
	}

	public JFXTextField getTfTel1() {
		return tfTel1;
	}

	public JFXTextField getTfTel2() {
		return tfTel2;
	}

	public Label getLblCodigo() {
		return lblCodigo;
	}
}
