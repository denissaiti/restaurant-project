class admin extends Username {
    public String password;

    public admin(String username, String password) {
        super(username);
        this.password = password;
    }
}