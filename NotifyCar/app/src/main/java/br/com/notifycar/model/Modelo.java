package br.com.notifycar.model;

import java.io.Serializable;

/**
 * Created by Desenvolvimento on 10/10/2016.
 */
public class Modelo implements Serializable {

    private String _id;
    private String nome;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return nome;
    }
}
