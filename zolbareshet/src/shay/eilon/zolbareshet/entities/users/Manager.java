package shay.eilon.zolbareshet.entities.users;

/**
 * Created by eilons on 2/24/2016.
 */
public class Manager extends User{

    private String[] roles;

    public Manager(int ID, Name name, Address address, Phone[] phoneNumbers, Password password, String nickName, UserInfo userInfo, String[] roles) {
        super(ID, name, address, phoneNumbers, password, nickName, userInfo);
        this.roles = roles;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
