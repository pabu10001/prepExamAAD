package SQL;

import com.mysql.jdbc.Connection;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Funciones {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*
        DELIMITER//
            CREATE FUNCTION nombre-dep(d int) RETURNS VARCHAR(15)
            BEGIN
            DECLARE nom VARCHAR(15);
            SET nom=‘INEXISTENTE’;
            SELECT dnombre INTO nom FROM departamentos WHERE dept_no=d;
            RETURN nom;
            END;//
         */

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root" , "");

        String sql = "{? = call nombre-dep(?) }";

        CallableStatement callableStatement = connection.prepareCall(sql);
        callableStatement.registerOutParameter(1, Types.VARCHAR);
        callableStatement.setInt(2, 10);

    }

    /*
    Ejemplo Funcion

    DELIMITER //
        CREATE FUNCTION nombre(nom VARCHAR(15)) RETURNS INT(3)
        BEGIN
        DECLARE num INT(3);
        SET num=0;
        SELECT COUNT() INTO num FROM empleados e, departamentos d where e.dept_no=d.dept_no and d.dnombre=nom HAVING COUNT()>5;
        RETURN num;
    END;//
     */
}
