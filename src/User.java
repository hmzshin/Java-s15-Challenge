import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class User extends Person {

    private String phone;
    private String password;
    private Address address;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private final String registerDate;
    Map<DatesRecord, Book> booksBorrowedBefore;
    Map<Book, DatesRecord> assignedBooks;

    public User(String name, String surname, String phone, String password, Address address) {
        super(name, surname);
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.registerDate = dtf.format(LocalDateTime.now());
        this.assignedBooks = new HashMap<>();
        this.booksBorrowedBefore = new TreeMap<>();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public String borrowBook(Book book) {
        if (this.assignedBooks.containsKey(book)) {
            System.out.println("You already take this book.");
            return "You already take this book.";
        }
        if (this.assignedBooks.size() >= Constants.userLimit) {
            System.out.println("You reached your limit, To take book please give back one of other books.");
            return "You reached your limit, To take book please give back one of other books.";
        }
        if (Librarian.numberOfBooksLeft(book) < 1) {
            System.out.println("We regret to inform you that there are no copies of this book left in the inventory.");
            return "We regret to inform you that there are no copies of this book left in the inventory.";
        }

        this.assignedBooks.put(book, new DatesRecord());
        System.out.println("The book successfully taken");
        Librarian.updateBookCount(book, -1);
        return "Book successfully taken.";

    }

    public String giveBookBack(Book book) {
        if (!this.assignedBooks.containsKey(book)) {
            System.out.println("This book did not assigned to user: " + super.getName());
            return "This book did not assigned to user: " + super.getName();
        }

        DatesRecord dates = this.assignedBooks.get(book);
        dates.setGiveBackDate();
        this.booksBorrowedBefore.put(dates, book);
        assignedBooks.remove(book);
        Librarian.updateBookCount(book, +1);
        return "The book successfully given back";

    }

    public Map<DatesRecord, Book> getHistory() {
        return this.booksBorrowedBefore;
    }

    public Map<Book, DatesRecord> getCurrentlyTakenBooks() {
        return this.assignedBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone);
    }

    @Override
    public String toString() {
        return " {" +
                " name='" + super.getName() + "\n" +
                " surname='" + super.getSurname() + "\n" +
                " phone='" + phone + "\n" +
                " password='" + password + "\n" +
                " address=" + address +
                '}';

    }

}