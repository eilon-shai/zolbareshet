package shay.eilon.zolbareshet.entities.users;

import java.util.Date;

/**
 * Created by eilons on 2/23/2016.
 */
public class UserInfo {
    public enum gender{MALE,FEMALE};
    public enum state {MARRIED,DEVORCED,SINGLE};
    private gender userGender;
    private Date birthDate;
    private state familyState;
    private String mailAddress;

    public UserInfo(){
        this(null,null,null,null);
    }

    public UserInfo(gender userGender, Date birthDate, state familyState, String mailAddress) {
        this.userGender = userGender;
        this.birthDate = birthDate;
        this.familyState = familyState;
        this.mailAddress=mailAddress;
    }

    public gender getUserGender() {
        return userGender;
    }

    public void setUserGender(gender userGender) {
        this.userGender = userGender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public state getFamilyState() {
        return familyState;
    }

    public void setFamilyState(state familyState) {
        this.familyState = familyState;
    }
}
