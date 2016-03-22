/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEntities;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author peretzs
 */
    

@ManagedBean
public class User implements Serializable{
    
	private String       UserName      ;     
	private String       FirstName     ;  
	private String       LastName      ; 
	private String       Password      ;
	private boolean      IsActive      ;
        private PhoneNumber  PhoneNumbers  ;
        private Address      Address       ;
	private String       Email         ;
	private date         BirthDate     ;  
	private int          UserType      ;
	private int          Gender        ;  
     

    public User() {
    }

    public User (String userName ,String firstName , String lastName , String password , boolean isActive , PhoneNumber  phoneNumbers , Address address , String email , date birthDate ,int userType, int gender )
    {
        UserName     = userName     ; 
        FirstName    = firstName    ; 
        LastName     = lastName     ; 
        Password     = password     ;
        IsActive     = isActive     ; 
        PhoneNumbers = phoneNumbers ; 
        Address      = address      ; 
        Email        = email        ;
        BirthDate    = birthDate    ;
        UserType     = userType     ;
        Gender       = gender       ;
        
        System.out.println("Date : )"  + this.BirthDate);
                                
                        
    }
    public String getUserName() {
    return UserName;
    }
    
    public String getFirstName() {
    return FirstName;
    }

    public String getLastName() {
    return LastName;
    }
    
    public String getPassword() {
    return Password;
    }
    
    public boolean getIsActive() {
    return IsActive;
    }
    
    public PhoneNumber getPhoneNumber()
    {
      return PhoneNumbers ; 
    }
    
    public Address getAddress()
    {
      return Address ; 
    }
    
    public String getEmail()
    {
      return Email ; 
    }
    
    public date getBirthDate()
    {
      return this.BirthDate ; 
    }
    public String toStringBirthDate()
    {
      return BirthDate.getDate()  ; 
    }
    
    public int getUserType()
    {
      return UserType ; 
    }
    
    public int getGender()
    {
      return Gender ; 
    }
    
    
    //set mathods 
    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }


    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String toString(){
      return this.FirstName + " "  + this.LastName;
    }
    
 
    
  }

