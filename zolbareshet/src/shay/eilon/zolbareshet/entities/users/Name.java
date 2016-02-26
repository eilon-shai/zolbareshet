package shay.eilon.zolbareshet.entities.users;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
    public Name(){
        this(null,null,null);
    }
    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    public Name(String firstName, String lastName) {
        this(firstName,null,lastName);
    }
}
