import java.util.Objects;

public abstract class Publish {

    private String name;
    private long serialNumber;
    private int pageCount;
    private String publisher;
    private Language language;


    public Publish(String name, long serialNumber, int pageCount, String publisher, Language language) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.pageCount = pageCount;
        this.publisher = publisher;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publish publish = (Publish) o;
        return serialNumber == publish.serialNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

   
}
