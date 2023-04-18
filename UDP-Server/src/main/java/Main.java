import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int BUFSIZE = 508;
    private static List<Quote> quotes = new ArrayList<>();

    public static void main(String[] args) {
        int port = 50000;
        Message message;
        loadQuotes();

        try (DatagramSocket socket = new DatagramSocket(port)) {
            DatagramPacket packet = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);

            while (true) {
                System.out.println("\n<><><><><><><><><><><><><><><><><><><><><><><><><><><>");
                // Message received
                socket.receive(packet);
                String data = new String(packet.getData(), 0, packet.getLength());
                message = deserialize(data);
                System.out.println("\nUser: " + message.getUser());
                System.out.println("Timestamp: " + message.getTimestamp());
                System.out.println("Message: " + message.getMessage() + "\n");

                // Quote Sent
                Quote quote = getRandomQuote();
                String json = serialize(quote);
                packet.setData(json.getBytes());
                packet.setLength(json.getBytes().length);
                socket.send(packet);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static void loadQuotes() {
        try (BufferedReader br = new BufferedReader(new FileReader("zitate.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");
                Quote quote = new Quote(parts[0], parts[1]);
                quotes.add(quote);
            }
            System.out.println(quotes.size() + " Zitate gefunden.");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static Quote getRandomQuote() {
        Random random = new Random();
        return quotes.get(random.nextInt(quotes.size()));
    }

    private static Message deserialize(String data) {
        ObjectMapper mapper = new ObjectMapper();
        Message message = new Message();
        try {
            message = mapper.readValue(data, Message.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return message;
    }

    private static String serialize(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(obj);
            System.out.println(json);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}