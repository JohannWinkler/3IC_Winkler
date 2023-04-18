import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private String user;
    private String timestamp;
    private String message;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Message(String user, LocalDateTime timestamp, String message) throws ParseException {
        this.user = user;
        this.timestamp = timestamp.format(formatter);
        this.message = message;
    }

    public Message() {}

    public String getUser() {
        return user;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public String getMessage() {
        return message;
    }
}
