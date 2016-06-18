package br.com.isantos.exame.repository;

import br.com.isantos.exame.domain.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Created by felipe on 14/06/16.
 */

//classe de acesso e manipulaçao de dados
public class AlunoRepository {
    //conexao com o banco
    private final Connection conn;

    public AlunoRepository(Connection conn) {

        this.conn = conn;
    }
    //salvar novo aluno
    public void save(Aluno aluno) throws SQLException {
        String comando = "INSERT INTO aluno (nome) VALUES (?)";

        try (PreparedStatement ps = conn.prepareStatement(comando)) {
            ps.setString(1, aluno.getNome());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }
    }
    //listar todos os alunos
    public List<Aluno> findAll() throws SQLException {

        List<Aluno> alunos = new ArrayList<>();
        Aluno aluno;

        try (ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM aluno")) {
            while (resultSet.next()) {
                aluno = new Aluno();
                aluno.setId(resultSet.getInt("codigo"));
                aluno.setNome(resultSet.getString("nome"));

                alunos.add(aluno);
            }
        }

        return alunos;
    }
    //deletar aluno
    public void delete(Aluno aluno) throws SQLException {
      String comando = "DELETE FROM aluno WHERE codigo = (?)";
 
        try (PreparedStatement ps = conn.prepareStatement(comando)) {
            ps.setString(1, aluno.getId().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        }
    }
    
    //atualizar aluno
    public void update(Aluno aluno) throws SQLException {
        String comando = "UPDATE aluno SET nome = (?) WHERE codigo = (?)";

        try (PreparedStatement ps = conn.prepareStatement(comando)) {
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getId().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        }
    }
}
