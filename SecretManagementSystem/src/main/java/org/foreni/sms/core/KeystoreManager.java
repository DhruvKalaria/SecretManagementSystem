package org.foreni.sms.core;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import org.foreni.sms.model.KeystoreProfile;
import org.foreni.sms.model.KeystoreProfile.KeystoreType;

public interface KeystoreManager {

	/**
	 * Creates a KeyStore of type - JKS or JCEKS with specified passphrase
	 * and saves it to the specified path on file system. 
	 */
	public void createKeyStore(KeystoreProfile keystoreProfile);
	
	/**
	 * Checks if any Keystore is already present. If Keystore is present it returns true.
	 * @return
	 */
	
	public Boolean isAvailable();
}