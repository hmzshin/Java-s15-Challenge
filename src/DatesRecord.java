import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DatesRecord implements Comparable<DatesRecord> {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private final LocalDateTime borrowedDate;
    private LocalDateTime giveBackDate;

    public DatesRecord() {
        this.borrowedDate = LocalDateTime.now();
    }

    public LocalDateTime getBorrowedDate() {
        return this.borrowedDate;
    }

    public LocalDateTime getGiveBackDate() {
        return this.giveBackDate;
    }

    public void setGiveBackDate() {
        this.giveBackDate = LocalDateTime.now();
    }

    public long calculateTimeDifferenceInSeconds() {
        if (giveBackDate != null) {
            Duration duration = Duration.between(borrowedDate, giveBackDate);
            return duration.getSeconds();
        } else {
            throw new IllegalStateException("Give-back date is not set.");
        }
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
                "borrowedDate=" + dtf.format(borrowedDate) + "\n" +
                ", giveBackDate=" + (giveBackDate != null ? dtf.format(giveBackDate) : "null") +
                '}';
    }

    @Override
    public int compareTo(DatesRecord other) {
        return this.borrowedDate.compareTo(other.getBorrowedDate());
    }
}
