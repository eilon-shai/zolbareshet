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
@ManagedBean
public class CreateTables 
{
 
    public static void tableCreator()
    {
            final String CreateDB = "CREATE DATABASE ZolBareshet;" ; 
    final String URL = "jdbc:postgresql://localhost:5432/ZolBareshet" ; 
    final String SELECT_Q = "create table Person3 (\n" +
                            "	id numeric(9,0) NOT NULL,\n" +
                            "	first_name VARCHAR(50) NOT NULL,\n" +
                            "	original_surname VARCHAR(50) NOT NULL,\n" +
                            "	new_surname  VARCHAR(10) NOT NULL,\n" +
                            "	birth_date date NOT NULL\n" +
                            "	);";
   
    try (   
        
        Connection connection = DriverManager.getConnection(URL , "postgres" , "shay8080");
        //PreparedStatement dataBase = connection.prepareStatement(CreateDB))     
        PreparedStatement table = connection.prepareStatement(SELECT_Q) ) 
       
        
        {
           // dataBase.executeUpdate();
            table.executeUpdate();
        }
        
         catch (SQLException sqlException)
        {
           sqlException.printStackTrace();
        }
    }
    
}
