public class Quote {
    private String quote;
    private String author;

    public Quote(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quote='" + quote + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}