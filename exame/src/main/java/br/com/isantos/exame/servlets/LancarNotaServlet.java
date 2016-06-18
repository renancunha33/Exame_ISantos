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
//Servlet de salvar notas
@WebServlet("/nota/lancar")
public class LancarNotaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Aluno> alunos;
        List<Materia> materias;
        try (Connection conn = ConnectionFactory.getConnection()) {
            alunos = new AlunoRepository(conn).findAll();
            materias = new MateriaRepository(conn).findAll();
        } catch (SQLException e) {
            throw new ServletException("Erro ao obter dados", e);
        }

        req.setAttribute("alunos", alunos);
        req.setAttribute("materias", materias);
        req.getRequestDispatcher("/nota/lancar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //proteçao contra valores nulos nos selects
        if ("Selecione...".equals(req.getParameter("aluno")) || "Selecione...".equals(req.getParameter("materia"))) {

            JOptionPane.showMessageDialog(null, "'Selecione...' não é uma opção valida!");
            req.getRequestDispatcher("/nota/listar.jsp").forward(req, resp);

        } else {
            //declara varaveis
            Integer alunoParameter = Integer.valueOf(req.getParameter("aluno"));
            Integer materiaParameter = Integer.valueOf(req.getParameter("materia"));
            Integer notaParameter = Integer.valueOf(req.getParameter("nota"));
            //instanvia novos objetos
            Nota nota = new Nota();
            Aluno aluno = new Aluno();
            Materia materia = new Materia();
            // valores inesridos no aluno e na materia antes de irem para a nota
            aluno.setId(alunoParameter);
            materia.setId(materiaParameter);
            // nota recebendo aluno e materia como atributos
            nota.setAluno(aluno);
            nota.setMateria(materia);
            nota.setNota(notaParameter);
            //salvando nota
            try (Connection conn = ConnectionFactory.getConnection()) {
                NotaRepository notaRepository = new NotaRepository(conn);
                notaRepository.save(nota);
            } catch (SQLException e) {
                throw new ServletException("Erro ao cadastrar nota " + notaParameter + " na materia " + materiaParameter + " para o aluno " + alunoParameter, e);
            }
            resp.sendRedirect(req.getContextPath() + "/nota/listar");
        }

    }
}
