/**
 * Klasse für Motorboote
 */
public class Motorboot extends Motorisiert {
    private final int sitzplaetze;

    public Motorboot(String name, double preis, int leistung, int sitzplaetze) {
        super(name, preis, leistung);
        this.sitzplaetze = sitzplaetze;
    }

    @Override
    public void zeigeInformationen() {
        super.zeigeInformationen();
        System.out.println("Sitzplätze: " + sitzplaetze);
    }

    @Override
    public void fahre() {
        System.out.println("Das Motorboot " + name + " fährt mit einer Geschwindigkeit von " + leistung * 0.5 + " km/h.");
    }
}