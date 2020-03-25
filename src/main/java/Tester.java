import beans.*;
import dao.database.CommonDatabaseDAO;
import services.CommentService;
import services.DocumentService;
import services.UserService;

public class Tester {
    public static void main(String[] args) {

        DocumentService ds = new DocumentService();
        UserService us = new UserService();
        CommentService cs = new CommentService();

        Document document = new Document("First document", "Document text : coffee is very important thing in our lives");
        User user = new User("Artemiy Vladimirovich","Artemiy@gmail.com");
        //documentDao.add(document);
        //us.add(user);
        document.addAnnotation(new Annotation(document,user,"First annotation title",5,12,"First annotation text"));
        document.addComment(new Comment(document,user,"Second comment title","Second comment content"));
        document.addComment(new Comment(document,user,"First comment title","First comment content"));
        ds.addUsersIfAbsent(document);
        ds.add(document);
        Comment c = new Comment(new Document("123","123"),user,"qewqwe","213");
        cs.delete(c);
        System.out.println(cs.getAll());
        System.out.println(us.getAll());
    }
}