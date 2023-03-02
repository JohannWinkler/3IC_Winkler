/**
 * Klasse für Ruderboote
 */
public class Ruderboot extends RuderTretboot {
    private final int rudernAnzahl;

    public Ruderboot(String name, double preis, int sitzplaetze, int rudernAnzahl) {
        super(name, preis, sitzplaetze);
        this.rudernAnzahl = rudernAnzahl;
    }

    @Override
    public void zeigeInformationen() {
        super.zeigeInformationen();
        System.out.println("Rudern Anzahl: " + rudernAnzahl);
    }

    @Override
    public void fahre() {
        System.out.println("Das Ruderboot " + name + " wird mit " + rudernAnzahl + " Rudern bewegt.");
    }
}