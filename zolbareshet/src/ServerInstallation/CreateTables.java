/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerInstallation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;



/**
 *
 * @author peretzs
 */
public class CreateTables 
{
    final String URLs = "jdbc:postgresql://localhost:5432/" ; 
    final String SELECT_Q = "CREATE DATABASE Zol5;";
    public CreateTables ()  
    {
    
    Connection connection = null ; 
    try {   
        
        connection = DriverManager.getConnection(URLs , "postgres" , "shay8080");     
        PreparedStatement table = connection.prepareStatement(SELECT_Q); 
        
        table.executeUpdate();
        table.closeOnCompletion();
        }
         catch (SQLException sqlException)
        {
           sqlException.printStackTrace();
        }
     finally {
             try {
            connection.close();
        } catch (SQLException sQLException) {
        }
             }
    }

    public static void tableCreator()
    {
    final String URL = "jdbc:postgresql://localhost:5432/Zol5" ; 
    final String SELECT_Q = "   create table Person34 (\n" +
                            "	id numeric(9,0) NOT NULL,\n" +
                            "	first_name VARCHAR(50) NOT NULL,\n" +
                            "	original_surname VARCHAR(50) NOT NULL,\n" +
                            "	new_surname  VARCHAR(10) NOT NULL,\n" +
                            "	birth_date date NOT NULL\n" +
                            "	);";
   
    try (   
        
        Connection connection = DriverManager.getConnection(URL , "postgres" , "shay8080");    
        PreparedStatement table = connection.prepareStatement(SELECT_Q) ) 
       
        {
            table.executeUpdate();
        }
        
         catch (SQLException sqlException)
        {
           sqlException.printStackTrace();
        }
    }
    
}
