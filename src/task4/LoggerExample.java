package task4;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerExample {
    public static void main(String[] args) {
        Logger logger=Logger.getLogger(LoggerExample.class.getName());
        CustomHandler customHandler=new CustomHandler();
        CustomFormatter customFormatter=new CustomFormatter();
        customHandler.setFormatter(customFormatter);
        logger.addHandler(customHandler);
        logger.setLevel(Level.ALL);
       logger.fine("Bu Fine darajasidagi log..............");
       logger.info("Bu INFO darajasidagi log..............");
       logger.warning("Bu WARNING darajasidagi log........");
       logger.severe("Bu SEVERE darajasidagi log..........");
       try {
           throw new Exception("Bu xato!!!");
       }catch (Exception e){
           logger.log(Level.SEVERE,"Xatolik yuz berdi",e);
       }
    }
}
