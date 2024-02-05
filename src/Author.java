import java.util.*;

public class Author extends Person {
    private long id;
    Set<String> books;

    public Author(String name, String surname, long id) {
        super(name, surname);
        this.books = new HashSet<>();
        this.id = id;
    }


    public void addBookToAuthor(Book book) {
        if (this.id == book.getAuthor().getId()) {
            books.add(book.getName());
            System.out.println(book.getName() + " successfully attached to its author");
        } else {
            System.out.println("This book is not belong to the Author");
        }
    }

    public Set<String> getBooks() {
        return this.books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Author {" +
                " name='" + super.getName() + "\n" +
                " surname='" + super.getSurname() + "\n" +
                " books=" + books +
                '}';
    }
}
