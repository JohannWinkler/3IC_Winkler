/**
 * Klasse für Tretboote
 */
public class Tretboot extends RuderTretboot {
    private final int pedaleAnzahl;

    public Tretboot(String name, double preis, int sitzplaetze, int pedaleAnzahl) {
        super(name, preis, sitzplaetze);
        this.pedaleAnzahl = pedaleAnzahl;
    }

    @Override
    public void zeigeInformationen() {
        super.zeigeInformationen();
        System.out.println("Pedale Anzahl: " + pedaleAnzahl);
    }

    @Override
    public void fahre() {
        System.out.println("Das Tretboot " + name + " wird mit " + pedaleAnzahl + " Pedalen bewegt.");
    }
}