package br.com.isantos.exame.servlets;

import br.com.isantos.exame.domain.Aluno;
import br.com.isantos.exame.repository.AlunoRepository;
import br.com.isantos.exame.service.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by felipe on 14/06/16.
 */
//servlet de listagem dos alunos
@WebServlet("/aluno/listar")
public class ListarAlunoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //envia valores para o repositorio
            AlunoRepository alunoRepository = new AlunoRepository(conn);
            List<Aluno> alunos = alunoRepository.findAll();
            //request
            req.setAttribute("alunos", alunos);
            //carrega pagina
            req.getRequestDispatcher("/aluno/listar.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException("Erro ao listar alunos", e);
        }

    }
}
