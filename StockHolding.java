class StockHolding {
    private int quantity;
    private double purchasePrice;

    public StockHolding(int quantity, double purchasePrice) {
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
    }

    public int getQuantity() { return quantity; }
    public double getPurchasePrice() { return purchasePrice; }
}