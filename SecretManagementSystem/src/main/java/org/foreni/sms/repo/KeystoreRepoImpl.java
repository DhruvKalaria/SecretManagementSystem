package org.foreni.sms.repo;

import org.foreni.sms.model.Keystore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class KeystoreRepoImpl implements KeystoreRepo	{

	public void createKeyStore(Keystore keystoreProfile) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(keystoreProfile);
		session.getTransaction().commit();
		session.close();
		
		keystoreProfile = null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		keystoreProfile = (Keystore)session.get(Keystore.class, 1L);
		session.close();
		System.out.println(keystoreProfile.toString());
	}

	public Boolean isKeystoreCreated() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Keystore keystoreProfile = (Keystore)session.get(Keystore.class, 1L);
		session.close();
		if(keystoreProfile == null)
			return false;
		return true;
	}
}