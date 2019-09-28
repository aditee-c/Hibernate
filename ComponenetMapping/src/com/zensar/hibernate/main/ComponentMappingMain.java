package com.zensar.hibernate.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;

import com.zensar.entities.Customer;
import com.zensar.entities.Name;

public class ComponentMappingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c =new Configuration().configure();
		SessionFactory session = c.buildSessionFactory();
		Session s = session.openSession();
		Transaction t = s.beginTransaction();
		
		Name n = new Name();
		n.setFirstName("Aditee");
		n.setMiddleName(" - ");
		n.setLastName("Chourasiya");
		Customer cu = new Customer(105, n, "Female", 22,"Pune");
		cu.setBirthDate(LocalDate.of(1997, 03, 30));
		try {
			File photo = new File("./src/Resources/profilePhoto.jpg");
			FileInputStream fin = new FileInputStream(photo);
			Blob customerPhoto = BlobProxy.generateProxy(fin, photo.length());
			cu.setProfilePhoto(customerPhoto);
			File file2 = new File("./src/Resources/customerInfo.txt");
			FileReader fr = new FileReader(file2);
			Clob description = ClobProxy.generateProxy(fr, file2.length());
			cu.setDescription(description);
			s.save(cu);
			t.commit();
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
