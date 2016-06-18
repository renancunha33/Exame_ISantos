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

//Servlet para remoçao de materias
@WebServlet("/materia/deletar")
public class DeletarMateriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("deletar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //novo objeto materia para receber codigo a ser excluido
        Materia materia = new Materia();
        materia.setId(Integer.valueOf(request.getParameter("cd")));
        // manda objeto para o repositorio para ser excluido
        try (Connection conn = ConnectionFactory.getConnection()) {
            MateriaRepository materiaRepository = new MateriaRepository(conn);
            materiaRepository.delete(materia);
        } catch (SQLException e) {
            throw new ServletException("Erro ao salvar aluno no banco de dados", e);
        }

        response.sendRedirect("listar");

    }
}
