package shay.eilon.zolbareshet.entities.users;

/**
 * Created by eilons on 2/23/2016.
 */
public abstract class User {
    private int ID;
    private Name name;
    private Address address;
    private Phone[] phoneNumbers;
    private Password password;
    private String nickName;
    private UserInfo userInfo;


    public User(int ID, Name name, Address address, Phone[] phoneNumbers, Password password, String nickName, UserInfo userInfo) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.password = password;
        this.nickName = nickName;
        this.userInfo = userInfo;
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

    public Phone[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Phone[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
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
}
