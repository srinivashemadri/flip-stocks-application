class GetStockPriceCommand implements Command {
    private String stockName;

    public GetStockPriceCommand(String stockName) {
        this.stockName = stockName;
    }

    @Override
    public void execute() {
        System.out.println(Market.getInstance().getStock(stockName).getCurrentPrice());
    }
}