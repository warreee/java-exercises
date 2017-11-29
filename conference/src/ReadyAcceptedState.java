public class ReadyAcceptedState implements ArticleState {

    private Article article;

    public ReadyAcceptedState(Article article) {
        this.article = article;
    }

    @Override
    public void addReviewer() throws Exception {
        throw new Exception("An article that is already accepted cannot receive extra reviewers!");
    }

    @Override
    public void rejectArticle() throws Exception {
        throw new Exception("An article that is already accepted cannot be rejected");
    }

    @Override
    public void acceptArticle() throws Exception {
        throw new Exception("An article that is already accepted cannot be rejected");
    }

    @Override
    public String toString() {
        return "The article is ready and accepted";
    }


}
