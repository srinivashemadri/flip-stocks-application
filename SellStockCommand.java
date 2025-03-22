class SellStockCommand implements Command {
    private String user;
    private String stock;
    private int qty;

    public SellStockCommand(String user, String stock, int qty) {
        this.user = user;
        this.stock = stock;
        this.qty = qty;
    }

    @Override
    public void execute() {
        UserRegistry.getInstance().getUser(user).sellStock(stock, qty);
    }
}