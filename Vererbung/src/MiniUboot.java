/**
 * Klasse für Mini-Uboote
 */
public class MiniUboot extends Motorisiert {
    private final int tauchtiefe;

    public MiniUboot(String name, double preis, int leistung, int tauchtiefe) {
        super(name, preis, leistung);
        this.tauchtiefe = tauchtiefe;
    }

    @Override
    public void zeigeInformationen() {
        super.zeigeInformationen();
        System.out.println("Tauchtiefe: " + tauchtiefe);
    }

    @Override
    public void fahre() {
        System.out.println("Das Mini-Uboot " + name + " taucht auf eine Tiefe von " + tauchtiefe + " Metern.");
    }
}