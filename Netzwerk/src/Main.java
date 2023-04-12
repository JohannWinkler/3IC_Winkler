public class Main {
    public static void main(String[] args) {
        Lookup lookup = new Lookup();
        lookup.myLookup("google.at");
        lookup.myLookup("136.243.66.151");
        lookup.myLookup("cccsbg.at");
        lookup.myLookup("caaaa");
        lookup.saveHosts("hosts.ser");
        lookup.loadHosts("hosts.ser");
    }
}
