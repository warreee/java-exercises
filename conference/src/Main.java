import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Starting with conference");
        Guest guest1 = new Guest("joro tenev1", 5164134, "some street zip state");
        Guest guest2 = new Guest("joro tenev2", 5164134, "some street zip state");
        Author author1 = new Author("author1", 5164134, "some street zip state");
        Author author2 = new Author("author2", 5164134, "some street zip state");
        System.out.println("The number of publications for " + author1.getName() + " = " + author1.getNumberOfPublications());
        String[] keywords = {};
        IndividualArticle individualArticle1 = new IndividualArticle("title", "description", keywords, author1);
        System.out.println("The number of publications for " + author1.getName() + " = " + author1.getNumberOfPublications());
        HashMap<Double, Authorship> collaborativeAuthors1 = new HashMap<>();
        collaborativeAuthors1.put(25.0, author1);
        collaborativeAuthors1.put(75.0, author2);
        CollaborativeArticle collaborativeArticle1 = new CollaborativeArticle("title", "description", keywords, collaborativeAuthors1);
        System.out.println("The number of publications for " + author1.getName() + " = " + author1.getNumberOfPublications());
        System.out.println("The number of publications for " + author2.getName() + " = " + author2.getNumberOfPublications());
        Organiser organiser1 = new Organiser("organiser1", 13654, "address", "password");
        Organiser organiser2 = new Organiser("organiser2", 13654, "address", "password");
        System.out.println("The status of the fist article is " + individualArticle1.getStatus());
        try {
            individualArticle1.accept("pass");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        individualArticle1.addReviewer(organiser1);
        individualArticle1.accept("password");
        System.out.println("The status of the fist article " + individualArticle1.getStatus());
        try { individualArticle1.reject("password");}
        catch (Exception e1) {
            System.out.println(e1.toString());
        }
        System.out.println("The status of the fist article " + individualArticle1.getStatus());
        HashMap<Double, Authorship> collaborativeAuthors2 = new HashMap<>();
        collaborativeAuthors2.put(25.0, author1);
        collaborativeAuthors2.put(75.0, organiser2);
        CollaborativeArticle collaborativeArticle2 = new CollaborativeArticle("title", "description", keywords, collaborativeAuthors2);
        System.out.println("The status of the second collaborative article is " + collaborativeArticle2.getStatus());
        try {
            collaborativeArticle2.addReviewer(organiser2);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("The status of the second collaborative article is " + collaborativeArticle2.getStatus());
        collaborativeArticle2.addReviewer(organiser1);
        System.out.println("The status of the second collaborative article is " + collaborativeArticle2.getStatus());

    }
}
