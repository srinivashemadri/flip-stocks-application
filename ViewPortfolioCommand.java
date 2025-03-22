class ViewPortfolioCommand implements Command {
    private String user;

    public ViewPortfolioCommand(String user) {
        this.user = user;
    }

    @Override
    public void execute() {
        PortfolioView view = UserRegistry.getInstance().getUser(user).viewPortfolio();
        System.out.println(view);
    }
}