package org.foreni.sms.repo;

import org.foreni.sms.model.KeystoreProfile;

public interface KeystoreRepo	{
	
	void saveKeystoreProfile(KeystoreProfile keystoreProfile);
	KeystoreProfile getKeystoreProfile(int id);
}