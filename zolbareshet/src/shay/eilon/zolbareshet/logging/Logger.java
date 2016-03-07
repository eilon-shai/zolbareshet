package shay.eilon.zolbareshet.logging;

import shay.eilon.zolbareshet.utilities.Constants;
import com.esotericsoftware.minlog.*;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created by eilons on 3/7/2016.
 */

public class Logger {
    private static InputStream file=null;
    private static String LOG_FILE_NAME;
    public enum LEVEL {DEBUG,WARNING,INFO};
    static {
        // GETTING THE PROPERTY FILE
        Properties prop = new Properties();
        try {
            StringBuilder pathToJarFile = new StringBuilder(Logger.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            String pathToParentDirectory = pathToJarFile.substring(0, pathToJarFile.lastIndexOf("/"));
            file = new FileInputStream(new File(pathToParentDirectory + "/" + Constants.PROPERTY_FILE_NAME));
            prop.load(file);
            LOG_FILE_NAME = prop.getProperty(Constants.LOG_FILE_NAME_PROPERTY,null);
            if (LOG_FILE_NAME==null){
                throw new Exception();
            }
            PrintStream	stdout	= null;
            try {
                Files.createFile(Paths.get(LOG_FILE_NAME));
            }
            catch (FileAlreadyExistsException ignored) {
                //file exists do nothing
            }
            catch (Exception e){
                System.out.println("ERROR: CAN'T CREATE LOG FILE");
                System.exit(1);
            }
            try{

                stdout = new PrintStream (new FileOutputStream
                        (LOG_FILE_NAME));
                System.setOut(stdout);
            }

            catch (Exception e){
                System.out.println("ERROR: CAN'T OPEN LOG FILE");
                System.exit(1);
            }
        } catch (Exception ex) {
            System.out.println("ERROR: CAN'T OPEN CONFIGURATION FILE");
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

    }
    public static void log(LEVEL level,String msg){
       if (level.equals(LEVEL.INFO)){
           Log.info(msg);
       }
        else if (level.equals(LEVEL.WARNING)){
           Log.warn(msg);
       }
        else {
           Log.debug(msg);
       }

    }
}
