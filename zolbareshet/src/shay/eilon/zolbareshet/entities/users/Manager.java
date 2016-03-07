package shay.eilon.zolbareshet.entities.users;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;


@ManagedBean
public class Manager extends User{

    private String[] roles;
    public Manager(){
        super();
    }

    public Manager(int ID, Name name, Address address, ArrayList<PhoneBean> phoneNumbers, Password password, String nickName, UserInfo userInfo, String[] roles) {
        super(ID, name, address, phoneNumbers, password, nickName, userInfo);
        this.roles = roles;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String register(){
        return "";
    }

}
