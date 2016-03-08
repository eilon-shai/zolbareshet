package shay.eilon.zolbareshet.entities.users;


import com.esotericsoftware.minlog.Log;
import shay.eilon.zolbareshet.logging.Logger;
import shay.eilon.zolbareshet.payments.CreditCard;
import shay.eilon.zolbareshet.reservations.Chart;
import static shay.eilon.zolbareshet.logging.Logger.*;//
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;



@ManagedBean
@SessionScoped
public class Customer extends User {
    private CreditCard creditCard;
    private Chart chart;
    private Logger l= new Logger();

    public Customer(){
        super();
    }
    public Customer(int ID, Name name, Address address, ArrayList<PhoneBean> phoneNumbers, Password password, String nickName, UserInfo userInfo, CreditCard creditCard, Chart chart) {
        super(ID, name, address, phoneNumbers, password, nickName, userInfo);
        this.creditCard = creditCard;
        this.chart = chart;
    }

    public Logger getL() {
        return l;
    }

    public void setL(Logger l) {
        this.l = l;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Chart getChart() {
        return chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }

    public String register(){
        l.log(Logger.LEVEL.INFO,"TESTING");
        l.log(LEVEL.DEBUG,"debug testing");
        return"";
    }


}
