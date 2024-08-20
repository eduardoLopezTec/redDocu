
package reddocuconexion;

/**
 *
 * @author ADM
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RedDocuConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/reddocu";
        
        Connection conexion;
        Statement sentencia;
        ResultSet respuesta;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RedDocuConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            
            sentencia = conexion.createStatement();
            
            /***  SENTENCIA PARA ELIMINAR UN REGISTRO    
            sentencia.executeUpdate("DELETE FROM estados WHERE idEstado = #");
            ***/
            
            /***  SENTENCIA PARA AGREGAR UN REGISTRO NUEVO A LA TABLA CUENTA
            sentencia.executeUpdate("INSERT INTO `cuenta` (`correo`, `clave`) VALUES ('correosara@mail.com', 'sara123')");
            ***/
            
            /***  SENTENCIA PARA INGRESAR UN REGISTRO NUEVO A TABLA SUSCRIPTOR
            sentencia.executeUpdate("INSERT INTO `suscriptor` (`primerNombre`, `segundoNombre`, `primerApellido`, `segundoApellido`, `edad`, `fechaNacimiento`, `cuenta_idCuenta`) VALUES ('Pedro', 'Maria', 'Obando', NULL, 20, '2004-07-23', 4)");
            ***/
            
            /***  SENTENCIA DE ACTUALIZACIÓN DE UN REGISTRO EN LA TABLA CUENTA
            sentencia.executeUpdate("UPDATE `cuenta` SET `correo` = 'correopedro2@mail.com', `clave` = 'pedro1234' WHERE `idCuenta` = 4");
            ***/
            
            /***  LA SIGUIENTE CONSULTA MUESTRA LOS DATOS DE LA CUENTA UNIDOS AL ESTADO EXTRAIDO DE LA TABLA ESTADOS  ***/
            respuesta = sentencia.executeQuery("SELECT `idCuenta`, `correo`, `clave`, `estado` FROM `cuenta` JOIN `estados` on `idEstado` = `estados_idEstado`");
            respuesta.next();
            
            do {
                System.out.println(respuesta.getInt("idCuenta") + " : " + respuesta.getString("correo") + " : " + respuesta.getString("clave") + " : " + respuesta.getString("estado"));
            } while(respuesta.next());
                    
        } catch (SQLException ex) {
            Logger.getLogger(RedDocuConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
