package br.com.isantos.exame.servlets;

import br.com.isantos.exame.domain.Aluno;
import br.com.isantos.exame.domain.Materia;
import br.com.isantos.exame.domain.Nota;
import br.com.isantos.exame.repository.AlunoRepository;
import br.com.isantos.exame.repository.MateriaRepository;
import br.com.isantos.exame.repository.NotaRepository;
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
import javax.swing.JOptionPane;

/**
 * Created by felipe on 15/06/16.
 */

//servlet de listagem as notas
@WebServlet("/nota/listar")
public class ListarNotaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Aluno> alunos;
        List<Materia> materias;
        try (Connection conn = ConnectionFactory.getConnection()) {
            alunos = new AlunoRepository(conn).findAll();
            materias = new MateriaRepository(conn).findAll();
        } catch (SQLException e) {
            throw new ServletException("Erro ao carregar dados", e);
        }

        req.setAttribute("alunos", alunos);
        req.setAttribute("materias", materias);

        req.getRequestDispatcher("/nota/listar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // proteção caso nenhum curso ou aluo eja selecionado para pesquisa.
        if ("Selecione...".equals(req.getParameter("aluno")) || "Selecione...".equals(req.getParameter("materia"))) {
            JOptionPane.showMessageDialog(null, "'Selecione...' não é uma opção valida!");
        } else {
            // declaraçao de variavel
            Integer codigoAluno = Integer.parseInt(req.getParameter("aluno"));
            Integer codigoMateria = Integer.parseInt(req.getParameter("materia"));
            //lista
            List<Nota> notas;
            try (Connection conn = ConnectionFactory.getConnection()) {
                //envia valores para o repositorio
                NotaRepository notaRepository = new NotaRepository(conn);
                notas = notaRepository.findAllByAlunoAndMateria(codigoAluno, codigoMateria);

            } catch (SQLException e) {

                throw new ServletException("Erro ao listar notas", e);
            }
            //request
            req.setAttribute("notas", notas);
        }
        //carrega pagina
        req.getRequestDispatcher("/nota/listar.jsp").forward(req, resp);

    }
}
