                                         public class Address {
    private String city;
    private String district;
    private String neighbourhood;
    private int no;


    public Address(String city, String district, String neighbourhood, int no) {
        this.city = city;
        this.district = district;
        this.neighbourhood = neighbourhood;
        this.no = no;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", neighbourhood='" + neighbourhood + '\'' +
                ", no=" + no +
                '}';
    }
}
