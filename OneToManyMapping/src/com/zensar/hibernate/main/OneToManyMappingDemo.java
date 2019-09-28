package com.zensar.hibernate.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;

/**
 * @author Aditee Chourasiya
 * @creation-date 27-09-2019 5.04PM
 * @modification-date 27-09-2019 5.04PM
 * @version 2.0
 * @copyright All rights reserved by Zensar technologies
 * @description It is a Main Class
 */

public class OneToManyMappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Movie m = new Movie();
		Song song1= new Song();
		Song song2=new Song();
		m.setReleaseDate(LocalDate.of(2000, 03, 29));
		m.setTitle("DDLJ");
		
		song1.setName("Tujhe Dekha to");
		song2.setName("Mehndi Laga k Rakhna");
		song1.setMovie(m);
		song2.setMovie(m);
		List<Song> songs = new ArrayList<Song>();
		songs.add(song1);
		songs.add(song2);
		
		s.save(m);
		s.save(song1);
		s.save(song2);
		t.commit();
		s.close();
	}

}
