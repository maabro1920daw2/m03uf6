/*
 * Paquets
 */
package database;
/**
 * Imports
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase per realitzar la connexio a la DB 
 * @author Marcos, Victor
 */
public class Connexio {
    protected Connection connect;    
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3308/BDGestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";    
    private final String USER = "root";
    private final String PASS = "";
    /**
     * Metode de connexio
     * @throws SQLException 
     */
    public void conectar() throws SQLException {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
            }
            connect = DriverManager.getConnection(DB_URL,USER,PASS);
        }catch(SQLException e){
            throw e;
        }
    }
    /**
     * Metode per tancar connexions
     * @throws SQLException 
     */
    public void cerrar() throws SQLException {
        if(this.connect != null){
            if(!this.connect.isClosed()) {
                this.connect.close();
            }
        }
    }    
}
