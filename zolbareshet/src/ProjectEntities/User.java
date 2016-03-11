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
    
	private String   UserName      ;     
	private String   FirstName     ;  
	private String   LastName      ; 
	private String   Password      ;
	private boolean  IsActive      ; 
	private String   country       ;  
        private String   City          ;  
	private String   Street        ;
	private String   HouseNumber   ;
	private int      ZipCode       ;    
	private String   Email         ;
	private Date     BirthDate     ;  
	private int      UserType      ;
	private int      Gender        ;  

    public User() {
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String toString(){
      return FirstName + " "  + LastName;
    }
  }
}
