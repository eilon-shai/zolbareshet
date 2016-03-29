package shay.eilon.zolbareshet.logging;

import shay.eilon.zolbareshet.utilities.Constants;
import shay.eilon.zolbareshet.utilities.FileChangeListener;
import shay.eilon.zolbareshet.utilities.PropertiesFileManager;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

//singelton
public class MainLogger extends Logger {
    private static File logFile = null;
    private String LOG_FILE_NAME;
    private String level;


    private Properties prop = PropertiesFileManager.getProp();
    private LogFileListener listener;
    private PrintStream stdout = null;
    private static volatile MainLogger logger;

    // GETTING THE PROPERTY FILE
    private MainLogger() {


        try {

            LOG_FILE_NAME = prop.getProperty(Constants.LOG_FILE_NAME_PROPERTY, null);
            level = prop.getProperty(Constants.DEBUGGING_LEVEL_PROPERTY, "INFO");
            if (LOG_FILE_NAME == null || LOG_FILE_NAME.trim().equals("")) {
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
                listener = new LogFileListener(PropertiesFileManager.getConfigFile());
                listener.start();
                stdout = new PrintStream(new FileOutputStream(logFile, true));


            } catch (Exception e) {
                System.out.println("ERROR: CAN'T OPEN LOG FILE");
                System.exit(1);
            }
        } catch (Exception ex) {
            System.out.println("ERROR: CAN'T OPEN CONFIGURATION FILE");
            System.exit(1);
        }
        stdout.append("\n*****************************************************************************************************\n");
        log(LEVEL.INFO, "log started successfully.... ");
    }


    public void log(LEVEL lev, String msg) {

        if (lev.equals(LEVEL.INFO)) {
            stdout.append(new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz").format(new Date()) + "\t\t|INFO|\t\t" + msg + "\n");
        } else if (lev.equals(LEVEL.WARNING)) {
            stdout.append(new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz").format(new Date()) + "\t\t|WARNING|\t\t" + msg + "\n");
        } else {
            if (level.equals(LEVEL.DEBUG.name())) {
                stdout.append(new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz").format(new Date()) + "\t\t|DEBUG|\t\t" + msg + "\n");
            }
        }

    }

    class LogFileListener extends FileChangeListener {
        public LogFileListener(File file) {
            super(file);
        }


        @Override
        public void propertyChanged() {

            try {
                PropertiesFileManager.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            level = prop.getProperty(Constants.DEBUGGING_LEVEL_PROPERTY, "INFO");
        }
    }

    public static Logger getLogger() {
        if (logger == null) {
            synchronized (MainLogger.class) {
                if (logger == null) {
                    logger = new MainLogger();
                    Runtime.getRuntime().addShutdownHook(new Thread() {
                        public void run() {
                            logger.destroy();
                        }
                    });
                }
            }
        }

        return logger;

    }


    public void destroy() {
        try {

            if (stdout != null) {
                logger.log(LEVEL.INFO, "server is shutting down....");
                stdout.close();
                System.out.println("closing log file");
            }
            if (listener != null && listener.isAlive()) {
                listener.stopRunning();
                listener.join();
                System.out.println("stopping file listener");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> readLog() {
        BufferedReader br = null;
        ArrayList<String> logLines = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(logFile));
            String line = br.readLine();
            while (line != null) {
                logLines.add(line);
                line = br.readLine();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return logLines;
    }

}
