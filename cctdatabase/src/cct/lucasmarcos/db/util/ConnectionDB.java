package cct.lucasmarcos.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {
    //definindo as propriedades do banco
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DBNAME = "cct";
    private final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
    private final String LOGIN = "root";
    private final String SENHA = "";

    //método que estabele a conexão
    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
//            System.out.printf("Conectou");
            return DriverManager.getConnection(URL, LOGIN, SENHA);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
