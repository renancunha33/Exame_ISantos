package br.com.isantos.exame.domain;

import java.io.Serializable;

/**
 * Created by felipe on 14/06/16.
 */

//classe do objeto Aluno
public class Aluno implements Serializable {
    
    //atributos
    private Integer id;
    private String nome;
    
    //getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
