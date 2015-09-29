package org.foreni.sms.core;

import org.foreni.sms.model.KeystoreProfile;
import org.foreni.sms.model.SecretKeyProfile;

public interface KeystoreManager {

	/**
	 * Creates a KeyStore of type - JKS or JCEKS with specified passphrase
	 * and saves it to the specified path on file system. 
	 */
	public void createKeyStore(KeystoreProfile keystoreProfile);
	
	
	/**
	 * Adds a Secret Key to Keystore
	 * @param secretKeyProfile
	 */
	public void addSecretKeyToKeystore(SecretKeyProfile secretKeyProfile);
}