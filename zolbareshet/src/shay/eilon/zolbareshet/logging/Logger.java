package shay.eilon.zolbareshet.logging;

import shay.eilon.zolbareshet.utilities.Constants;
import shay.eilon.zolbareshet.utilities.FileChangeListener;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by eilons on 3/7/2016.
 */

public class Logger {
    private  File configFile=null;
    private  File logFile=null;
    private  FileInputStream stream;
    private  String LOG_FILE_NAME;
    private  String level;
    public enum LEVEL {DEBUG,WARNING,INFO};
    private  Properties prop;
    private LogFileListener listener;

        // GETTING THE PROPERTY FILE

    public Logger() {

        prop = new Properties();

        try {
            StringBuilder pathToJarFile = new StringBuilder(Logger.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            String pathToParentDirectory = pathToJarFile.substring(0, pathToJarFile.lastIndexOf("/"));
            configFile = new File(pathToParentDirectory + "/" + Constants.PROPERTY_FILE_NAME);
            stream = new FileInputStream(configFile);
            prop.load(stream);
            LOG_FILE_NAME = prop.getProperty(Constants.LOG_FILE_NAME_PROPERTY, null);
            level = prop.getProperty(Constants.DEBUGGING_LEEL_PROPERTY, "INFO");
            if (LOG_FILE_NAME == null) {
                throw new Exception();
            }
            try {
                Files.createDirectories(Paths.get(LOG_FILE_NAME.substring(0, LOG_FILE_NAME.lastIndexOf('/'))));
                Files.createFile(Paths.get(LOG_FILE_NAME));

            } catch (FileAlreadyExistsException ignored) {
                //file exists do nothing
            } catch (Exception e) {
                System.out.println("ERROR: CAN'T CREATE LOG FILE");
                System.exit(1);
            }
            try {
                logFile = new File(LOG_FILE_NAME);
                listener = new LogFileListener(logFile);

            } catch (Exception e) {
                System.out.println("ERROR: CAN'T OPEN LOG FILE");
                System.exit(1);
            }
        } catch (Exception ex) {
            System.out.println("ERROR: CAN'T OPEN CONFIGURATION FILE");
            System.exit(1);
        } finally {
            if (configFile != null) {
                try {
                    stream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public  void log(LEVEL lev,String msg){
        listener.singleupdate();
        PrintStream stdout = null;
        try {
           stdout = new PrintStream(new FileOutputStream
                    (logFile,true));

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: CAN'T OPEN LOG FILE");
            e.printStackTrace();
            System.exit(1);
        }
        if (lev.equals(LEVEL.INFO)){
            stdout.append(new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz").format(new Date()) + "\t\t|INFO|\t\t"+msg+"\n");
       }
        else if (lev.equals(LEVEL.WARNING)){
            stdout.append(new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz").format(new Date()) + "\t\t|WARNING|\t\t"+msg+"\n");
       }
        else {
           if(level.equals(LEVEL.DEBUG.name())) {
               stdout.append(new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz").format(new Date()) + "\t\t|DEBUG|\t\t"+msg+"\n");
           }
       }
        stdout.close();

    }

    class LogFileListener extends FileChangeListener {
        public LogFileListener(File file) {
            super(file);
        }



        @Override
        public void propertyChanged() {
            try {
                stream = new FileInputStream(getFile());
                prop.load(stream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            level = prop.getProperty(Constants.DEBUGGING_LEEL_PROPERTY,"INFO");
        }
    }

}
