package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.TableLoader;

public class FornecedorBarraController implements Initializable {
	@FXML
	private StackPane master;
	@FXML
	private AnchorPane root;
	@FXML
	private JFXButton btAddForn;
	@FXML
	private JFXButton btAlterForn;
	@FXML
	private JFXButton btDelForn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadActions();

	}

	// Event Listener on JFXButton[#btAdicionar].onAction
	private void loadActions() {
		btAddForn.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			openAddPopUp();
		});
		btAlterForn.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			openAlterPopUp();
		});
		btDelForn.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			openDeletePopUp();
		});
	}

	private void openAddPopUp() {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/view/AdicionarFornecedor.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/view/pizza.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Adicionar Fornecedor");
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
			StackPane root = loader.load(getClass().getResource("/view/AdicionarFornecedor.fxml").openStream());
			AdicionarFornecedorController fornecedorController = (AdicionarFornecedorController) loader.getController();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/view/pizza.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Alterar fornecedor");
			primaryStage.setResizable(false);
			primaryStage.show();
			JFXComboBox<Integer> cbId = new JFXComboBox<>();
			cbId.setItems(TableLoader.getFornecedorIds());
			JFXDialogLayout dialogLayout = new JFXDialogLayout();
			JFXButton button = new JFXButton("Ok");
			JFXDialog dialog = new JFXDialog(root, dialogLayout, JFXDialog.DialogTransition.TOP);
			button.addEventHandler(MouseEvent.MOUSE_CLICKED, e1 -> {
				TableLoader.fornecedorFields(cbId.getSelectionModel().getSelectedItem(),
						fornecedorController.getTfRazaoS(), fornecedorController.getTfNomeS(),
						fornecedorController.getTfCNPJ(), fornecedorController.getTfTel1(),
						fornecedorController.getTfTel2(), fornecedorController.getTfEmail(),
						fornecedorController.getLblCodigo());
				dialog.close();
			});
			dialogLayout.setHeading(new Label("Selecione o código do pedido"));
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
			primaryStage.setTitle("Excluir fornecedor");
			primaryStage.setResizable(false);
			primaryStage.show();
			JFXComboBox<Integer> cbId = new JFXComboBox<>();
			cbId.setPromptText("Selecione o código do fornecedor");
			cbId.setItems(TableLoader.getFornecedorIds());
			JFXDialogLayout dialogLayout = new JFXDialogLayout();
			JFXButton button = new JFXButton("Ok");
			JFXDialog dialog = new JFXDialog(root, dialogLayout, JFXDialog.DialogTransition.TOP);
			button.addEventHandler(MouseEvent.MOUSE_CLICKED, e1 -> {//
				MainFormController.fList.remove(cbId.getSelectionModel().getSelectedIndex());
				dialog.close();
				Stage stage = (Stage) blankController.getCbCardapio().getScene().getWindow();
				stage.close();
			});
			dialogLayout.setHeading(new Label("Excluir fornecedor"));
			dialogLayout.setBody(cbId);
			dialogLayout.setActions(button);
			dialog.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
