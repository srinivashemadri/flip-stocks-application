class Transaction {
    private String type;
    private String stockName;
    private int quantity;
    private double price;

    public Transaction(String type, String stockName, int quantity, double price) {
        this.type = type;
        this.stockName = stockName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d @ %.2f", type, stockName, quantity, price);
    }
}