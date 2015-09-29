package org.foreni.sms.repo;

import org.foreni.sms.model.KeystoreProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeystoreRepo	{
	
	void saveKeystoreProfile(KeystoreProfile keystoreProfile);

}
