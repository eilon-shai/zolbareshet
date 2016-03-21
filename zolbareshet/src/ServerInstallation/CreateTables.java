/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerInstallation;

import static java.lang.Class.forName;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;



/**
 *
 * @author peretzs
 */
public class CreateTables 
{
    final String URLs = "jdbc:postgresql://localhost:5432/" ; 
    final String SELECT_Q = "CREATE DATABASE \"Zol66\"\n" +
"  WITH OWNER = postgres\n" +
"       ENCODING = 'UTF8'\n" +
"       TABLESPACE = pg_default\n" +
"       LC_COLLATE = 'English_United States.1252'\n" +
"       LC_CTYPE = 'English_United States.1252'\n" +
"       CONNECTION LIMIT = -1;";
    public CreateTables ()  
    {
    
    Connection connection = null ; 
    try {   
        
        connection = DriverManager.getConnection(URLs , "postgres" , "shay8080");     
        PreparedStatement table = connection.prepareStatement(SELECT_Q); 
      //  connection.setAutoCommit(true);
       // connection.commit();
        table.executeUpdate();
        table.closeOnCompletion();

        
        }
         catch (SQLException sqlException)
        {
           sqlException.printStackTrace();
        }
//           finally {
//             try {
//            connection.commit();
//             } catch (SQLException sQLException) {
//        }
//             }
    }

    public static void tableCreator()
    {
    Connection connection = null ; 
     Connection connection2 = null ; 
    final String URL = "jdbc:postgresql://localhost:5432/" ; 
    final String SELECT_Q = "   create table Person33 (\n" +
                            "	id numeric(9,0) NOT NULL,\n" +
                            "	first_name VARCHAR(50) NOT NULL,\n" +
                            "	original_surname VARCHAR(50) NOT NULL,\n" +
                            "	new_surname  VARCHAR(10) NOT NULL,\n" +
                            "	birth_date date NOT NULL\n" +
                            "	);";
   
    try {   

        connection2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres" , "shay8080") ;
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Zol66" , "postgres" , "shay8080");
       // connection.getAutoCommit();
        if ( connection.isValid(4000) == true ) 
        {
        PreparedStatement table = connection.prepareStatement(SELECT_Q) ;
        table.executeUpdate();
        table.closeOnCompletion();
        }
        }
        
         catch (SQLException sqlException)
        {
           sqlException.printStackTrace();
           
        }
    }
    
}
