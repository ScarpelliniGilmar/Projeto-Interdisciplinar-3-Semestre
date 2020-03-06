package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.TableLoader;

public class ClientBarraController implements Initializable {
	@FXML
	private JFXButton btAdicionar;

	@FXML
	private JFXButton btAlterar;

	@FXML
	private JFXButton btExcluir;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadActions();
	}

	// Event Listener on JFXButton[#btAdicionar].onAction
	private void loadActions() {
		btAdicionar.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			openAddPopUp();
		});
		btAlterar.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			openAlterPopUp();
		});
		btExcluir.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			openDeletePopUp();
		});
	}

	private void openAddPopUp() {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/view/AdicionarCliente.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/view/pizza.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Adicionar cliente");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void openAlterPopUp() {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			StackPane root = loader.load(getClass().getResource("/view/AdicionarCliente.fxml").openStream());
			AdicionarClienteController clienteController = (AdicionarClienteController) loader.getController();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/view/pizza.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Alterar cliente");
			primaryStage.setResizable(false);
			primaryStage.show();
			JFXComboBox<Integer> cbId = new JFXComboBox<>();
			cbId.setItems(TableLoader.getClienteId());
			JFXDialogLayout dialogLayout = new JFXDialogLayout();
			JFXButton button = new JFXButton("Ok");
			JFXDialog dialog = new JFXDialog(root, dialogLayout, JFXDialog.DialogTransition.TOP);
			button.addEventHandler(MouseEvent.MOUSE_CLICKED, e1 -> {
				TableLoader.setClienteFields(cbId.getSelectionModel().getSelectedItem(), clienteController.getTfNome(),
						clienteController.getTfTelefone(), clienteController.getTfCelular(),
						clienteController.getTfEmail(), clienteController.getDpData(),
						clienteController.getCbEndereco(), clienteController.getLblCodigoCliente());
				dialog.close();
			});
			dialogLayout.setHeading(new Label("Selecione o código do cliente"));
			dialogLayout.setBody(cbId);
			dialogLayout.setActions(button);
			dialog.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void openDeletePopUp() {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			StackPane root = loader.load(getClass().getResource("/view/AdicionarPedido.fxml").openStream());
			AdicionarPedidosController blankController = (AdicionarPedidosController) loader.getController();
			Scene scene = new Scene(root, 300, 150);
			scene.getStylesheets().add(getClass().getResource("/view/pizza.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Excluir cliente");
			primaryStage.setResizable(false);
			primaryStage.show();
			JFXComboBox<Integer> cbId = new JFXComboBox<>();
			cbId.setPromptText("Selecione o código do cliente");
			cbId.setItems(TableLoader.getFornecedorIds());
			JFXDialogLayout dialogLayout = new JFXDialogLayout();
			JFXButton button = new JFXButton("Ok");
			JFXDialog dialog = new JFXDialog(root, dialogLayout, JFXDialog.DialogTransition.TOP);
			button.addEventHandler(MouseEvent.MOUSE_CLICKED, e1 -> {//
				MainFormController.cList.remove(cbId.getSelectionModel().getSelectedIndex());
				dialog.close();
				Stage stage = (Stage) blankController.getCbCardapio().getScene().getWindow();
				stage.close();
			});
			dialogLayout.setHeading(new Label("Excluir cliente"));
			dialogLayout.setBody(cbId);
			dialogLayout.setActions(button);
			dialog.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
