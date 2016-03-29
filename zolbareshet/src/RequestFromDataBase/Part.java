/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestFromDataBase;

import ServerInstallation.getInstallationConfig;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author peretzs
 */
public class Part {
    
    public static boolean isPartNumberExist(BigDecimal PartNumber)
    {
     String query = "SELECT partnumber\n" +  "from allparts\n"+  "where partnumber = " ;  
     String tag = "'" ;
     final String DataBaseURL = getInstallationConfig.getDataBaseURL(); 
     final String DataBaseUserName = getInstallationConfig.getDataBaseUserName(); 
     final String Password = getInstallationConfig.getDataBasePassword();       
     try ( Connection connection = DriverManager.getConnection(DataBaseURL  , DataBaseUserName , Password);    
         Statement stmt = connection.createStatement();  ResultSet res = stmt.executeQuery(query + tag + PartNumber + tag ) ) 
     {
          BigDecimal partNumber  ;
         while ( res.next())
         {
             
             partNumber =res.getBigDecimal(2); 
            if ( PartNumber ==  partNumber )
            return true ; 
            else return false ; 
         }
     }  
         catch (SQLException sqlException)
        {
            System.err.println("Got an exception while tring to request Part Number  ");
            sqlException.printStackTrace();
        }         
       return false ; 
    }
    
    public static boolean addPart()
    {
        return true ; 
    }
}
