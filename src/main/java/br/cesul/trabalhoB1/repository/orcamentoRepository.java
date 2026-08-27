package br.cesul.trabalhoB1.repository;

import br.cesul.trabalhoB1.config.MongoConfig;
import br.cesul.trabalhoB1.model.Despesa;
import com.mongodb.client.MongoCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static com.mongodb.client.model.Sorts.descending;

public class orcamentoRepository {
    private final MongoCollection<Despesa> col = MongoConfig.db.getCollection("painelviagem", Despesa.class);



    public void salvar (Despesa d) {
        col.insertOne(d);
    }



    public void excluir (Despesa d) {
        col.deleteOne(org.bson.Document.parse("{_id: ObjectID('" + d.getId() + "')}"));
    }

    public ObservableList<Despesa> findAll() {
        var list = FXCollections.<Despesa> observableArrayList();
        col.find().sort(descending("valor")).forEach(list::add);
        return list;
    }
}
