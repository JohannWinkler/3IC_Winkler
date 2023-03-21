import java.util.Vector;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Vector<Integer> buffer = new Vector<Integer>(); // gemeinsam genutzter Puffer
    private static final int BUFFER_SIZE = 10; // maximale Größe des Puffers
    private static volatile boolean producerRunning = true; // Status-Flag für den Erzeuger-Thread

    public static void main(String[] args) {
        // Erzeuger-Thread starten
        Thread producerThread = new Thread(() -> {
            Random random = new Random();
            while (producerRunning) {
                synchronized (buffer) {
                    // Wenn der Puffer voll ist, warten
                    while (buffer.size() == BUFFER_SIZE) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // Zufallszahl erzeugen und in den Puffer einfügen
                    int number = random.nextInt(101);
                    buffer.add(number);
                    System.out.println("Erzeugt: " + number);
                    buffer.notify(); // Verbraucher-Thread benachrichtigen
                }
                // Pause einlegen
                try {
                    Thread.sleep(random.nextInt(1001));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producerThread.start();

        // Verbraucher-Thread starten
        Thread consumerThread = new Thread(() -> {
            Random random = new Random();
            while (true) {
                synchronized (buffer) {
                    // Wenn der Puffer leer ist, warten
                    while (buffer.isEmpty()) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // Nächste Zahl aus dem Puffer entfernen und ausgeben
                    int number = buffer.remove(0);
                    System.out.println("Verbraucht: " + number);
                    // Wenn die maximale Anzahl an Zahlen pro Zeile erreicht ist, eine neue Zeile beginnen
                    if (buffer.size() % 10 == 0) {
                        System.out.println();
                    }
                    buffer.notify(); // Erzeuger-Thread benachrichtigen
                }
                // Pause einlegen
                try {
                    Thread.sleep(random.nextInt(1001));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        consumerThread.start();

        // Tastatureingabe verarbeiten
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("s")) {
                producerRunning = false;
            } else if (input.equals("c")) {
                producerRunning = true;
                synchronized (buffer) {
                    buffer.notifyAll(); // alle Threads benachrichtigen
                }
            }
        }
    }
}