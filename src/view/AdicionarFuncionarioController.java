package view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Funcionario;

public class AdicionarFuncionarioController implements Initializable {

	@FXML
	private JFXTextField tfNome;

	@FXML
	private JFXComboBox<Integer> cbNivelAcesso = new JFXComboBox<>();

	@FXML
	private JFXButton btSalvar;

	@FXML
	private JFXButton btCancelar;

	@FXML
	private JFXTextField tfSenha;

	@FXML
	private JFXTextField tfCPF;

	@FXML
	private Label lbIndicador;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Integer> niveis = FXCollections.observableArrayList(1, 2);
		cbNivelAcesso.setItems(niveis);
		lbIndicador.setVisible(false);
	}

	public void infalteUI(Funcionario f) {
		tfNome.setText(f.getNome());
		tfCPF.setText(f.getCpf());
		tfSenha.setText(f.getSenha());
	}

}
