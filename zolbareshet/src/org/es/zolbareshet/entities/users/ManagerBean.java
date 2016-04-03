package org.es.zolbareshet.entities.users;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;


@ManagedBean
public class ManagerBean extends CustomerBean{
    private String role;

    private String[] roles = {"ADMINISTRATOR","STOREKEEPER"};


    public String[] getRoles() {
        return roles;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public void addPhone(){
        if (getPhonesList().size()<2){
            getPhonesList().add(new PhoneBean());
        }
    }
}
