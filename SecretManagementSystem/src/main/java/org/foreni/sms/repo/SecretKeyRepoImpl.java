package org.foreni.sms.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.foreni.sms.model.SecretKeyProfile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Repository("secretKeyRepo")
@Transactional(propagation=Propagation.REQUIRED)
public class SecretKeyRepoImpl implements SecretKeyRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void saveSecretKeyProfile(SecretKeyProfile secretKeyProfile) {		
		entityManager.persist(secretKeyProfile);
	}
}