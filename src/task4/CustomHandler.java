package task4;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class CustomHandler extends Handler {
    @Override
    public void publish(LogRecord record) {
         if (record.getLevel().intValue()>= Level.SEVERE.intValue()){
             System.out.println(getFormatter().format(record));
         }
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}
