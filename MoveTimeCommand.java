class MoveTimeCommand implements Command {
    @Override
    public void execute() {
        if (!AuthService.getInstance().isAuthenticated()) {
            throw new IllegalStateException("Admin authentication required");
        }
        Market.getInstance().moveTime();
    }
}