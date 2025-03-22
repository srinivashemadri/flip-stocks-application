class AddStocksCommand implements Command {
    private String name;
    private double price;

    public AddStocksCommand(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void execute() {
        if (!AuthService.getInstance().isAuthenticated()) {
            throw new IllegalStateException("Admin authentication required");
        }
        Market.getInstance().addStock(new Stock(name, price));
    }
}