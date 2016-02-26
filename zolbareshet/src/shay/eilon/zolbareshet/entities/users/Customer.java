package shay.eilon.zolbareshet.entities.users;

import shay.eilon.zolbareshet.payments.CreditCard;
import shay.eilon.zolbareshet.reservations.Chart;

import java.util.ArrayList;

/**
 * Created by eilons on 2/23/2016.
 */
public class Customer extends User {
    private CreditCard creditCard;
    private Chart chart;

    public Customer(){
        super();
        creditCard=new CreditCard();
        chart=new Chart();
    }
    public Customer(int ID, Name name, Address address, ArrayList<Phone> phoneNumbers, Password password, String nickName, UserInfo userInfo, CreditCard creditCard, Chart chart) {
        super(ID, name, address, phoneNumbers, password, nickName, userInfo);
        this.creditCard = creditCard;
        this.chart = chart;
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
}
