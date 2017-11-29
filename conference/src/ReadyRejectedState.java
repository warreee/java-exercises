public class ReadyRejectedState implements ArticleState {
    private Article article;

    public ReadyRejectedState(Article article) {
        this.article = article;
    }

    @Override
    public void addReviewer() throws Exception {
        throw new Exception("An article that is already rejected cannot receive extra reviewers!");
    }

    @Override
    public void rejectArticle() throws Exception {
        throw new Exception("An article that is already rejected cannot be rejected");
    }

    @Override
    public void acceptArticle() throws Exception {
        throw new Exception("An article that is already rejected cannot be rejected");
    }

    @Override
    public String toString() {
        return "The article is ready and rejected";
    }
}
