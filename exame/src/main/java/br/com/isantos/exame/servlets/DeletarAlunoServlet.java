/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.isantos.exame.servlets;

import br.com.isantos.exame.domain.Aluno;
import br.com.isantos.exame.repository.AlunoRepository;
import br.com.isantos.exame.service.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author renancunha
 */
//Servlet para remoçao de alunos
@WebServlet("/aluno/deletar")
public class DeletarAlunoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("deletar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //novo objeto aluno para receber codigo a ser excluido
        Aluno aluno = new Aluno();
        aluno.setId(Integer.valueOf(request.getParameter("cd")));
        // manda objeto para o repositorio para ser excluido
        try (Connection conn = ConnectionFactory.getConnection()) {
            AlunoRepository alunoRepository = new AlunoRepository(conn);
            alunoRepository.delete(aluno);
        } catch (SQLException e) {
            throw new ServletException("Erro ao salvar aluno no banco de dados", e);
        }

        response.sendRedirect("listar");

    }
}
