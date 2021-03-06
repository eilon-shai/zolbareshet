package org.es.zolbareshet.orders;

import org.es.zolbareshet.entities.products.Product;
import org.es.zolbareshet.entities.users.User;
import org.es.zolbareshet.logging.Logger;
import org.es.zolbareshet.logging.LoggerFactory;
import org.es.zolbareshet.queries.QueriesHandler;
import org.es.zolbareshet.queries.SimpleQueryInvoker;
import org.es.zolbareshet.services.Service;
import org.es.zolbareshet.services.ServiceManager;
import org.es.zolbareshet.utilities.Constants;
import org.es.zolbareshet.utilities.PropertiesFileManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Properties;

@ManagedBean
@SessionScoped
public class Cart extends AbstractOrder{

    private  Logger logger;
    private  Properties prop;
    public enum discardCause{USER_CANCELED,EXPIRED,ADMIN_CLOSED,USER_ORDERED};

    public Cart(){
        logger = LoggerFactory.getLogger();
        prop = PropertiesFileManager.getProp();
        ServiceManager.addService( new CartDisposer("cart disposer service"));

    }

    public boolean addProduct(Product p, int quantity) {
        return false;
    }


    public boolean removeProduct(Product p) {
        return false;
    }


    public boolean incrementProductQuantity(Product p, int quantity) {
        return false;
    }


    public boolean decrementProductQuantity(Product p, int quantity) {
        return false;
    }

    public  void discard(String userName , discardCause cause){
        SimpleQueryInvoker.discaradCart(userName);
        logger.log(Logger.LEVEL.DEBUG,"cart of user " + userName + " was removed by: " + cause  );
    }

    private class CartDisposer extends Service{
        private int DAYS_BETWEEN_CART_DISPOSER_RUNS;
        private int CART_EXPIRES_AFTER;
        private boolean keepRunning=true;

        public CartDisposer(String name){
            super(name);
        }

        public void run() {
            while(keepRunning){
               runOnce();
                try {
                    sleep(DAYS_BETWEEN_CART_DISPOSER_RUNS*1000*60*60*24);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public void clean(){
            if (this.isAlive()) {
                keepRunning=false;
                try {
                    this.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("stopping cart disposer service");
            }
        }

        public void runOnce(){
            DAYS_BETWEEN_CART_DISPOSER_RUNS = Integer.parseInt(prop.getProperty(Constants.DAYS_BETWEEN_CART_DISPOSER_RUNS_PROPERTY,"1"));
            CART_EXPIRES_AFTER = Integer.parseInt(prop.getProperty(Constants.CART_EXPIRES_AFTER_PROPERTY,"14"));
            ArrayList<QueriesHandler.ResultLine> userWithCartsList = SimpleQueryInvoker.getAllUsersWithCarts();//list of (userName,cartCreationDate) pairs
            for (QueriesHandler.ResultLine line :  userWithCartsList){
                if (System.currentTimeMillis() - Long.parseLong(line.getContent().get(2)) > CART_EXPIRES_AFTER*1000*60*60*24){ //two weeks
                    discard(line.getContent().get(2), discardCause.EXPIRED);
                }
            }
        }
    }
}


