public class Quote {
    private String quote;
    private String author;

    public Quote(String text, String author) {
        this.quote = text;
        this.author = author;
    }

    public Quote(){}

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }
}