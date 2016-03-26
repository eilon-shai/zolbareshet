/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package tempfiles;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 *
 * @author peretzs
 */
public class InstallationProperty 
{
    private final static String CodingPROPERTY = "Coding" ; 
    private final static String URLPROPERTY = "URL" ;
    private final static String DataBaseNamePROPERTY   = "DataBaseName" ; 
    private final static String DataBaseUserNamePROPERTY   = "DataBaseUserName";
    private final static String DataBasePasswordPROPERTY   = "DataBasePassword"; 
    public  final static String PROPERTY_FILE_NAME="config.properties";
    private static String Code;
    private static String urls ; 
    private static String DBname ; 
    private static String username ; 
    private static String password ; 
    
    static InputStream file=null;
    static {
        // GETTING THE PROPERTY FILE
        Properties prop = new Properties();
        try {
            StringBuilder pathToJarFile = new StringBuilder(InstallationProperty.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            String pathToParentDirectory = pathToJarFile.substring(0, pathToJarFile.lastIndexOf("/"));
            file = new FileInputStream(new File(pathToParentDirectory + "/" + PROPERTY_FILE_NAME));
            prop.load(file);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Occurs Trying to Open the config.properties File", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            if (file != null) {
                try {
                    file.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //GETTING THE PROPERTIES
        Code = prop.getProperty(CodingPROPERTY);
        System.err.println("Code:" + Code );
        //lastName = prop.getProperty(LAST_NAME_PROPERTY,DEFAULT_LAST_NAME);
    }
       
            
        
 
    
}
