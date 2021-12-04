package SQL;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBasica {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root" , "");

        Statement statement = connection.createStatement();

        int resultado = statement.executeUpdate("sentencia SQL");

        ResultSet resultSet = statement.executeQuery("sentencia SQL") ; //Ejecuta una Query

        while (resultSet.next()){
            System.out.println(resultSet.getString(1) + " -- " +resultSet.getString(2)+" -- " +resultSet.getString(3));
        }

        resultSet.close();
        connection.close();
    }
}
