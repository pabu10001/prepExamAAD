package SQL;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SentenciasPreparadas {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root" , "");

        String sql = "INSERT INTO departamentos VALUES (?, ?,?)";

        PreparedStatement preparedStatement = connection.clientPrepareStatement(sql);
        preparedStatement.setInt(1, Integer.parseInt("3"));
        preparedStatement.setString(2, "cadena");
        preparedStatement.setString(3, "cadena");

        try {
            int filas = preparedStatement.executeUpdate();
            System.out.println("Filas afectadas:  " + filas);
        }catch (SQLException ignored){}

        /*
        void setString(int índice, String valor) VARCHAR
        void setBoolean(int índice, boolean valor) BIT
        void setByte(int índice, byte valor) TiNYINT
        void setShort(int índice, short valor) SMALLINT
        void setInt(int índice, int valor) INTEGER
        void setLong(int índice, long valor)BIGINT
        void setFloat(int índice, float valor) FLOAT
        void setDouble(int índice, doublé valor)  DOUBLE
        void setByte(int índice, byte[] valor) VARBINARY
        void setDate(int índice, Date valor) DATE
        void setTime(int índice, Time valor) TIME
         */

        connection.close();
    }
}
