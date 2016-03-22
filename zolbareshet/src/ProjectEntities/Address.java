//package shay.eilon.zolbareshet.entities.users;
package  ProjectEntities;
import ProjectEntities.RunQuery;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Arrays;
import java.util.List;


@ManagedBean
@SessionScoped
public class Address {
    private String Country;
    private String City;
    private String Street;
    private String HouseNumber;
    private int  ZipCode;
    //private List<String> countries;



    public Address(String country, String city, String street,  String houseNumber, int zipCode) {
        Country = country;
        City = city;
        Street = street;
        HouseNumber = houseNumber;
        ZipCode = zipCode;
    }


    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        this.Street = street;
    }


    public int getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        this.ZipCode = ZipCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(String country) {
        this.Country = HouseNumber;
    }
    
    public void GetCountries () 
    {
        RunQuery.GetCountries();
    }
    

public String toString(){
    return Country+" "+City+" "+Street+" " + HouseNumber + " " + ZipCode   ;  
}


}