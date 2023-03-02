/**
 * Abstrakte Klasse für motorisierte Wasserfahrzeuge
 */
public abstract class Motorisiert extends Wasserfahrzeug {
    protected int leistung;

    public Motorisiert(String name, double preis, int leistung) {
        super(name, preis);
        this.leistung = leistung;
    }

    @Override
    public void zeigeInformationen() {
        System.out.println("Name: " + name);
        System.out.println("Preis: " + preis);
        System.out.println("Leistung: " + leistung);
    }
}