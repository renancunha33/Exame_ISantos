package br.com.isantos.exame.repository;

import br.com.isantos.exame.domain.Aluno;
import br.com.isantos.exame.domain.Materia;
import br.com.isantos.exame.domain.Nota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author felipe
 */

//classe de acesso e manipulaçao de dados
public class NotaRepository {

    private final Connection conn;

    public NotaRepository(Connection conn) {
        this.conn = conn;
    }
    // salvar nova nota
    public void save(Nota nota) throws SQLException {
        //recebe objeto nota e insere no banco
        String comando = "INSERT INTO notas (aluno, materia, nota) VALUES(?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(comando)) {
            ps.setInt(1, nota.getAluno().getId());
            ps.setInt(2, nota.getMateria().getId());
            ps.setInt(3, nota.getNota());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }
    }
    //listar notas
    public List<Nota> findAllByAlunoAndMateria(Integer codigoAluno, Integer codigoMateria) throws SQLException {
        // declaração de objetos
        List<Nota> notas = new ArrayList<>();
        Nota nota;
        Aluno aluno;
        Materia materia;
        String comando
                = "SELECT notas.materia AS codigo_materia, "
                + "materia.nome  as nome_materia, "
                + "notas.aluno   as codigo_aluno, "
                + "aluno.nome    as nome_aluno, "
                + "notas.nota    as nota_nota "
                + "FROM notas "
                + "JOIN aluno ON notas.aluno = aluno.codigo "
                + "JOIN materia ON materia.codigo = notas.materia "
                + "WHERE aluno = ? AND materia = ? ";

        try (PreparedStatement ps = conn.prepareStatement(comando)) {
            ps.setInt(1, codigoAluno);
            ps.setInt(2, codigoMateria);

            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    //instanciados novos objetos para receber os valores do select e serem devolvidos como atributos dentro de 'notas'
                    aluno = new Aluno();
                    materia = new Materia();
                    aluno.setId(codigoAluno);
                    materia.setId(codigoMateria);
                    // nota recebendo aluno e materia como atributos.
                    nota = new Nota();
                    nota.setAluno(aluno);
                    nota.setMateria(materia);

                    nota.getAluno().setId(resultSet.getInt("codigo_aluno"));
                    nota.getAluno().setNome(resultSet.getString("nome_aluno"));

                    nota.getMateria().setId(resultSet.getInt("codigo_materia"));
                    nota.getMateria().setNome(resultSet.getString("nome_materia"));

                    nota.setNota(resultSet.getInt("nota_nota"));

                    notas.add(nota);
                }
            }
        }
        return notas;
    }
}
