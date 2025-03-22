class AuthService {
    private static AuthService instance;
    private boolean authenticated = false;
    
    private AuthService() {}
    
    public static AuthService getInstance() {
        if (instance == null) instance = new AuthService();
        return instance;
    }
    
    public void login(String username, String password) {
        if (!CredentialHelper.ADMIN_USER_NAME.equals(username) || ! CredentialHelper.ADMIN_USER_NAME.equals(password)) 
            throw new IllegalArgumentException("Invalid admin credentials");
        authenticated = true;
    }
    
    public boolean isAuthenticated() { return authenticated; }
}