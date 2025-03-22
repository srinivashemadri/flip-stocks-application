class ListAllMarketStockPricesCommand implements Command {
    @Override
    public void execute() {
        Market.getInstance().getAllStockPrices().forEach((k, v) -> System.out.println(k + " " + v));
    }
}