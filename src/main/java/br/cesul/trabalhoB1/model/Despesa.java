package br.cesul.trabalhoB1.model;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public class Despesa {
    private double valor;
    private String descricao;
    private ObjectId id;
    private LocalDate data;


    public Despesa() {}

    public Despesa(String descricao, double valor, LocalDate data) {

        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }

    public LocalDate getData() { return data; }

    public void setData(LocalDate data) {}

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDescricao(String descricao) {this.descricao = descricao;
    }
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

}



