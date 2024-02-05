import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("Hamza", "Şahin", "555", "asdf1", new Address("Sivas", "Sivas", "Aşagı mah.", 58));
        User user2 = new User("Serdar", "Ortaç", "541", "12", new Address("İstanbul", "Bağcılar", "Aşagı mah.", 34));
        User user3 = new User("İlber", "Ortaylı", "155", "asdf1", new Address("Ankara", "Sivas", "Aşagı mah.", 58));
        User user4 = new User("Fatih", "Osmanlı", "152", "asdf1", new Address("Beyazıt", "İskender", "Aşagı mah.", 58));

        Author author1 = new Author("James", "Gosling", 1);
        Author author2 = new Author("Necip Fazıl", "Kısakürek", 2);

        Book book1 = new Book("Java", author1, 123, 1000, "Java", BookGenre.SCIENCE, Language.ENGLISH);
        Book book2 = new Book("Reis Bey", author2, 978975110, 152, "Büyük Doğu yayınları", BookGenre.NOVEL,
                Language.TURKISH);
        Book book3 = new Book("Çile", author2, 15479, 512, "Büyük Doğu yayınları", BookGenre.POETRY, Language.TURKISH);
        Book book4 = new Book("Reis Bey", author2, 54542, 152, "Kronik", BookGenre.NOVEL, Language.TURKISH);
        Book book5 = new Book("Java", author1, 5523, 1000, "Kodlab", BookGenre.SCIENCE, Language.ENGLISH);
        Book book6 = new Book("Reis Bey", author2, 8446, 152, "Can", BookGenre.NOVEL, Language.TURKISH);

        Book book1updated = new Book("JAVA", author1, 123, 1000, "Java", BookGenre.SCIENCE, Language.ENGLISH);

        Librarian.addUser(user1);
        Librarian.addUser(user2);
        Librarian.addUser(user3);
        Librarian.addUser(user4);

        Librarian.addBook(book1, 2);
        Librarian.addBook(book2, 4);
        Librarian.addBook(book3, 6);
        Librarian.addBook(book4, 2);
        Librarian.addBook(book5, 45);
        Librarian.addBook(book6, 2);

        // System.out.println(Librarian.searchByAuthor(author2));
        // System.out.println("*********");
        // System.out.println(Librarian.searchByName("Java"));

        // Librarian.updateBookDetails(book1, book1updated);
        // System.out.println(Librarian.searchByCategory(BookGenre.POETRY));

        //
        // System.out.println(user1.getCurrentlyTakenBooks());

        /*
         * Librarian.updateBookCount(book1, -5);
         * System.out.println(Librarian.numberOfBooksLeft(book1));
         * user1.borrowBook(book1);
         * System.out.println(Librarian.numberOfBooksLeft(book1));
         * user1.borrowBook(book2);
         * user1.borrowBook(book3);
         * user1.borrowBook(book4);
         * user1.borrowBook(book5);
         * user1.borrowBook(book6);
         * user2.borrowBook(book1);
         * System.out.println(Librarian.numberOfBooksLeft(book1));
         * user3.borrowBook(book1);
         * 
         * 
         * System.out.println(Librarian.numberOfBooksLeft(book1));
         */

        // user2.giveBookBack(book1);
        //
        // System.out.println(user2.getHistory());

        /*
         * Librarian.printBooks();
         * System.out.println(user1.getCurrentlyTakenBooks());
         * System.out.println("******************************************" +
         * author1.getBooks());
         * 
         * 
         * System.out.println("********************************************");
         * System.out.println(Librarian.getUsers());
         */
        // System.out.println(Librarian.searchBySerialNumber(123));

        final String[] searchSetter = { "" };
        // Create Frame
        JFrame jf = new JFrame("LIBRARY");
        jf.setSize(500, 500);
        jf.setLocation(550, 350);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Create Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        mainPanel.add(createMenuBar(cardLayout, cardPanel, searchSetter), BorderLayout.NORTH);

        JTextArea displayResults = new JTextArea(27, 40);
        JScrollPane scrollPane = new JScrollPane(displayResults);
        displayResults.setEditable(false);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton searchButton = new JButton("Search");
        JTextField textField = new JTextField(20);
        JLabel label = new JLabel("Type to search");
        panel.add(searchButton);
        panel.add(textField);
        panel.add(label);

        mainPanel.add(panel, BorderLayout.SOUTH);

        // Create Second Panel
        JPanel borrowPanel = new JPanel(new BorderLayout());

        borrowPanel.add(createMenuBar(cardLayout, cardPanel, searchSetter), BorderLayout.NORTH);

        JPanel bottomPanelBorrow = new JPanel();
        JPanel centerPanelBorrow = new JPanel();
        JButton borrowButton = new JButton("Borrow");
        JButton giveBackButton = new JButton("Give Back");
        JLabel labelForUser = new JLabel("Type to user number:");
        JLabel labelForBook = new JLabel("Type to book serial number:");
        JLabel labelForPassword = new JLabel("Password:");
        JTextField getUserInfo = new JTextField(20);
        JTextField getBookInfo = new JTextField(20);
        JTextField getPassword = new JTextField(20);

        JTextArea displayBill = new JTextArea(23, 40);
        JScrollPane scrollPaneBorrow = new JScrollPane(displayBill);
        displayBill.setEditable(false);

        bottomPanelBorrow.add(borrowButton);
        bottomPanelBorrow.add(giveBackButton);

        centerPanelBorrow.add(labelForUser);
        centerPanelBorrow.add(getUserInfo);
        centerPanelBorrow.add(labelForBook);
        centerPanelBorrow.add(getBookInfo);
        centerPanelBorrow.add(labelForPassword);
        centerPanelBorrow.add(getPassword);
        centerPanelBorrow.add(scrollPaneBorrow);

        borrowPanel.add(bottomPanelBorrow, BorderLayout.SOUTH);
        borrowPanel.add(centerPanelBorrow, BorderLayout.CENTER);

        // Add panels to card layout
        cardPanel.add(mainPanel, "main");
        cardPanel.add(borrowPanel, "borrow");

        jf.getContentPane().add(cardPanel);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch (searchSetter[0]) {

                    case "name":
                        String result = Librarian.searchByName(textField.getText()).toString();
                        displayResults.setText(result);
                        break;

                    case "serialNumber":
                        long userInput = Long.parseLong(textField.getText());
                        String result1 = Librarian.searchBySerialNumber(userInput).toString();
                        displayResults.setText(result1);
                        break;

                    case "author":
                        displayResults.setText("We are working on search by author. Thank you for your patience.");
                        break;

                    case "category":
                        String userInputToUpperCase = textField.getText().toUpperCase().trim();
                        boolean isThereResult = false;

                        for (BookGenre type : BookGenre.values()) {
                            if (type.name().equals(userInputToUpperCase)) {
                                String result2 = Librarian.searchByCategory(type).toString();
                                displayResults.setText(result2);
                                isThereResult = true;
                                break;
                            }
                        }
                        if (!isThereResult) {
                            displayResults.setText("There is no book.");
                        }
                        break;

                    default:
                        displayResults.setText("Please choose an option to search by.");

                }

            }
        });

        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Map<User, Book> pair = validateUserAndBook(getUserInfo, getBookInfo, displayBill);
                    User user = pair.keySet().stream().findFirst().orElse(null);
                    Book book = pair.get(user);
                    String password = getPassword.getText();

                    assert user != null;
                    if (user.getPassword().equals(password)) {
                        String status = user.borrowBook(book);
                        status = status + "\n" + "\n" + "The books you take: " + "\n" + user.getCurrentlyTakenBooks();

                        displayBill.setText(status);
                    } else {
                        displayBill.setText("Password is wrong, try again.");
                    }

                } catch (RuntimeException ex) {
                    System.out.println(ex);
                }

            }
        });

        giveBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Map<User, Book> pair = validateUserAndBook(getUserInfo, getBookInfo, displayBill);
                    User user = pair.keySet().stream().findFirst().orElse(null);
                    Book book = pair.get(user);
                    String password = getPassword.getText();

                    assert user != null;
                    if (user.getPassword().equals(password)) {
                        String status = user.giveBookBack(book);
                        status = status + "\n" + "\n" + "The books you take: " + "\n" + user.getHistory();

                        displayBill.setText(status);
                    } else {
                        displayBill.setText("Password is wrong, try again.");
                    }

                } catch (RuntimeException ex) {
                    System.out.println(ex);
                }

            }
        });

    }

    private static JMenuBar createMenuBar(CardLayout cardLayout, JPanel cardPanel, String[] searchSetter) {

        JMenuBar menuBar = new JMenuBar();
        JMenu borrowBook = new JMenu("Borrow Book");
        JMenu menuOption1 = new JMenu("Search Options");
        menuBar.add(borrowBook);
        menuBar.add(menuOption1);

        JMenuItem searchOption1 = new JMenuItem("Search By Name");
        JMenuItem searchOption2 = new JMenuItem("Search By SerialNumber");
        JMenuItem searchOption3 = new JMenuItem("Search By Author");
        JMenuItem searchOption4 = new JMenuItem("Search By Category");

        menuOption1.add(searchOption1);
        menuOption1.add(searchOption2);
        menuOption1.add(searchOption3);
        menuOption1.add(searchOption4);

        JMenuItem takeBook = new JMenuItem("Book");

        borrowBook.add(takeBook);

        searchOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(cardPanel, "main");
                searchSetter[0] = "name";
            }
        });
        searchOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(cardPanel, "main");
                searchSetter[0] = "serialNumber";
            }
        });

        searchOption3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(cardPanel, "main");
                searchSetter[0] = "author";
            }
        });
        searchOption4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(cardPanel, "main");
                searchSetter[0] = "category";
            }
        });

        takeBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cardLayout.show(cardPanel, "borrow");
            }
        });

        return menuBar;
    }

    public static Map<User, Book> validateUserAndBook(JTextField getUserInfo, JTextField getBookInfo,
            JTextArea displayBill) {
        if (getUserInfo.getText().isEmpty() || getBookInfo.getText().isEmpty()) {
            displayBill.setText("Please enter valid user and book information.");
            throw new RuntimeException("Invalid user and book information.");
        }
        User user = null;
        Book book = null;
        Set<User> users = Librarian.getUsers();
        for (User item : users) {
            if (item.getPhone().equals(getUserInfo.getText())) {
                user = item;
            }
        }
        if (user == null) {
            displayBill.setText("There is no such user.");
            throw new RuntimeException("Invalid user.");
        }
        Set<Book> books = Librarian.getBooks().keySet();
        for (Book item : books) {
            if (item.getSerialNumber() == (Long.parseLong(getBookInfo.getText()))) {
                book = item;
            }
        }
        if (book == null) {
            displayBill.setText("There is no such book.");
            throw new RuntimeException("Invalid book");
        }

        Map<User, Book> pair = new HashMap<>();
        pair.put(user, book);
        return pair;
    }

}
