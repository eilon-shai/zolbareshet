package org.es.zolbareshet.queries;

import org.es.zolbareshet.utilities.Constants;

import java.util.ArrayList;

/**
 * Created by eilons on 4/3/2016.
 */
public class  SimpleQueryInvoker {

    public static final ArrayList<QueriesHandler.ResultLine> GET_ALL_USERS_WITH_CARTS = //return (username,cartCreationDate) pairs
            QueriesHandler.qHandler(Constants.GET_ALL_USERS_WITH_CARTS_QUERY, null,new Parameter.TYPE[]{Parameter.TYPE.STRING, Parameter.TYPE.LONG});

    public static void discaradCart(String username){
          QueriesHandler.updateQuery(Constants.DELETE_USER_CART_QUERY,new Parameter[]{new Parameter(username,1, Parameter.TYPE.STRING)});

    }

    public static ArrayList<QueriesHandler.ResultLine> getAllCountries(){
        return QueriesHandler.qHandler(Constants.GET_ALL_COUNTRIES_QUERY,null, new Parameter.TYPE[]{Parameter.TYPE.STRING});
    }

}
