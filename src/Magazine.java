import java.time.Month;

public  class Magazine extends Publish{

    private Month month;

    public Magazine(String name, long serialNumber, int pageCount, String publisher,Language language, Month month) {
        super(name, serialNumber, pageCount, publisher, language);
        this.month = month;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }
}
