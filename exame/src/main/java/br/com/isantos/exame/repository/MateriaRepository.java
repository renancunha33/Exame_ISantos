package br.com.isantos.exame.repository;

import br.com.isantos.exame.domain.Materia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Felipe Martins
 */

//classe de acesso e manipulaçao de dados
public class MateriaRepository {
    //conexao com o banco
    private final Connection conn;

    public MateriaRepository(Connection conn) {
        this.conn = conn;
    }
    //salvar nova materia
    public void save(Materia materia) throws SQLException {
        String comando = "INSERT INTO materia (nome) VALUES (?)";

        try (PreparedStatement ps = conn.prepareStatement(comando)) {
            ps.setString(1, materia.getNome());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }
    }
    //listar todas as materias
    public List<Materia> findAll() throws SQLException {

        List<Materia> materias = new ArrayList<>();
        Materia materia;

        try (ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM materia")) {
            while (resultSet.next()) {
                materia = new Materia();
                materia.setId(resultSet.getInt("codigo"));
                materia.setNome(resultSet.getString("nome"));

                materias.add(materia);
            }
        }

        return materias;
    }
    //deletar materia
    public void delete(Materia materia) throws SQLException {
        String comando = "DELETE FROM materia WHERE codigo = (?)";

        try (PreparedStatement ps = conn.prepareStatement(comando)) {
            ps.setString(1, materia.getId().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        }
    }
    //atualizar materia
    public void update(Materia materia) throws SQLException {
        String comando = "UPDATE materia SET nome = (?) WHERE codigo = (?)";

        try (PreparedStatement ps = conn.prepareStatement(comando)) {
            ps.setString(1, materia.getNome());
            ps.setString(2, materia.getId().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        }
    }
}
