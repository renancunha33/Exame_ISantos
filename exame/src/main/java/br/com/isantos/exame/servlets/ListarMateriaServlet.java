package br.com.isantos.exame.servlets;

import br.com.isantos.exame.domain.Materia;
import br.com.isantos.exame.repository.MateriaRepository;
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
 * @author Felipe Martins
 */
//servlet de listagem das materias
@WebServlet("/materia/listar")
public class ListarMateriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //envia valores para o repositorio
            MateriaRepository materiaRepository = new MateriaRepository(conn);
            List<Materia> materias = materiaRepository.findAll();
            //request
            req.setAttribute("materias", materias);
            //carrega pagina
            req.getRequestDispatcher("/materia/listar.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException("Erro ao listar materias", e);
        }

    }
}
