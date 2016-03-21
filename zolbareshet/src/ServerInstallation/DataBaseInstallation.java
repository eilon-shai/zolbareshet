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
       DataBaseInstaller.RunQuery(DataBasePath , "");
       
       
        final String tableUsers  =  "create table Users (\n" +
                                    "	UserName    VARCHAR(20) NOT NULL,\n" +
                                    "	FirstName   VARCHAR(50) NOT NULL,\n" +
                                    "	LastName    VARCHAR(50) NOT NULL,\n" +
                                    "	Password    VARCHAR(50) NOT NULL,\n" +
                                    "	IsActive    boolean NOT NULL,\n" +
                                    "	country     VARCHAR(50) NOT NULL,\n" +
                                    "	City        VARCHAR(50) NOT NULL,\n" +
                                    "	Street      VARCHAR(50) NOT NULL,\n" +
                                    "	HouseNumber VARCHAR(10) NOT NULL,\n" +
                                    "	ZipCode     INTEGER NOT NULL,\n" +
                                    "	Email       VARCHAR(50) NOT NULL,\n" +
                                    "	BirthDate   date not null ,  \n" +
                                    "	UserType    INTEGER NOT NULL,\n" +
                                    "	Gender      integer ,\n" +
                                    "	\n" +
                                    "	PRIMARY KEY (UserName)\n" +
                                    ");";
         
  
         tableCreator(tableUsers);
         
         
     final String  tableParts  =    "   create table Parts (\n" +
                                    "	PartNumber numeric(12,0) NOT NULL,\n" +
                                    "	PartName numeric(12,0) NOT NULL,\n" +
                                    "	Description Text  NOT NULL,\n" +
                                    "	Price numeric(12,0) NOT NULL,\n" +
                                    "	AvailableQuantity numeric(12,0) NOT NULL,\n" +
                                    "	IsForSale boolean NOT NULL,\n" +
                                    "	Discount numeric(3,0) NOT NULL,\n" +
                                    "	PRIMARY KEY (PartNumber) \n" +
                                    "	 \n" +
                                    "	);";
         
         
         tableCreator(tableParts);   
       
        
         
    final String  tableClientsPayment =     "   create table ClientsPayment (\n" +
                                            "	UserName VARCHAR(20) NOT NULL,\n" +
                                            "	UserID numeric(10,0) NOT NULL,\n" +
                                            "	CardNumber  numeric(16,0) NOT NULL,\n" +
                                            "	CardType Integer NOT NULL,\n" +
                                            "	ExDate Date   NOT NULL,\n" +
                                            "	PRIMARY KEY (UserName)\n" +
                                            "	 \n" +
                                            "	);";
         
         
     tableCreator(tableClientsPayment);    
     
     
         
    final String tableOrders =  "   create table Orders (\n" +
                                "   OrderID numeric(12,0) NOT NULL,\n" +
                                "   DateOrder Date NOT NULL, \n" +
                                "   TimeOrder Time NOT NULL, \n" +
                                "   TotalPay INTEGER NOT NULL,\n" +
                                "   PRIMARY KEY (OrderID)\n" +
                                "   );";
         
   tableCreator(tableOrders);     
   
   
   
   
     final String  tableCart =  "   create table Cart (\n" +
                                "   UserName VARCHAR(20)NOT NULL,\n" +
                                "   PartNumber numeric(12,0) NOT NULL,\n" +
                                "   Quantity Integer NOT NULL,\n" +
                                "   PRIMARY KEY (UserName ) ,\n" +
                                "   FOREIGN KEY (PartNumber ) REFERENCES Parts(PartNumber) \n" +
                                "   );";

    tableCreator(tableCart); 
    
    final String  PhoneNumber =   "       create table PhoneNumber (\n" +
                                "	UserName    VARCHAR(20) NOT NULL,\n" +
                                "	PhoneNumber1 Numeric (10) NOT NULL,\n" +
                                "	PhoneNumber2 Numeric (10),\n" +
                                "	PhoneNumber3 Numeric (10),\n" +
                                "	PhoneNumber4 Numeric (10),\n" +
                                "	PRIMARY KEY (UserName)\n" +
                                ");";

    tableCreator(PhoneNumber); 
    
    final String  OrderContent =  "create table OrderContent (\n" +
                                "	UserName VARCHAR(20) NOT NULL,\n" +
                                "	PartNumber numeric(12,0) NOT NULL,\n" +
                                "	OrderID numeric(12,0) NOT NULL,\n" +
                                "	Quantity Integer NOT NULL,\n" +
                                "	PRIMARY KEY (UserName ,PartNumber , OrderID) ,\n" +
                                "	FOREIGN KEY (UserName ) REFERENCES Users(UserName) ,\n" +
                                "	FOREIGN KEY (PartNumber ) REFERENCES Parts(PartNumber), \n" +
                                "	FOREIGN KEY (OrderID ) REFERENCES Orders(OrderID)\n" +
                                "	);";

    tableCreator(OrderContent); 
     
    }
}

