package br.cesul.trabalhoB1.view;

import br.cesul.trabalhoB1.model.Despesa;
import br.cesul.trabalhoB1.viewmodel.OrcamentoViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class OrcamentoView {
    @FXML private TextField descField;
    @FXML private TextField valorField;
    @FXML private DatePicker datePicker;
    @FXML private Button addButton;
    @FXML private Button editButton;
    @FXML private Button deleteButton;
    @FXML private Label totalLbl;
    @FXML private TableColumn<Despesa, LocalDate> dataColumn;
    @FXML private TableView<Despesa>  orcamentoTable;
    @FXML private TableColumn<Despesa, String> descCol;
    @FXML private TableColumn<Despesa, String> valorCol;

    private final OrcamentoViewModel vm = new OrcamentoViewModel();

    @FXML
    private void initialize() {

    }
}

