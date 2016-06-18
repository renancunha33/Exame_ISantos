package br.com.isantos.exame.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe Responsável por criar conexões
 * @author felipe
 */
public class ConnectionFactory {

    static {
        try {
            DriverManager.registerDriver(new org.h2.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Abre uma nova conexão com o banco de dados
     * @return Uma instância de <code>{@link Connection}</code> configurada para o banco de dados em uso
     * @throws SQLException Caso ocorra algum erro ao abrir a conexão
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }
}
