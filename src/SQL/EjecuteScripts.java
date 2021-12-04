package SQL;

import com.mysql.jdbc.Connection;

import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EjecuteScripts {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root" , "");

        File scriptFile = new File("./script");
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(scriptFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String linea = null;
        StringBuilder stringBuilder = new StringBuilder();
        String salto = System.getProperty("line.separator");

        try{
            while ((linea = bufferedReader.readLine()) != null){
                stringBuilder.append(linea);
                stringBuilder.append(salto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String consulta = stringBuilder.toString();

        connection.close();
    }
}
