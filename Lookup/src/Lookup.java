import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Vector;
import java.io.*;

public class Lookup {
    private Vector<Host> hosts;

    public Lookup() {
        this.hosts = new Vector<Host>();
    }

    public void myLookup(String name) {
        try {
            InetAddress[] addresses = InetAddress.getAllByName(name);
            for (InetAddress address : addresses) {
                System.out.println(address);
                this.hosts.add(new Host(address.getHostName(), address.getHostAddress()));
                System.out.println("IP Adresse eingegeben: " + validate(name));
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + name);
        }
    }

    private static boolean validate(final String ip) {
        String PATTERN = "\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b";
        return ip.matches(PATTERN);
    }

    public void saveHosts(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.hosts);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void loadHosts(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.hosts = (Vector<Host>) in.readObject();
            System.out.println("\n" + this.hosts + "\n");
            for (Host host : hosts) {
                System.out.println("Hostname: " + host.getHostname());
                System.out.println("IP-Address: " + host.getIpAddress());
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.err.println("Class not found");
            c.printStackTrace();
        }
    }
}