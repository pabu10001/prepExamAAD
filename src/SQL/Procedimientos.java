package SQL;

import com.mysql.jdbc.Connection;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Procedimientos {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        Ejemplo procedimiento

        DELIMITER //
            CREATE PROCEDURE subida_sal(d INT, subida INT)
            BEGIN
            UPDATE empleados SET salario=salario+subida WHERE dept_no=d;
            COMMIT;
        END;//
         */

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root" , "");

        String sentencia = "{call subida_sal(?, ?) }";

        CallableStatement callableStatement = connection.prepareCall(sentencia);

        callableStatement.setInt(1, 10);
        callableStatement.setFloat(2, 3.5f);

        callableStatement.executeUpdate();

        callableStatement.close();
        connection.close();
    }
}
