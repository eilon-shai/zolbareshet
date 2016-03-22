/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEntities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author peretzs
 */
public class TestMain 
{
    
    public static void main (String args []) throws IOException
    {

        RunQuery.GetCountries();
       
       
    }
}
