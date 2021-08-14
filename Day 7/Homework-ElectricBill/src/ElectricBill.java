public class ElectricBill implements Comparable<ElectricBill> {
    private Customer customer;
    private int previousReading;
    private int currentReading;

    public ElectricBill(){
    }

    public ElectricBill(Customer customer, int previousReading, int currentReading){
        this.customer = customer;
        this.previousReading = previousReading;
        this.currentReading = currentReading;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getPreviousReading() {
        return previousReading;
    }

    public void setPreviousReading(int previousReading) {
        this.previousReading = previousReading;
    }

    public int getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(int currentReading) {
        this.currentReading = currentReading;
    }

    @Override
    public String toString() {
        return  customer +
                ", previous reading: " + previousReading +
                ", current reading: " + currentReading +
                ", total cost: " + getTotalCost() ;
    }

    public int getTotalCost() {
        return (currentReading - previousReading) * 1000;
    }

    @Override
    public int compareTo(ElectricBill electricBill) {
        return this.getCustomer().getName().compareTo(electricBill.getCustomer().getName());
    }
}
