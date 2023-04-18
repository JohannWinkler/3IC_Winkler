import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInput;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.BreakIterator;
import java.text.ParseException;
import java.time.LocalDateTime;

public class SendMessage {
    private static final int BUFSIZE = 508;

    public static void main(String[] args) throws ParseException {
        String host = "localhost";
        int port = 50000;
        Message msg = new Message("LBS4-User", LocalDateTime.now(), "Das ist ein Test");
        String message = serialize(msg);
        Quote receivedMessage;

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress addr = InetAddress.getByName(host);
            DatagramPacket packet = new DatagramPacket(new byte[BUFSIZE], BUFSIZE, addr, port);
            byte[] data = message.getBytes();
            packet.setData(data);
            packet.setLength(data.length);
            socket.send(packet);

            packet = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
            socket.receive(packet);
            String jsonData = new String(packet.getData(), 0, packet.getLength());
            receivedMessage = deserialize(jsonData);

            System.out.println("\nQuote: " + receivedMessage.getQuote());
            System.out.println("Author: " + receivedMessage.getAuthor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Quote deserialize(String data) {
        ObjectMapper mapper = new ObjectMapper();
        Quote message = new Quote();
        try {
            message = mapper.readValue(data, Quote.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return message;
    }

    private static String serialize(Message msg) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(msg);
            System.out.println(json);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}