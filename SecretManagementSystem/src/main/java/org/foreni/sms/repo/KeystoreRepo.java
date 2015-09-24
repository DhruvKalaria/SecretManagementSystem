package org.foreni.sms.repo;

import org.foreni.sms.model.Keystore;


public interface KeystoreRepo	{
	
	void createKeyStore(Keystore keystoreProfile);
	
	Boolean isKeystoreCreated();
}
