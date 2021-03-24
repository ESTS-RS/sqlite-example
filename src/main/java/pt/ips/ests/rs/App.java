package pt.ips.ests.rs;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        // Ligar a uma base de dados
        final var connectionString = "jdbc:sqlite:C:\\Users\\amgs\\dev\\ests\\rs\\sqlite-example\\database.sqlite";
        Connection connection = null;
        try {
            connection= DriverManager.getConnection(connectionString);
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        // Executar uma query (SELECT)

        // 1. Definir a query num String
        final String query = "SELECT * FROM contracts;";

        // 2. Obter um statement
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        // 3. Executar o statement
        try {
            statement.execute(query);
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        // Mostrar o resultado (Result Set)
        ResultSet resultSet = null;
        try {
            resultSet = statement.getResultSet();
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            while(resultSet.next()) {
                final String descripion = resultSet.getString("description");
                System.out.println(descripion);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }

        // Desligar a ligação
        try {
            connection.close();
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
