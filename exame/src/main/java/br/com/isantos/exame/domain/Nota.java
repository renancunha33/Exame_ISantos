package br.com.isantos.exame.domain;

/**
 * Created by felipe on 14/06/16.
 */

//classe do objeto Nota
public class Nota {

    //atributos
    private Aluno aluno;
    private Materia materia;
    private Integer nota;

    //getters e setters
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
