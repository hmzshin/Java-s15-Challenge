import java.util.*;

public class Librarian extends Person {

    private long id;
    private String password;
    private Address address;
    private final static Map<Book, Integer> books = new HashMap<>();
    private final static Set<User> users = new HashSet<>();

    public static Map<Book, Integer> getBooks() {
        return books;
    }

    public static void printBooks() {
        System.out.println("Books: ");
        for (Book book : books.keySet()) {
            System.out.println("Book: " + book + " Count: " + books.get(book));
            System.out.println("****** another book *****");
        }
    }

    public static Set<User> getUsers() {
        return users;
    }

    public Librarian(String name, String surname, long id, String password, Address address) {
        super(name, surname);
        this.id = id;
        this.password = password;
        this.address = address;
    }

    public static void addBook(Book book, int count) {
        if (books.containsKey(book)) {
            System.out.println(
                    "This book is already registered to library, Please call updateBookCount method to update number of book.");
        } else {
            books.put(book, count);
            Author author = book.getAuthor();
            author.addBookToAuthor(book);
            System.out.println("The book is successfully added to library");
        }

    }

    public static void removeBook(Book book, int count) {
        boolean isBorrowed = false;
        for (User user : users) {
            if (user.assignedBooks.containsKey(book)) {
                isBorrowed = true;
                break;
            }
        }
        if (isBorrowed) {
            System.out.println("This book is assigned to a user. Can not remove from library");
        } else {
            books.remove(book);
            System.out.println("The book is successfully added to library");
        }

    }

    public static void updateBookCount(Book book, int count) {
        if (!books.containsKey(book)) {
            System.out.println("This book is not registered.Please add the book first.");
            return;
        }
        if (count < 0 && numberOfBooksLeft(book) + count < 0) {
            System.out.println("Number of copy left in the library: " + numberOfBooksLeft(book)
                    + " Can not delete more books then existing.");
            return;
        }

        books.put(book, numberOfBooksLeft(book) + count);
        System.out.println("The book count is successfully updated ");

    }

    public static void updateBookDetails(Book bookToUpdate, Book updatedBook) {
        if (!books.containsKey(bookToUpdate)) {
            System.out.println("This book is not registered.Please add the book first.");
            return;
        }
        if (!bookToUpdate.equals(updatedBook)) {
            System.out.println("Book's serial numbers must be equal");
            return;
        }
        int number = books.get(bookToUpdate);
        books.remove(bookToUpdate);
        books.put(updatedBook, number);
        System.out.println("The book successfully updated ");

    }

    public static void addUser(User user) {
        if (users.contains(user)) {
            System.out.println("The user with given phone number is already registered");
            return;
        }
        users.add(user);
        System.out.println("The user successfully registered");

    }

    public static void deleteUser(User user) {
        if (!user.getCurrentlyTakenBooks().isEmpty()) {
            System.out.println("To delete the user, first user need to give back all the books.");
            return;
        }
        if (!users.contains(user)) {
            System.out.println("There is no such user.");
            return;
        }
        users.remove(user);
        System.out.println("The user is successfully deleted from library.");
    }

    public static Book searchBySerialNumber(long serialNumber) {
        Book book = null;
        for (Book key : books.keySet()) {
            if (key.getSerialNumber() == serialNumber) {
                book = key;
                break;
            }
        }

        return book;
    }

    public static List<Book> searchByName(String string) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book key : books.keySet()) {
            if (key.getName().equals(string) || key.getName().contains(string)) {
                filteredBooks.add(key);
            }
        }
        return filteredBooks;
    }

    public static List<Book> searchByAuthor(Author author) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book key : books.keySet()) {
            if (key.getAuthor().equals(author)) {
                filteredBooks.add(key);
            }
        }
        return filteredBooks;
    }

    public static List<Book> searchByCategory(BookGenre type) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book key : books.keySet()) {
            if (key.getType().equals(type)) {
                filteredBooks.add(key);
            }
        }
        return filteredBooks;
    }

    public static int numberOfBooksLeft(Book book) {
        int count = 0;
        for (Book key : books.keySet()) {
            if (key.equals(book)) {
                count = books.get(key);
                break;
            }
        }

        return count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Librarian{" + '\'' +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                " id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                '}';
    }
}
