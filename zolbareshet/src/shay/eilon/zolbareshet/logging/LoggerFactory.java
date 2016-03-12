package shay.eilon.zolbareshet.logging;

/**
 * Created by eilons on 3/9/2016.
 */
public class LoggerFactory {
    public static Logger logger;
    public static Logger getLogger(){
        if(logger==null){
           logger=Logger.createLogger();
        }
        return logger;
    }
}
