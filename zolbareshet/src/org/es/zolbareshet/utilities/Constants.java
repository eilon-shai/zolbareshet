package org.es.zolbareshet.utilities;

import org.es.zolbareshet.queries.QueriesHandler;

/**
 * Created by eilons on 3/7/2016.
 */
public class Constants {

    //------------config file--------------------------

    public static final String PROPERTY_FILE_NAME = "config.properties";
    public static final String  LOG_FILE_NAME_PROPERTY = "log-file-name";
    public static final String DEBUGGING_LEVEL_PROPERTY ="debugging-level";
    public static final String USER_NAME_PROPERTY ="user-name";
    public static final String ENCRYPTED_PASSWORD_PROPERTY ="encrypted-password";
    public static final String PORT_PROPERTY = "port";
    public static final String DAYS_BETWEEN_CART_DISPOSER_RUNS_PROPERTY = "days-between-cart-disposer";

    //--------QUERIES------------------------------------

    public static final String CHECKING_NEW_USER_NICKNAME_REGISTRATION_QUERY="";
    public static final String CHECKING_NEW_USER_EMAIL_REGISTRATION_QUERY="";
    public static final String ADD_NEW_USER_QUERY="";
    public static final String GET_ALL_COUNTRIES_QUERY= "SELECT * FROM countries ORDER BY countriename ASC" ;
    public static final String DELETE_USER_CART_QUERY ="";
    public static final String GET_ALL_USERS_WITH_CARTS_QUERY = "";


    //--------------DATABASE FIELDS-----------------------

    public static final String ORDERID_FIELD ="";
    public static final String CATEGORY_NAME_FIELD ="";
    public static final String COUNTRY_NAME_FIELD="countriename";
    public static final int COUNTRY_NAME_FIELD_INDEX=1;


    //--------------DATABASE TABLES------------------------

    public static final String ORDERS_TABLE ="";
    public static final String CATEGORY_TABLE ="";
    public static final String COUNTRIES_TABLE="countries";

    //-------------INDEX TABLE------------------------------

    public static final int USER_TABLE_FIRST_NAME_COLUMN = 1;

    //--------------QueryHandlers--------------------------------------


    //--------------PAGES NAMES---------------------------
    public static final String REGISTRATION_PAGE="accounting/registration";
    public static final String HOME_PAGE="result";
    public static final String MANAGEMENT_PAGE="management/management";

    //--------------orders--------------------------------
    public static final long ORDER_EXPIRE_AFTER = 1000*60*60*24*14; //two weeks



}
