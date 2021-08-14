public class Customer {
    private String name;
    private String address;
    private int meterCode;

    public Customer() {
    }

    public Customer(String fullName, String address, int meterCode) {
        this.name = fullName;
        this.address = address;
        this.meterCode = meterCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(int meterCode) {
        this.meterCode = meterCode;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", address: " + address +
                ", meter code: " + meterCode;
    }
}
