package video3;

public class CompactDisc {
    private int currentStock;

    public CompactDisc(int initialStock) {
        this.currentStock = initialStock;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void buy(int quantity) throws InsufficientStockException {
        if (currentStock < quantity)
            throw new InsufficientStockException("Quantity " + quantity + " exceeds stock of " + currentStock);
        currentStock -= quantity;
    }
}
