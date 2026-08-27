package br.cesul.trabalhoB1.viewmodel;

import br.cesul.trabalhoB1.model.Despesa;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

    public class OrcamentoViewModel {
        private final StringProperty descricao = new SimpleStringProperty();
        private final DoubleProperty valor = new SimpleDoubleProperty();

        private final ObservableList<Despesa> despesas = FXCollections.observableArrayList();







}
