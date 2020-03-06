package controller;

import java.net.URL;
//import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Login;
import model.Usuario;

public class LoginFormController extends Application implements Initializable {
	public static Login login = new Login();
	@FXML
	private JFXTextField tfCPF = new JFXTextField();
	@FXML
	private JFXPasswordField pfSenha = new JFXPasswordField();
	@FXML
	private JFXButton btLogin;
	@FXML
	private Label lbStatus;
	@FXML
	private StackPane rootPane;

	@FXML
	public void login(ActionEvent e) {
		try {
			if (login.isLogin(tfCPF.getText(), pfSenha.getText())) {
				((Node) e.getSource()).getScene().getWindow().hide();
				loadMainForm();
				System.out.println(login.getNivelAceso());
			} else {
				JFXDialogLayout dialogLayout = new JFXDialogLayout();
				JFXButton button = new JFXButton("Ok");
				JFXDialog dialog = new JFXDialog(rootPane, dialogLayout, JFXDialog.DialogTransition.TOP);
				button.addEventHandler(MouseEvent.MOUSE_CLICKED, e1 -> {
					dialog.close();
				});
				dialogLayout.setHeading(new Label("Credenciais inválidas!"));
				dialogLayout.setActions(button);
				dialog.show();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/LoginForm.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Pizzeria");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lbStatus.setVisible(false);
		tfCPF.setTooltip(new Tooltip("Insira seu CPF juntamente dos pontos e traço"));
		pfSenha.setTooltip(new Tooltip("Informe sua senha de login"));
	}

	private void loadMainForm() {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(getClass().getResource("/view/MainForm.fxml").openStream());
			Scene scene = new Scene(root, 700, 700);
			scene.getStylesheets().add(getClass().getResource("/view/pizza.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Pizzeria");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario getUser() {

		return login.setUserValues(tfCPF.getText());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
