import java.util.ArrayList;

public abstract class Authorship extends Attendee {

    private ArrayList<Article> articles = new ArrayList<>();

    Authorship(String name, int phone, String address) {
        super(name, phone, address);
    }

    public void addArticle(Article article) {
        this.articles.add(article);
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public int getNumberOfPublications() {
        return articles.size();
    }

    public boolean equals(Authorship authorship) {
        // TODO: in production this should be extended.
        return this.getName().equals(authorship.getName());
    }
}
