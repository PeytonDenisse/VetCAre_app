
package org.vetcare.controller;
import java.sql.Connection; // importar la libreria 
import java.sql.DriverManager; // importamos 

public class ConexionMysql {
    Connection conn;
    
    //crear un metodo de conexxion 
    public Connection open(){
        //usuario de mysql 
        String user = "root";
        //pasword de mysql 
        String password = "12345";
        
        String url = "jdbc:mysql://127.0.0.1:3306/vetcare"; // nombre de la base de datos 
        //
        String parametros = "?useSSL=false&useUnicode=true&allowPublicKeyRetrieval=true&characterEncoding=utf-8";
        //estructura de mano de excepciones 
        try {
            //importr la libreria 
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url+parametros,user,password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    public void close(){
        if(conn != null ){
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        
    }
    
}
