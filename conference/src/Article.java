import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public abstract class Article {

    private String title;
    private String description;
    private String[] keywords;
    private TreeMap<Double, Authorship> authors = new TreeMap<>();

    public Article(String title, String description, String[] keywords) throws Exception {
        this.title = title;
        this.description = description;
        setKeywords(keywords);
        this.newState = new NewState(this);
        this.processingState = new ProcessingState(this);
        this.readyAcceptedState = new ReadyAcceptedState(this);
        this.readyRejectedState = new ReadyRejectedState(this);
        // Articles are by default in the new state.
        this.articleState = this.newState;
    }

    private void setKeywords(String[] keywords) throws Exception {
        if (keywords.length < 5) {
            this.keywords = keywords;
        } else {
            throw new Exception("Maximum 4 keyword");
        }
    }


    TreeMap<Double, Authorship> getAuthors(){
        return this.authors;
    }

    public Authorship getAuthor() {
        return getAuthors().get(getAuthors().lastKey());
    }

    public abstract Authorship getAuthors(int i) throws Exception;

    private ArticleState articleState;

    public void setState(ArticleState articleState) {
        this.articleState = articleState;
    }

    private ArrayList<Reviewer> reviewers = new ArrayList<>();

    public ArrayList<Reviewer> getReviewers() {
        return reviewers;
    }

    public void addReviewer(Reviewer reviewer) throws Exception {
        if (this.getAuthors().values().stream().noneMatch(reviewer::reviewerIsAuthor)) {
            this.getReviewers().add(reviewer);
            this.articleState.addReviewer();
        } else {
            throw new Exception("Cannot review own paper!");
        }
    }

    public void reject(String password) throws Exception {
        // If you the given password is one of the reviewers you are allowed to change state.
        if (reviewers.stream().anyMatch(reviewer -> reviewer.verifyPassword(password))) {
            this.articleState.rejectArticle();
        } else {
            throw new Exception("Wrong password!");
        }
    }

    public void accept(String password) throws Exception {
        // If the given password is one of the reviewers you are allowed to change state.
        if (reviewers.stream().anyMatch(reviewer -> reviewer.verifyPassword(password))) {
            this.articleState.acceptArticle();
        } else {
            throw new Exception("Wrong password!");
        }
    }

    public String getStatus() {
        return this.articleState.toString();
    }

    private ArticleState newState;

    public ArticleState getNewState() {
        return newState;
    }

    private ArticleState processingState;

    public ArticleState getProcessingState() {
        return processingState;
    }

    private ArticleState readyAcceptedState;

    public ArticleState getReadyAcceptedState() {
        return readyAcceptedState;
    }

    private ArticleState readyRejectedState;

    public ArticleState getReadyRejectedState() {
        return readyRejectedState;
    }
}
