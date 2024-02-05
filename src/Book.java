
public class Book extends Publish {
    private Author author;
    private BookGenre type;

    public Book(String name, Author author, long serialNumber, int pageCount, String publisher, BookGenre type,
            Language language) {
        super(name, serialNumber, pageCount, publisher, language);
        this.author = author;
        this.type = type;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookGenre getType() {
        return type;
    }

    public void setType(BookGenre type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + super.getName() + ',' + "\n" +
                " serialNumber=" + super.getSerialNumber() + ',' + "\n" +
                " pageCount=" + super.getPageCount() + ',' + "\n" +
                " publisher='" + super.getPublisher() + ',' + "\n" +
                " language=" + super.getLanguage() + ',' + "\n" +
                " author=" + this.author + ',' + "\n" +
                " type=" + this.type +
                '}';
    }

}
