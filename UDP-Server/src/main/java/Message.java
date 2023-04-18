import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    private String user;
    private String timestamp;
    private String message;

    public Message() {
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "user : " + user + " timestamp : " + timestamp + " message : " + message;
    }
}

