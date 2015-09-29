package org.foreni.sms.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.foreni.sms.model.KeystoreProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Repository("keystoreRepoImpl")
@Transactional(propagation=Propagation.REQUIRED)
public class KeystoreRepoImpl implements KeystoreRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void saveKeystoreProfile(KeystoreProfile keystoreProfile) {		
		entityManager.persist(keystoreProfile);
	}

	public Boolean isKeystoreCreated() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		KeystoreProfile keystoreProfile = (KeystoreProfile)session.get(KeystoreProfile.class, 1L);
		session.close();
		if(keystoreProfile == null)
			return false;
		return true;
	}
}