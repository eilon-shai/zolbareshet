package shay.eilon.zolbareshet.entities.users;

/**
 * Created by eilons on 2/23/2016.
 */
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
