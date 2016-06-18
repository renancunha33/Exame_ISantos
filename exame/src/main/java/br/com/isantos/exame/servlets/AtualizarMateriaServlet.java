/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.isantos.exame.servlets;

import br.com.isantos.exame.domain.Materia;
import br.com.isantos.exame.repository.MateriaRepository;
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
//Servlet de atualizaçao de materias
@WebServlet("/materia/atualizar")
public class AtualizarMateriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("atualizar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //novo objeto recebe id do registro a ser alterado + novo nome do registro
        Materia materia = new Materia();
        materia.setId(Integer.valueOf(request.getParameter("cd")));
        materia.setNome(request.getParameter("nome"));
        //enviando dados ao repositorio para o update
        try (Connection conn = ConnectionFactory.getConnection()) {
            MateriaRepository materiaRepository = new MateriaRepository(conn);
            materiaRepository.update(materia);
        } catch (SQLException e) {
            throw new ServletException("Erro ao salvar aluno no banco de dados", e);
        }
        //voltar para o listar
        response.sendRedirect("listar");

    }
}
