package br.cesul.trabalhoB1.viewmodel;

import br.cesul.trabalhoB1.model.Despesa;
import br.cesul.trabalhoB1.repository.OrcamentoRepository;
import javafx.application.Platform;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class OrcamentoViewModel {
        private final StringProperty descricao = new SimpleStringProperty();
        private final DoubleProperty valor = new SimpleDoubleProperty();
        private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>(LocalDate.now());

        private final ObservableList<Despesa> despesas = FXCollections.observableArrayList();

        private final DoubleBinding total = new DoubleBinding() {
            {bind(despesas); }

            protected double computeValue(){
                    return despesas.stream().mapToDouble(Despesa::getValor).sum();
            }
        };

        private final OrcamentoRepository repository = new OrcamentoRepository();

        public OrcamentoViewModel() {
            despesas.addAll(repository.findAll());

            despesas.addListener((ListChangeListener<? super Despesa>) change ->{
                while(change.next()){
                    if(change.wasAdded()){
                        change.getAddedSubList().forEach(repository::salvar);
                    }
                    if(change.wasRemoved()){
                        change.getRemoved().forEach(repository::excluir);
                    }
                }
            });
        }

        public void addDespesa() {
            if (descricao.get() == null|| descricao.get().isBlank()){
                return;
            }

            Despesa desp = new Despesa(descricao.get(), valor.get(), date.get());
            despesas.add(0, desp);
            clearInputs();
        }

        public void clearInputs() {
                descricao.set("");
                valor.set(0);
                date.set(LocalDate.now());

        }

        public void deleteSelected(Despesa d) {
            if (d != null) despesas.remove(d);
        }

        public StringProperty descriptionProperty() {return descricao;}
        public DoubleProperty valorProperty() {return valor;}
        public ObjectProperty<LocalDate>dateProperty() {return date;}
        public DoubleBinding totalProperty() {return total;}
        public ObservableList<Despesa> getDespesas() {return despesas;}
}
