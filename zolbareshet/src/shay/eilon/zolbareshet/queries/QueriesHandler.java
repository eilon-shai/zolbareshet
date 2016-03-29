package shay.eilon.zolbareshet.queries;

import shay.eilon.zolbareshet.logging.Logger;
import shay.eilon.zolbareshet.logging.MainLogger;
import shay.eilon.zolbareshet.logging.LoggerFactory;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;



public class QueriesHandler {
    private  static DataSource ds;
    private  static Logger logger = LoggerFactory.getLogger();


    static{
                try {
                    Context ctx = new InitialContext();
                    ds = (DataSource)ctx.lookup("java:comp/env/jdbc/zol");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static  boolean creatingQuery(String query){
        Connection con=null;
        boolean result = false;
        try {
            con = ds.getConnection();
            Statement stm = con.createStatement();
            stm.execute(query);
            logger.log(MainLogger.LEVEL.DEBUG,"query: "+ query + " was successfully invoked");
            result=true;
        } catch (SQLException e) {
            logger.log(MainLogger.LEVEL.WARNING,"There was a problem with the  query: "+ query + ", for more info check the stack trace:\n" + Arrays.toString(e.getStackTrace()));
            return result;
        }
        finally {
            if (con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static  boolean checkingQuery (String query){
        Connection con=null;
        boolean result=false;
        try {
            con = ds.getConnection();
            Statement stm = con.createStatement();
            result  = stm.execute(query);
            logger.log(MainLogger.LEVEL.DEBUG,"query: "+ query + " was successfully invoked with result: "+ result);

        } catch (SQLException e) {
            logger.log(MainLogger.LEVEL.WARNING,"There was a problem with the  query: "+ query + ", for more info check the stack trace:\n" + Arrays.toString(e.getStackTrace()));
        }
        finally {
            if (con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


    public  static ResultSet getResultQuery (String query){
        Connection con=null;
        ResultSet result=null;
        try {
            con = ds.getConnection();
            Statement stm = con.createStatement();
            result  = stm.executeQuery(query);
            logger.log(MainLogger.LEVEL.DEBUG,"query: "+ query + " was successfully invoked with result: "+ result);

        } catch (SQLException e) {
            logger.log(MainLogger.LEVEL.WARNING,"There was a problem with the  query: "+ query + ", for more info check the stack trace:\n" + Arrays.toString(e.getStackTrace()));
        }
        finally {
            if (con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }




}


