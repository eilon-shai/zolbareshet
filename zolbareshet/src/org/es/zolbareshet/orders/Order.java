package org.es.zolbareshet.orders;



import com.sun.xml.internal.bind.v2.TODO;
import org.es.zolbareshet.entities.products.Product;
import org.es.zolbareshet.entities.users.User;
import org.es.zolbareshet.logging.Logger;
import org.es.zolbareshet.logging.LoggerFactory;
import org.es.zolbareshet.queries.QueriesHandler;
import org.es.zolbareshet.utilities.Constants;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.TimeUnit;


@ManagedBean
@SessionScoped
public class Order extends AbstractOrder{

    private long  orderID ;
    private boolean closed = false;
    private static Logger logger = LoggerFactory.getLogger();



    public Order(long orderID, boolean closed, User user, Date date, Map<Product, Integer> orderLines) {
        super(user,date,orderLines);
        this.orderID = orderID;
        this.closed = closed;
    }

    public Order(){

    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public boolean isClosed() {
        return closed;
    }



    public boolean commitOrder() {
        return false;
    }






}
