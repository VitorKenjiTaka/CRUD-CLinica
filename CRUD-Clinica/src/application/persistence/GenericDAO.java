package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO {

    private Connection c;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String hostName = "localhost";
        String dbName = "clinica_medica";
        String user = "brufrag";
        String senha = "teste123";

        Class.forName("net.sourceforge.jtds.jdbc.Driver");

        c = DriverManager.getConnection(String.format("jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;", 
                hostName, dbName, user, senha));

        return c;
    }

}