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

/**
 * Created by felipe on 14/06/16.
 */
//Servlet de cadastro de alunos
@WebServlet("/aluno/cadastrar")
public class CadastrarAlunoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("cadastrar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //novo objeto
        Aluno aluno = new Aluno();
        aluno.setNome(request.getParameter("nome"));
        //enviando dados ao repositorio para o cadastro
        try (Connection conn = ConnectionFactory.getConnection()) {
            AlunoRepository alunoRepository = new AlunoRepository(conn);
            alunoRepository.save(aluno);
        } catch (SQLException e) {
            throw new ServletException("Erro ao salvar aluno no banco de dados", e);
        }
        //voltar para o listar
        response.sendRedirect("listar");

    }
}
