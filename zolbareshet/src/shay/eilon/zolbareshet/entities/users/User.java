package shay.eilon.zolbareshet.entities.users;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public abstract class User {
    private final int MAXIMUM_NUMBER_OF_PHONES=4;
    private int ID;
    private Name name;
    private Address address;
    private ArrayList<PhoneBean> phonesList;
    private Password password;
    private String nickName;
    private UserInfo userInfo;

    public User(){
        name=new Name();
        address=new Address();
        phonesList = new ArrayList<PhoneBean>();
        addPhone();
        password = new Password();
        userInfo = new UserInfo();
    }

    public User(int ID, Name name, Address address, ArrayList<PhoneBean> phonesList, Password password, String nickName, UserInfo userInfo) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phonesList = phonesList;
        this.password = password;
        this.nickName = nickName;
        this.userInfo = userInfo;
    }

    public void addPhone(){
        if (phonesList.size()<MAXIMUM_NUMBER_OF_PHONES){
            phonesList.add(new PhoneBean());
        }
    }

    public void removePhone(){
        if(phonesList.size()>1){
            phonesList.remove(phonesList.size()-1);
        }
    }

    public ArrayList<PhoneBean> getPhonesList() {
        return phonesList;
    }

    public void setPhonesList(ArrayList<PhoneBean> phonesList) {
        this.phonesList = phonesList;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public Password getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new Password(password);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String toString(){
        return ID + " " + (name!=null?name+" ":"")+(address!=null?address+" ":"")+(userInfo!=null?userInfo+" ":"")+(password!=null?password+" ":"")+(nickName!=null?nickName+" ":"");
    }

   public abstract String register();
}
