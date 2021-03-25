package pt.ips.ests.rs;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        // 1. Definir a query num String
        final String query = "SELECT * FROM contracts;";
        try {
            printDescriptions(query);
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void printDescriptions(String query) throws SQLException {
        // Ligar a uma base de dados
        final var connectionString = "jdbc:sqlite:database.sqlite";
        Connection connection = DriverManager.getConnection(connectionString);
        // Executar uma query (SELECT)

        // 2. Obter um statement
        Statement statement =  connection.createStatement();

        // 3. Executar o statement
        statement.execute(query);

        // Mostrar o resultado (Result Set)
        ResultSet resultSet =  statement.getResultSet();

        while(resultSet.next()) {
            System.out.println(resultSet.getString("description"));
        }

        // Desligar a ligação
        connection.close();
    }
}
