package shay.eilon.zolbareshet.entities.users;

/**
 * Created by eilons on 2/23/2016.
 */
public class Phone {

    public enum phoneType {HOME,WORK,CELOLAR};
    private String perfix;
    private String phoneNumber;
    private phoneType type;

    public Phone(String perfix, String phoneNumber, phoneType type) {
        this.perfix = perfix;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public String getPerfix() {
        return perfix;
    }

    public void setPerfix(String perfix) {
        this.perfix = perfix;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public phoneType getType() {
        return type;
    }

    public void setType(phoneType type) {
        this.type = type;
    }
}
