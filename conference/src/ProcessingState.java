public class ProcessingState implements ArticleState {

    Article article;

    public ProcessingState(Article article) {
        this.article = article;
    }
    @Override
    public void addReviewer() throws Exception {
        System.out.println("Added reviewer and stayed in processing state.");
    }

    @Override
    public void rejectArticle() throws Exception {
        System.out.println("Article is rejected.");
        article.setState(article.getReadyRejectedState());
    }

    @Override
    public void acceptArticle() throws Exception {
        System.out.println("Article is accepted.");
        article.setState(article.getReadyAcceptedState());
    }

    @Override
    public String toString() {
        return "The article is processing";
    }
}
