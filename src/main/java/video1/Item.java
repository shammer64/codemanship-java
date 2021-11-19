package video1;

public class Item {
    private final double unitPrice;
    private final int quantity;

    public Item(double unitPrice, int quantity) {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return unitPrice * (double) quantity;
    }
}
