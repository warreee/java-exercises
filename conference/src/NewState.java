public class NewState implements ArticleState {

    Article article;

    public NewState(Article article) {
        this.article = article;
    }

    @Override
    public void addReviewer() throws Exception {
        article.setState(article.getProcessingState());
        System.out.println("Added reviewer and changed to processing state.");
    }

    @Override
    public void rejectArticle() throws Exception {
        throw new Exception("Cannot reject before being in processing state");
    }

    @Override
    public void acceptArticle() throws Exception {
        throw new Exception("Cannot accept before being in processing state");
    }

    @Override
    public String toString() {
        return "The article is new";
    }
}
