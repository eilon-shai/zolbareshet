/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerInstallation;

import static ServerInstallation.DataBaseInstaller.tableCreator;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException; 
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author peretzs
 */
public class DataBaseInstallation {
  
   public static void main (String args []) throws IOException
    {
        final String DataBaseName = "Zol_10" ; 
        
        final String DataBasePath   = "C:\\ZolBareshert_GIT6\\Queries\\CREATE_DATABASE.sql" ; 
       DataBaseInstaller.RunQuery(DataBasePath  );
       
       
        final String tableUsers  =  "create table Users (\n" +
                                    "UserName VARCHAR(20)NOT NULL,\n" +
                                    "Password VARCHAR(50) NOT NULL,\n" +
                                    "IsActive boolean NOT NULL,\n" +
                                    "Address VARCHAR (50) NOT NULL,\n" +
                                    "PhoneNumber INTEGER NOT NULL,\n" +
                                    "UserType INTEGER NOT NULL,\n" +
                                    "PRIMARY KEY (UserName)\n"+
                                    ");";
         
  
         tableCreator(tableUsers);
         
         
     final String  tableParts  =    "create table Parts (\n"+
                                    "PartNumber numeric(12,0) NOT NULL,\n"+
                                    "PartName numeric(12,0) NOT NULL,\n"+
                                    "Description Text  NOT NULL,\n"+
                                    "Price numeric(12,0) NOT NULL,\n"+
                                    "AvailableQuantity numeric(12,0) NOT NULL,\n"+
                                    "IsForSale boolean NOT NULL,\n"+
                                    "Discount numeric(3,0) NOT NULL,\n"+
                                    "PRIMARY KEY (PartNumber) \n"+
                                    ");";
         
         
         tableCreator(tableParts);   
       
        
         
    final String  tableClientsPayment =     "create table ClientsPayment (\n"+
                                            "UserName VARCHAR(20) NOT NULL,\n"+
                                            "CardNumber  numeric(16,0) NOT NULL,\n"+
                                            "CardType Integer NOT NULL,\n"+
                                            "ExDate Date   NOT NULL,\n"+
                                            "PRIMARY KEY (UserName)\n"+ 
                                            ");";
         
         
     tableCreator(tableClientsPayment);    
     
     
         
    final String tableOrders =  "create table Orders (\n"+
                                "UserName VARCHAR(20) NOT NULL,\n"+
                                "PartNumber numeric(12,0) NOT NULL,\n"+
                                "OrderID numeric(12,0) NOT NULL,\n"+
                                "Quantity Integer NOT NULL,\n"+
                                "DateOrder Date NOT NULL,\n"+
                                "TimeOrder Time NOT NULL,\n"+
                                "TotalPay INTEGER NOT NULL,\n"+

                                "PRIMARY KEY (UserName ,PartNumber , OrderID) ,\n"+
                                "FOREIGN KEY (UserName ) REFERENCES Users(UserName) ,\n"+
                                "FOREIGN KEY (PartNumber ) REFERENCES Parts(PartNumber)\n"+
                                ");";
         
   tableCreator(tableOrders);     
   
   
   
   
     final String  tableCart =  "create table Cart (\n" +
                                "UserName VARCHAR(20)NOT NULL,\n"+
                                "PartNumber numeric(12,0) NOT NULL,\n"+
                                "Quantity Integer NOT NULL,\n"+
                                "TotalCartPay INTEGER NOT NULL,\n"+
                                "PRIMARY KEY (UserName ) ,\n"+
                                "FOREIGN KEY (PartNumber ) REFERENCES Parts(PartNumber) \n"+
                                ");";

    tableCreator(tableCart); 
     
    }
}

