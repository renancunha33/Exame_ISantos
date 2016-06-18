package br.com.isantos.exame;

import br.com.isantos.exame.service.ConnectionFactory;
import org.h2.tools.Server;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by felipe on 14/06/16.
 */
@WebListener
public class Bootstrap implements javax.servlet.ServletContextListener {

    private Server server;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            server = Server.createTcpServer();

            try (Connection connection = ConnectionFactory.getConnection()) {

                connection.createStatement().execute("DROP TABLE IF EXISTS aluno");
                connection.createStatement().execute("DROP TABLE IF EXISTS materia");
                connection.createStatement().execute("DROP TABLE IF EXISTS notas");

                String tabelaAluno = "CREATE TABLE aluno (codigo INTEGER auto_increment PRIMARY KEY, nome VARCHAR(200) NOT NULL, data_nascimento DATETIME);";
                connection.createStatement().execute(tabelaAluno);

                String tabelaMateria = "CREATE TABLE materia (codigo INTEGER auto_increment PRIMARY KEY, nome VARCHAR(100));";
                connection.createStatement().execute(tabelaMateria);

                String tabelaNotas
                        = "CREATE TABLE notas ("
                        + "aluno INTEGER, "
                        + "materia INTEGER, "
                        + "nota INTEGER, "
                       // + "CONSTRAINT notas_pk PRIMARY KEY (aluno, materia), "  
                        + "CONSTRAINT notas_aluno_fk FOREIGN KEY (aluno) REFERENCES aluno (codigo), "
                        + "CONSTRAINT notas_materia_fk FOREIGN KEY (materia) REFERENCES materia (codigo)); ";
                connection.createStatement().execute(tabelaNotas);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        server.stop();
    }
}

/*
*
* Comentei a linha do create table pois se a combinaçao aluno + materia 
* nao for PK um aluno pode receber mais de uma nota na mesma materia
* sem problemas.
*
*/
