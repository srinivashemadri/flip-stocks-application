class CreateUserCommand implements Command {
    private String name;
    private double wallet;

    public CreateUserCommand(String name, double wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    @Override
    public void execute() {
        UserRegistry.getInstance().createUser(name, wallet);
    }
}