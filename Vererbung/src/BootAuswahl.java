import java.util.ArrayList;
import java.util.Scanner;

/**
 * Die Klasse BootAuswahl verwaltet eine Liste von Wasserfahrzeugen und ermöglicht es dem Benutzer,
 * Boote hinzuzufügen und auszuwählen. Wenn ein Boot ausgewählt wird, kann der Benutzer Informationen
 * über das Boot anzeigen oder das Boot fahren.
 */
public class BootAuswahl {
    private ArrayList<Wasserfahrzeug> wasserfahrzeuge;
    private Scanner scanner;

    /**
     * Erstellt eine neue Instanz der Klasse BootAuswahl.
     */
    public BootAuswahl() {
        this.wasserfahrzeuge = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Startet das Hauptmenü der Anwendung.
     */
    public void start() {
        label:
        while (true) {
            System.out.println("\nWählen Sie eine Option aus:");
            System.out.println("1: Boot hinzufügen");
            System.out.println("2: Boot auswählen");
            System.out.println("q: Beenden");
            String eingabe = scanner.nextLine();
            switch (eingabe) {
                case "q":
                    break label;
                case "1":
                    bootHinzufuegen();
                    break;
                case "2":
                    bootAuswaehlen();
                    break;
                default:
                    System.out.println("Ungültige Eingabe");
            }
        }
    }

    /**
     * Fügt ein neues Boot zur Liste hinzu.
     */
    private void bootHinzufuegen() {
        System.out.println("\nWählen Sie einen Bootstyp aus:");
        System.out.println("1: Motorboot");
        System.out.println("2: MiniUboot");
        System.out.println("3: Ruderboot");
        System.out.println("4: Tretboot");
        String typ = scanner.nextLine();

        System.out.print("Geben Sie den Namen des Boots ein: ");
        String name = scanner.nextLine();

        double preis = readDouble("Geben Sie den Preis des Boots ein: ");

        Wasserfahrzeug boot;
        switch (typ) {
            case "1" -> {
                int ps = (int) readDouble("Geben Sie die PS des Boots ein: ");
                int sitze = (int) readDouble("Geben Sie die Anzahl der Sitze des Boots ein: ");
                boot = new Motorboot(name, preis, ps, sitze);
            }
            case "2" -> {
                int leistung = (int) readDouble("Geben Sie die Leistung des U-Boots ein: ");
                int tauchtiefe = (int) readDouble("Geben Sie die Tauchtiefe des U-Boots ein: ");
                boot = new MiniUboot(name, preis, leistung, tauchtiefe);
            }
            case "3" -> {
                int sitzplaetze = (int) readDouble("Geben Sie die Anzahl der Sitzplätze des Boots ein: ");
                int ruderAnzahl = (int) readDouble("Geben Sie die Anzahl der Ruder des Boots ein: ");
                boot = new Ruderboot(name, preis, sitzplaetze, ruderAnzahl);
            }
            case "4" -> {
                int sitzplaetzeR = (int) readDouble("Geben Sie die Anzahl der Sitzplätze des Boots ein: ");
                System.out.print("Geben Sie die Anzahl der Pedale des Boots ein: ");
                int pedaleAnzahl = (int) readDouble("Geben Sie die Anzahl der Sitzplätze des Boots ein: ");
                boot = new Tretboot(name, preis, sitzplaetzeR, pedaleAnzahl);
            }
            default -> {
                System.out.println("Ungültige Eingabe");
                return;
            }
        }

        wasserfahrzeuge.add(boot);
    }

    /**
     * Ermöglicht dem Benutzer, ein Boot auszuwählen und Informationen anzuzeigen oder das Boot zu fahren.
     */
    private void bootAuswaehlen() {
        if (wasserfahrzeuge.size() == 0) {
            return;
        }

        System.out.println("\nBitte gewünschtes Boot auswählen:");
        for (int i = 0; i < wasserfahrzeuge.size(); i++) {
            System.out.println(i + ": " + wasserfahrzeuge.get(i).getName());
        }

        int index = Integer.parseInt(scanner.nextLine());
        Wasserfahrzeug f = wasserfahrzeuge.get(index);

        label:
        while (true) {
            System.out.println("\nWählen Sie eine Option für " + f.getName() +" aus:");
            System.out.println("1: Informationen anzeigen");
            System.out.println("2: Fahre");
            System.out.println("q: Zurück zum Hauptmenü\n");
            String eingabe = scanner.nextLine();
            switch (eingabe) {
                case "q":
                    break label;
                case "1":
                    f.zeigeInformationen();
                    System.out.println("\nDrücken Sie Enter um fortzufahren...");
                    scanner.nextLine();
                    break;
                case "2":
                    f.fahre();
                    System.out.println("\nDrücken Sie Enter um fortzufahren...");
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Ungültige Eingabe");
            }
        }
    }
    private double readDouble(String text) {
        while (true) {
            System.out.println(text);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine ganze Zahl ein.");
            }
        }
    }
}
