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
    
    public static void RunQuery (String path ) throws IOException
    {
    Connection connection = null ; 
    char slash = '/' ;
    final String Coding = getInstallationConfig.getCoding() ; 
    final String URL = getInstallationConfig.getURL() ; 
    final String RunQuery = ReadQuery(path , Coding);
    final String dataBaseName = getInstallationConfig.getDataBaseName() ; 
    final String DataBaseUserName = getInstallationConfig.getDataBaseUserName();
    final String Password = getInstallationConfig.getDataBasePassword(); 
    try {   
        
        connection = DriverManager.getConnection(URL  , DataBaseUserName , Password);
        //connection = DriverManager.getConnection(URL+slash+dataBaseName , DataBaseUserName , Password);
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
    final String URL = getInstallationConfig.getURL() ; 
    
    try {   

        char slash = '/' ;
        connection = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/ZolBareshetDataBase" , getInstallationConfig.getDataBaseUserName() , getInstallationConfig.getDataBasePassword());
        connection.getAutoCommit();
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
    
  
}
