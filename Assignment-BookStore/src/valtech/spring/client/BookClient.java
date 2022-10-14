package valtech.spring.client;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import valtech.spring.orm.Address;
import valtech.spring.orm.Article;
import valtech.spring.orm.Author;
import valtech.spring.orm.Blog;
import valtech.spring.orm.Book;
import valtech.spring.orm.HandBook;
import valtech.spring.orm.Publisher;

public class BookClient {

	public static void main(String[] args) {
		SessionFactory sf = new AnnotationConfiguration()
				.configure()
				.addAnnotatedClass(Publisher.class)
				.addAnnotatedClass(Book.class)
				.addAnnotatedClass(Article.class)
				.addAnnotatedClass(Blog.class)
				.addAnnotatedClass(HandBook.class)
				.addAnnotatedClass(Author.class)
				.addAnnotatedClass(Article.class)
				.addAnnotatedClass(Address.class)
				.buildSessionFactory();

		Session ses =sf.openSession();
		Transaction tx = ses.beginTransaction();

		Author author1 =new Author("J K Rowling", 6361322110L);
		Address address1=new Address("J P NGR","BLR","KAR",560078);
		ses.saveOrUpdate(author1);
		ses.saveOrUpdate(address1);
		address1.setAuthor(author1);
		author1.setAddress(address1);
		
		Author author2 =new Author("Ruskin Bond", 9856714296L);
		Address address2=new Address("Malleshwaram","Blr","Kar",560055);
		ses.saveOrUpdate(author2);
		ses.saveOrUpdate(address2);
		address2.setAuthor(author2);
		author2.setAddress(address2);
		
		Book book1=new Book("Harry Potter and the Philosophers Stone",new Date(97, 6, 15));
		
        ses.save(new Article("Harry Potter and the Philosophers Stone",new Date(97, 6, 15),"https://www.harrypotterseriesbook1/article.com"));
        ses.save(new Blog("Harry Potter and the Philosophers Stone",new Date(97, 6, 15),"https://www.harrypotterseriesbook1/blog.com", 10000));
        ses.save(new HandBook("Harry Potter and the Philosophers Stone",new Date(97, 6, 15),"0-7475-3269-9",(float)496.00,1997,"Edition 1"));
        
        Book book2=new Book("The Blue Umbrella",new Date(74, 9, 20));
        ses.save(new Article("The Blue Umbrella",new Date(74, 9, 20),"https://www.theblueumbrella/article.com"));
        ses.save(new Blog("The Blue Umbrella",new Date(74, 9, 20),"https://www.theblueumbrella/blog.com", 10000));
        ses.save(new HandBook("The Blue Umbrella",new Date(74, 9, 20),"0-7475-3269-9",(float)95.00,1974,"Edition 2"));
		
		Publisher pub1=new Publisher("Bloomsbery Publications", "Jaynagar, BLR, KAR, 560041",6975846245L);
		ses.saveOrUpdate(pub1);
		
		Publisher pub2=new Publisher("Rupa Publications", "Basvangudi, BLR, KAR, 560041",9821756425L);
		ses.saveOrUpdate(pub2);
		
        List<Book> books=ses.createQuery("SELECT book From Book book").list();
        for(Book b:books){
            b.setPublisher(b.getId()==pub1.getId() ? pub1:pub2);     
        }
        
        Author a1=(Author)ses.load(Author.class, 10);
        Book b1=(Book)ses.load(Book.class, 30);
        Book b2=(Book)ses.load(Book.class, 31);
        Book b3=(Book)ses.load(Book.class, 32);
        b1.addAuthor(a1);
        b2.addAuthor(a1);
        b3.addAuthor(a1);
        
        Author a2=(Author)ses.load(Author.class, 11);
        Book b11=(Book)ses.load(Book.class, 33);
        Book b22=(Book)ses.load(Book.class, 34);
        Book b33=(Book)ses.load(Book.class, 35);
        b11.addAuthor(a2);
        b22.addAuthor(a2);
        b33.addAuthor(a2);
        

		tx.commit();
		ses.close();
		sf.close();
	}

}
