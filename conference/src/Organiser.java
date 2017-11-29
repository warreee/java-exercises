public class Organiser extends Authorship implements Reviewer {


    private String password;

    public Organiser(String name, int phone, String address) {
        super(name, phone, address);
    }

    public Organiser(String name, int phone, String address, String password) {
        this(name, phone, address);
        this.password = password;
    }

    public Boolean verifyPassword(String password) {
        return password != null && password.equals(this.password);
    }

    @Override
    public Boolean reviewerIsAuthor(Authorship author) {
        return this.equals(author);
    }
}
