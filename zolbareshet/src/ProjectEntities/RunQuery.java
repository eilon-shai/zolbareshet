/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEntities;

import static ServerInstallation.DataBaseInstaller.ReadQuery;
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
public class RunQuery {
    
    public static void GetCountries () 
    {
    Connection connection = null ;  
    final String Coding = "UTF8" ; 
    final String URL = "jdbc:postgresql://localhost:5432/" ; 
    final String DataBaseName ="Zol_10" ; 
    final String q  =  "SELECT *\n"+
                        "FROM countries\n"+
                        "ORDER BY countrieName ASC" ; 

        try {   
        connection = DriverManager.getConnection(URL + DataBaseName , "postgres" , "shay8080");
        if ( connection.isValid(4000) == true ) 
        {
        System.out.println(" the Query is: "+ q);     
        PreparedStatement table = connection.prepareStatement(q) ;
         Statement stmt = connection.createStatement();
        ResultSet p ;
        p = stmt.executeQuery(q);
            System.out.println("ProjectEntities.RunQuery.GetCountries()"  );
            while (p.next() )
            {
              String country = p.getString("countrieName");
              System.out.println(country);
            }
        table.closeOnCompletion();
        }
        }
         catch (SQLException sqlException)
        {
           sqlException.printStackTrace();
           
        }
    }
    
}
