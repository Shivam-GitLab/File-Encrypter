package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection connection = null;
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/fileEncrypted?useSSl=false",
                    "root","ShivamJha@2909");

        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
             e.printStackTrace();
        }
        System.out.println("Connection Successfully");
        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
            }
            catch (SQLException ex){
//                throw new RuntimeException(ex);
                 ex.printStackTrace();
            }
        }
    }
/*
    public static void main(String[] args) {
        MyConnection.getConnection();
    }
 */
}


