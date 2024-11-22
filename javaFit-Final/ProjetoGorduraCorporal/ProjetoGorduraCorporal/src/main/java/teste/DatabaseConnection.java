package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Banco_de_Dados_JavaFit";
    private static final String USER = "seu_usuario";  // Substitua pelo seu usuário do MySQL
    private static final String PASSWORD = "sua_senha";  // Substitua pela sua senha do MySQL

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
