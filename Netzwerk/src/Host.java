import java.io.Serializable;

class Host implements Serializable {
    private String hostname;
    private String ipAddress;

    public Host(String hostname, String ipAddress) {
        this.hostname = hostname;
        this.ipAddress = ipAddress;
    }

    public String getHostname() {
        return hostname;
    }

    public String getIpAddress() {
        return ipAddress;
    }
}