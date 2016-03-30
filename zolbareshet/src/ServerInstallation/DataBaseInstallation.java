/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerInstallation;

import static ServerInstallation.DataBaseInstaller.tableCreator;
import java.io.IOException;

public class DataBaseInstallation {
  
   public static void main (String args []) throws IOException
    {
 
        final String DataBasePath   = "C:\\Users\\eilons\\Documents\\GitHub\\zolbareshet\\zolbareshet\\src\\ServerInstallation\\CREATE_DATABASE.sql" ;
        DataBaseInstaller.RunQuery(DataBasePath );
        
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
          System.out.println("ServerInstallation.DataBaseInstallation.main()" + tableUsers  );
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
            
        final String  tableClientsPayment =     "   create table ClientsPayment (\n" +
                                            "	UserName VARCHAR(20) NOT NULL,\n" +
                                            "	UserID numeric(10,0) NOT NULL,\n" +
                                            "	CardNumber  numeric(16,0) NOT NULL,\n" +
                                            "	CardType Integer NOT NULL,\n" +
                                            "	ExDate Date   NOT NULL,\n" +
                                            "	PRIMARY KEY (UserName)\n" +
                                            "	 \n" +
                                            "	);";
 
        final String tableOrders =  "   create table Orders (\n" +
                                "   OrderID numeric(12,0) NOT NULL,\n" +
                                "   DateOrder Date NOT NULL, \n" +
                                "   TimeOrder Time NOT NULL, \n" +
                                "   TotalPay INTEGER NOT NULL,\n" +
                                "   PRIMARY KEY (OrderID)\n" +
                                "   );";
         
        final String  tableCart =  "   create table Cart (\n" +
                                "   UserName VARCHAR(20)NOT NULL,\n" +
                                "   PartNumber numeric(12,0) NOT NULL,\n" +
                                "   Quantity Integer NOT NULL,\n" +
                                "   PRIMARY KEY (UserName ) ,\n" +
                                "   FOREIGN KEY (PartNumber ) REFERENCES Parts(PartNumber) \n" +
                                "   );";

        final String  PhoneNumber =   "       create table PhoneNumber (\n" +
                                "	UserName    VARCHAR(20) NOT NULL,\n" +
                                "	PhoneNumber1 Numeric (10) NOT NULL,\n" +
                                "	PhoneNumber2 Numeric (10),\n" +
                                "	PhoneNumber3 Numeric (10),\n" +
                                "	PhoneNumber4 Numeric (10),\n" +
                                "	PRIMARY KEY (UserName)\n" +
                                ");";

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

        final String  countries = "create table countries (\n" + 
                                    "countrieName VARCHAR(50) NOT NULL,\n" + 
                                    "PRIMARY KEY (countrieName)\n" + 
                                    ");\n" ; 
    
        tableCreator(tableUsers);
        tableCreator(tableParts);
        tableCreator(tableClientsPayment); 
        tableCreator(tableOrders); 
        tableCreator(tableCart);
        tableCreator(PhoneNumber); 
        tableCreator(OrderContent); 
        tableCreator(countries);
          
             
            
         
          
         
    }
}

