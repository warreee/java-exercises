import java.util.HashMap;

public class CollaborativeArticle extends Article {
    public CollaborativeArticle(String title, String description, String[] keywords, HashMap<Double, Authorship> authors) throws Exception {
        super(title, description, keywords);
        this.getAuthors().putAll(authors);
        authors.values().forEach(author -> author.addArticle(this));
    }

    @Override
    public Authorship getAuthors(int i) throws Exception {
        return this.getAuthors().get(i);
    }
}
