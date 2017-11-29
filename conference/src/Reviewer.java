public interface Reviewer {

    Boolean verifyPassword(String password);

    Boolean reviewerIsAuthor(Authorship author);
}
