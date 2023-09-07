/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionsqltarea;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;




/**
 *
 * @author PREDATOR
 */
 public class SQLCon {

    public SQLCon() {
    }
    
    public void Query(){
        final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:XE";
        final String USER = "system";
        final String PWD = "cambara";
        
        //final String SELECT_QUERY = "SELECT ID_PAIS, NOMBRE_PAIS, ABREVIATURA FROM PAISES ORDER BY ID_PAIS ASC";
        final String SELECT_QUERY = "(SELECT ID_PAIS, CODIGO, NOMBRE_PAIS, ABREVIATURA FROM PAISES)";
        final String INSERT_QUERY = "INSERT INTO PAISES(ID_PAIS, CODIGO, NOMBRE_PAIS, ABREVIATURA) VALUES(4,54,'ARGENTINA','ARG')";
        //final String UPDATE_QUERY = "UPDATE SYSTEM.PAISES SET CODIGO = 54, NOMBRE_PAIS = 'ARGENTINA', ABREVIATURA = 'ARG', FECHA_EDICION = SYSDATE WHERE ID_PAIS = 2";
        //final String DELETE_QUERY = "DELETE FROM SYSTEM.PAISES WHERE NOMBRE_PAIS = 'GUATEMALA'";
        
        try(
                Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PWD);
                Statement statement = connection.createStatement();
                //ResultSet resulSet = statement.executeQuery(UPDATE_QUERY);
                //ResultSet resulSet = statement.executeQuery(DELETE_QUERY);
                //ResultSet resulSet = statement.executeQuery(INSERT_QUERY);
                ResultSet resulSet = statement.executeQuery(SELECT_QUERY)
                
                )
        {
           
            ResultSetMetaData metaData = resulSet.getMetaData();
            int numeroColumnas = metaData.getColumnCount();
            
            System.out.println("Tabla de paises: ");
            
            
            for (int i = 1; i <= numeroColumnas; i++) {
                System.out.println(metaData.getColumnName(i));
                //System.out.println();
            }
            
            System.out.println();
            
            while (resulSet.next()) {
                for (int i = 1; i <=numeroColumnas; i++) {
                    System.out.println(resulSet.getObject(i));
                    //System.out.println();
                }
                System.out.println();
            }
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error " + e.toString());
            
        }
        }
 }
    
    
 

    
