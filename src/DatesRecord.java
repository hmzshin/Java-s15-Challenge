import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DatesRecord implements Comparable<DatesRecord> {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private final String borrowedDate;
    private String giveBackDate;

    public DatesRecord() {
        this.borrowedDate = dtf.format(LocalDateTime.now());
        ;
    }

    public String getBorrowedDate() {
        return this.borrowedDate;
    }

    public String getGiveBackDate() {
        return this.giveBackDate;
    }


    public void setGiveBackDate() {
        this.giveBackDate = dtf.format(LocalDateTime.now());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatesRecord that = (DatesRecord) o;
        return Objects.equals(borrowedDate, that.borrowedDate) && Objects.equals(giveBackDate, that.giveBackDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(borrowedDate, giveBackDate);
    }

    @Override
    public String toString() {
        return "DatesRecord{" +
                ", borrowedDate='" + borrowedDate + '\'' +
                ", giveBackDate='" + giveBackDate + '\'' +
                '}';
    }

    @Override
    public int compareTo(DatesRecord other) {
        return this.borrowedDate.compareTo(other.getBorrowedDate());
    }

}
