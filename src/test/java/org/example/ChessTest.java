package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class ChessTest {

    @Test
    public void testAll() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/chess";
        String user = "postgres";
        String password = "data";
        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM figure");

        while (resultSet.next()) {
            // обработка данных
            int king_x = resultSet.getInt("king_x");
            int king_y = resultSet.getInt("king_y");
            int bishope_x = resultSet.getInt("bishope_x");
            int bishope_y = resultSet.getInt("bishope_y");
            int rook_x = resultSet.getInt("rook_x");
            int rook_y = resultSet.getInt("rook_y");
            String result = resultSet.getString("result");
            Assertions.assertEquals(result, Chess.Resolve(king_x,king_y,bishope_x,bishope_y,rook_x,rook_y));
        }

        connection.close();
    }
}
