package br.cesul.trabalhoB1.view;

import br.cesul.trabalhoB1.model.Despesa;
import br.cesul.trabalhoB1.viewmodel.OrcamentoViewModel;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.NumberStringConverter;

import java.time.LocalDate;

public class OrcamentoView {
    @FXML private TextField descField;
    @FXML private TextField valorField;
    @FXML private DatePicker datePicker;
    @FXML private Button addButton;
    @FXML private Button deleteButton;
    @FXML private Label totalLbl;
    @FXML private TableColumn<Despesa, LocalDate> dataColumn;
    @FXML private TableView<Despesa>  orcamentoTable;
    @FXML private TableColumn<Despesa, String> descCol;
    @FXML private TableColumn<Despesa, Number> valorCol;


    private final OrcamentoViewModel vm = new OrcamentoViewModel();

    @FXML
    private void initialize() {
        descField.textProperty().bindBidirectional(vm.descriptionProperty());

        TextFormatter<Number> amountFormatter = new TextFormatter<>(new NumberStringConverter());
        valorField.setTextFormatter(amountFormatter);
        Bindings.bindBidirectional(vm.valorProperty(), amountFormatter.valueProperty());

        datePicker.valueProperty().bindBidirectional(vm.dateProperty());

        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        valorCol.setCellValueFactory(new PropertyValueFactory<>("valor"));

        orcamentoTable.setItems(vm.getDespesas());

        totalLbl.textProperty().bind(vm.totalProperty().asString("TOTAL DO MÊS R$ %.2f"));

        addButton.setOnAction(e -> vm.addDespesa());
        deleteButton.setOnAction(e -> vm.deleteSelected(orcamentoTable.getSelectionModel().getSelectedItem()));
    }
}

