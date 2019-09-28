package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Country;
import com.zensar.entities.Flag;

/**
 * @author Aditee Chourasiya
 * @creation-date 27-09-2019 3.08PM
 * @modification-date 27-09-2019 3.08PM
 * @version 1.0
 * @copyright All rights reserved by Zensar technologies
 * @description It is a Main Class
 */

public class OneToOneMappingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Country co = new Country();
		co.setLanguage("Hindi");
		co.setName("India");
		co.setPopulation(13000000000l);
		
		Flag fg = new Flag();
		fg.setFlagName("Trianga");
		fg.setDescription("Its a TRI Colour Flag");
		co.setFlag(fg);
		fg.setCountry(co);
		
		s.save(co);
		s.save(fg);
		t.commit();
		s.close();
		System.exit(0);
	}

}
