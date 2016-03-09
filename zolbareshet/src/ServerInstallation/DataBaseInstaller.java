/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerInstallation;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static java.time.Clock.system;

/**
 *
 * @author peretzs
 */
public final class DataBaseInstaller
{
    public static String ReadQuery(String path, String encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    
    public static void RunQuery (String path , String DataBaseName) throws IOException
    {
    Connection connection = null ; 
    Connection connection2 = null ; 
    final String Coding = "UTF8" ; 
    final String URL = "jdbc:postgresql://localhost:5432/" ; 
    final String RunQuery = ReadQuery(path , Coding);
   
    try {   
        
        connection = DriverManager.getConnection(URL + DataBaseName , "postgres" , "shay8080");
        if ( connection.isValid(4000) == true ) 
        {
        System.out.println(RunQuery);     
        PreparedStatement table = connection.prepareStatement(RunQuery) ;    
        table.executeUpdate();
        table.closeOnCompletion();
        }
        }
         catch (SQLException sqlException)
        {
           sqlException.printStackTrace();
           
        }
     System.out.println("----------------------  Data Base Created !!  ---------------------" );
     

         
    }
    
    
    

    
        public static void tableCreator(String SELECT_Q)
    {
    Connection connection = null ; 
     Connection connection2 = null ; 
    final String URL = "jdbc:postgresql://localhost:5432/" ; 
    

   
    try {   

        connection2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres" , "shay8080") ;
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Zol_10" , "postgres" , "shay8080");
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
    
    System.out.println("----------------------Table Creator DONE !!!---------------------" );
    }
    
   ///TTTTT
    
    
    
}
