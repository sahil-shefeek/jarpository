// Requires a jdbc driver (for postgres in this case)
// For PostgresSQL visit: https://jdbc.postgresql.org/ 
// and ensure the downloaded jar file is included while compiling.

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {

        // url : jdbc:postgresql://hostname:port/db
        // url : jdbc:postgresql:database (hostname=localhost, port=5432 by default)
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String uname = "postgres";
        String passwd = "root";
        try {
            Connection connection = DriverManager.getConnection(url, uname, passwd);
            Statement statement = connection.createStatement();
            StringBuilder query = new StringBuilder("SELECT * FROM students");
            ResultSet results = statement.executeQuery(query.toString());
            while (results.next()) {
                System.out.printf("Name: %s, age: %s\n",results.getString(1), results.getString(2));
            }
            results.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("FATAL\nSQL Exception!");
            e.printStackTrace();
        }
    }
}
