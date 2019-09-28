package com.zensar.hibernate.main;
import java.util.List;

/**
 * @author Aditee Chourasiya
 * @creation-date 27-09-2019 5.54PM
 * @modification-date 27-09-2019 5.54PM
 * @version 2.0
 * @copyright All rights reserved by Zensar technologies
 * @description It is a Main Class
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;

public class MovieDeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Movie n = s.get(Movie.class, 4);
		System.out.println(n.getTitle()+" "+n.getReleaseDate());
		List<Song> songs = n.getSongs();
		
		for(Song sg:songs) {
			System.out.println(sg);	
		}
		if(n!=null) {
			s.delete(n);
		}
		else {
			System.out.println("Movie Not Found");
		}
		t.commit();
		s.close();
		System.exit(0);
	}

}
