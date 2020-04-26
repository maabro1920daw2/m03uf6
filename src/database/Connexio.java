/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marcos
 */
public class Connexio {
    protected Connection connect;
    
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/BDGestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    private final String USER = "root";
    private final String PASS = "";
    
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
    
    public void cerrar() throws SQLException {
        if(this.connect != null){
            if(!this.connect.isClosed()) {
                this.connect.close();
            }
        }
    }    
}
