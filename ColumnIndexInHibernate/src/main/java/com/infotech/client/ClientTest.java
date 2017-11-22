package com.infotech.client;

import org.hibernate.Session;

import com.infotech.entities.Author;
import com.infotech.entities.Book;
import com.infotech.util.HibernateUtil;

public class ClientTest {


	public static void main(String[] args) {

		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			
			Author  author = new Author();
			author.setFirstName("Gavin");
			author.setLastName("King");
			
			Book book1 = new Book();
			book1.setBookPrice(900.00);
			book1.setIsbn("900-987654312");
			book1.setTitle("Hibernate In Action");
			book1.setAuthor(author);
			
			author.getBooks().add(book1);
			session.beginTransaction();
			
			session.save(author);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}