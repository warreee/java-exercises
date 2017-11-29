public class IndividualArticle extends Article {


    public IndividualArticle(String title, String description, String[] keywords, Authorship author) throws Exception {
        super(title, description, keywords);
        this.getAuthors().put(100.0, author);
        author.addArticle(this);
    }

    @Override
    public Authorship getAuthors(int i) throws Exception {
        if (i != 0) {
            throw new Exception("An individual article has only one author");
        } else {
            return this.getAuthor();
        }
    }

}
