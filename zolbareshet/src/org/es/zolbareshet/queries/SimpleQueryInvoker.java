package org.es.zolbareshet.queries;

import org.es.zolbareshet.entities.users.UserBean;
import org.es.zolbareshet.utilities.Constants;

import java.util.ArrayList;


public class  SimpleQueryInvoker {

    public static  ArrayList<QueriesHandler.ResultLine> getAllUsersWithCarts() { //return (username,cartCreationDate) pairs
          return  QueriesHandler.qHandler(Constants.GET_ALL_USERS_WITH_CARTS_QUERY, null,new Parameter.TYPE[]{Parameter.TYPE.STRING, Parameter.TYPE.LONG});}

    public static void discaradCart(String username){
          QueriesHandler.updateQuery(Constants.DELETE_USER_CART_QUERY,new Parameter[]{new Parameter(username,1, Parameter.TYPE.STRING)});
    }

    public static ArrayList<QueriesHandler.ResultLine> getAllCountries(){
        return QueriesHandler.qHandler(Constants.GET_ALL_COUNTRIES_QUERY,null, new Parameter.TYPE[]{Parameter.TYPE.STRING});
    }

    public static boolean IsSuperUser(String username){
        return true;
    }

    public static ArrayList<QueriesHandler.ResultLine> getAllSuperUsers(){
        return QueriesHandler.qHandler(Constants.GET_ALL_SUPER_USERS_QUERY,null,new Parameter.TYPE[]{Parameter.TYPE.STRING,Parameter.TYPE.STRING});//return (username,phonenumber) pairs
    }
    public static ArrayList<String> getUserDetails(String username){
        ArrayList<QueriesHandler.ResultLine> res = QueriesHandler.qHandler(Constants.GET_SUPERUSER_FIELDS,new Parameter[]{new Parameter(username,1, Parameter.TYPE.STRING)},
                new Parameter.TYPE[]{Parameter.TYPE.STRING, Parameter.TYPE.STRING, Parameter.TYPE.STRING, Parameter.TYPE.STRING, Parameter.TYPE.STRING, Parameter.TYPE.INT});
        ArrayList<QueriesHandler.ResultLine> phones = QueriesHandler.qHandler(Constants.GET_ALL_USER_PHONES,new Parameter[]{new Parameter(username,1, Parameter.TYPE.STRING)},
                new Parameter.TYPE[]{Parameter.TYPE.STRING, Parameter.TYPE.STRING, Parameter.TYPE.STRING, Parameter.TYPE.INT});

       ArrayList<String> result =  res.get(0).getContent();
        for(QueriesHandler.ResultLine r: phones){
            result.addAll(r.getContent());
        }
        return result;

    }
    public static boolean checkIfUserNicknameAlreadyExists(String name){
        return false;
    }
    public static boolean checkIfUserEmailAlreadyExists(String mail){
        return false;
    }
    public static boolean createNewUser(UserBean user){
        return true;
    }
}
