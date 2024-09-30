package task4;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();
        sb.append(record.getLevel()).append(": ").append(record.getMessage()).append("\n");

        if (record.getThrown() != null) {
            sb.append("Exception:\n");
            StringWriter sw = new StringWriter();
            record.getThrown().printStackTrace(new PrintWriter(sw));
            sb.append(sw.toString());
        }

        return sb.toString();
    }
}
