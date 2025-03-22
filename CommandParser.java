import java.util.*;

class CommandParser {
    public static Command parse(String input) throws Exception {
        String[] parts = input.split("[(),]\\s*");
        String commandName = parts[0];
        List<String> params = new ArrayList<>();
        for (int i = 1; i < parts.length; i++) {
            String param = parts[i].trim();
            if (!param.isEmpty()) params.add(param);
        }

        switch (commandName.toUpperCase()) {
            case "ADD_STOCKS":
                validateParams(params, 2);
                return new AddStocksCommand(params.get(0), Double.parseDouble(params.get(1)));
            case "CREATE_USER":
                validateParams(params, 2);
                return new CreateUserCommand(params.get(0), Double.parseDouble(params.get(1)));
            case "MOVE_TIME":
                validateParams(params, 0);
                return new MoveTimeCommand();
            case "LIST_ALL_MARKET_STOCK_PRICES":
                validateParams(params, 0);
                return new ListAllMarketStockPricesCommand();
            case "GET_STOCK_PRICE":
                validateParams(params, 1);
                return new GetStockPriceCommand(params.get(0));
            case "BUY_STOCK":
                validateParams(params, 3);
                return new BuyStockCommand(params.get(0), params.get(1), Integer.parseInt(params.get(2)));
            case "SELL_STOCK":
                validateParams(params, 3);
                return new SellStockCommand(params.get(0), params.get(1), Integer.parseInt(params.get(2)));
            case "VIEW_PORTFOLIO":
                validateParams(params, 1);
                return new ViewPortfolioCommand(params.get(0));
            case "LOGIN":
                validateParams(params, 2);
                return new LoginCommand(params.get(0), params.get(1));
            default:
                throw new IllegalArgumentException("Unknown command: " + commandName);
        }
    }

    private static void validateParams(List<String> params, int expected) {
        if (params.size() != expected) {
            throw new IllegalArgumentException("Invalid parameters");
        }
    }
}