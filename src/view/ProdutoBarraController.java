package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

public class ProdutoBarraController implements Initializable {
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

		});
		btExcluir.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {

		});
	}

	private void openAddPopUp() {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/view/AdicionarProduto.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/view/pizza.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Adicionar Insumo");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
