package RequestFromDataBase;

import ProjectEntities.User;
import static ServerInstallation.DataBaseInstaller.ReadQuery;
import ServerInstallation.getInstallationConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author peretzs
 */
public class DataUsers {
     public static boolean isUserExist(String USER)
    {
     String query = "SELECT username\n" +  "from users\n"+  "where username = " ;  
     String tag = "'" ;
     final String DataBaseURL = getInstallationConfig.getDataBaseURL(); 
     final String DataBaseUserName = getInstallationConfig.getDataBaseUserName(); 
     final String Password = getInstallationConfig.getDataBasePassword();       
     try ( Connection connection = DriverManager.getConnection(DataBaseURL  , DataBaseUserName , Password);    
         Statement stmt = connection.createStatement();  ResultSet res = stmt.executeQuery(query + tag + USER + tag ) ) 
     {
         String user = null  ;
         while ( res.next())
         {
            user  = (String)res.getObject(1) ;
            if ( USER.equals(user) )
            return true ; 
            else return false ; 
         }
     }  
         catch (SQLException sqlException)
        {
            System.err.println("Got an exception while tring to request user name  ");
            sqlException.printStackTrace();
        }         
       return false ; 
    }
     
     
    public static boolean setUser (User USER)
    {
        
     if (isUserExist( USER.getUserName()))
     {
         return false ;
     }
     else  { 
     String tag = "'" ;
     String query = "insert into users (username  , firstname, lastname , password , isactive , country , city , street,housenumber, zipcode , email , birthdate ,usertype,gender)  values ( " + tag + USER.getUserName() + tag  +" , 'shay'   , 'peretz' , '12345' , true  , 'israel' , 'pardes-hanna' ,'telTzvi' ,'3' , 36666 ,'shay@gmail.com', '1982-06-26', 1 ,1)"; 
     
  
     
     
     final String DataBaseURL = getInstallationConfig.getDataBaseURL(); 
     final String DataBaseUserName = getInstallationConfig.getDataBaseUserName(); 
     final String Password = getInstallationConfig.getDataBasePassword();       
     try ( Connection connection = DriverManager.getConnection(DataBaseURL  , DataBaseUserName , Password);    
         Statement stmt = connection.createStatement();  ResultSet res = stmt.executeQuery(query ) ) 
     {
         String user = null  ;
         while ( res.next())
         {
            user  = (String)res.getObject(1) ;
            if ( USER.equals(user) )
            return true ; 
            else return false ; 
         }
     }  
         catch (SQLException sqlException)
        {
            System.err.println("Got an exception while tring to request user name  ");
            sqlException.printStackTrace();
        }         
       return false ; 
     }
    }
     
}


