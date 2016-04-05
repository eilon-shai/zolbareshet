package org.es.zolbareshet.entities.users;



import org.es.zolbareshet.JsfHelpers.helpers.ManagerPageNavigation;
import org.es.zolbareshet.payments.CreditCard;
import org.es.zolbareshet.logging.MainLogger;
import org.es.zolbareshet.queries.QueriesHandler;
import org.es.zolbareshet.orders.Cart;
import org.es.zolbareshet.queries.SimpleQueryInvoker;
import org.es.zolbareshet.utilities.Constants;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;



@ManagedBean
@SessionScoped
public class UserBean extends User {
    private CreditCard creditCard;
    private Cart cart;
    private Role role;
    private boolean nickNameAlreadyExists=false;
    private boolean emailAlreadyExists=false;
    public enum Role {ADMINISTRATOR,STOREKEEPER,CUSTOMER};


    public UserBean(){
        super();
        role = Role.CUSTOMER;
    }
    public UserBean(Name name, AddressBean addressBean, ArrayList<PhoneBean> phoneNumbers, Password password, String nickName, UserInfo userInfo, CreditCard creditCard, Cart cart) {
        super( name, addressBean, phoneNumbers, password, nickName, userInfo);
        this.creditCard = creditCard;
        this.cart = cart;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String register(){
        if (SimpleQueryInvoker.checkIfUserNicknameAlreadyExists(getNickName())) {
           if (SimpleQueryInvoker.checkIfUserEmailAlreadyExists(getUserInfo().getMailAddress())) {
                if (SimpleQueryInvoker.createNewUser(this)){
                    getLogger().log(MainLogger.LEVEL.INFO, "user " + getName() + " was successfully registered");
                } else {
                    getLogger().log(MainLogger.LEVEL.WARNING, "user " + getName() + " was unable to register, seek for relevant exceptions in the log for more details");
                }
            } else {
                emailAlreadyExists = true;
                return Constants.REGISTRATION_PAGE;
            }
        }
        else {
            nickNameAlreadyExists = true;
            return Constants.REGISTRATION_PAGE;
        }
    //success registration
        clearCustomer();
            return  Constants.MAIN_PAGE;


}

    private void clearCustomer(){
        super.clearUser();
        nickNameAlreadyExists=false;
        emailAlreadyExists=false;
        cart=null;
        creditCard=null;
    }

    public boolean isNickNameAlreadyExists() {
        return nickNameAlreadyExists;
    }

    public void setNickNameAlreadyExists(boolean nickNameAlreadyExists) {
        this.nickNameAlreadyExists = nickNameAlreadyExists;
    }

    public boolean isEmailAlreadyExists() {
        return emailAlreadyExists;
    }

    public void setEmailAlreadyExists(boolean emailAlreadyExists) {
        this.emailAlreadyExists = emailAlreadyExists;
    }

    public  ArrayList<String> getRoles(){
        ArrayList<String> roles = new ArrayList<>();
        for(Role r:Role.values()){
            if(r!=Role.CUSTOMER) {
                roles.add(r.toString());
            }
        }
        return roles;
    }
    /*public void editSuperUser(String userName){
        ArrayList<String> userDetails = SimpleQueryInvoker.getUserDetails(userName);
        setNickName(userDetails.get(0));
        ManagerPageNavigation.changeContext(ManagerPageNavigation.EDIT_USER);
    }*/
}
