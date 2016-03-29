package shay.eilon.zolbareshet.database;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory;
import shay.eilon.zolbareshet.entities.users.Password;
import shay.eilon.zolbareshet.logging.Logger;
import shay.eilon.zolbareshet.logging.MainLogger;
import shay.eilon.zolbareshet.logging.LoggerFactory;
import shay.eilon.zolbareshet.utilities.Constants;
import shay.eilon.zolbareshet.utilities.PropertiesFileManager;

import javax.naming.Context;
import java.util.Hashtable;
import java.util.Properties;



public class CustomDataSourceFactory  extends BasicDataSourceFactory {
    private Properties prop = PropertiesFileManager.getProp();
    private String username=prop.getProperty(Constants.USER_NAME_PROPERTY,null);
    private String encPass=prop.getProperty(Constants.ENCRYPTED_PASSWORD_PROPERTY,null);
    private Logger logger = LoggerFactory.getLogger();

    @Override
    public Object getObjectInstance(Object obj, javax.naming.Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
            Object o = super.getObjectInstance(obj, name, nameCtx, environment);
            if (o != null) {
                BasicDataSource ds = (BasicDataSource) o;
                if(username!=null){
                    ds.setUsername(username);
                }
                else{
                    logger.log(MainLogger.LEVEL.WARNING,"the database user name is missing - can't create database");
                    return null;
                }
                if (encPass != null &&encPass.length() > 0) {
                    String pwd = Password.decrypt(encPass);
                    ds.setPassword(pwd);
                    logger.log(MainLogger.LEVEL.INFO,"database was successfully created");
                }
                else{
                    logger.log(MainLogger.LEVEL.WARNING,"the database password is missing - can't create database");
                    return null;

                }
                return ds;
            } else {
                logger.log(MainLogger.LEVEL.WARNING,"unexpected error - can't create database");
                return null;
            }
        }
}
