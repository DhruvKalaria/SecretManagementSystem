package org.foreni.sms.core;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public interface KeystoreManager {

	/**
	 * Creates a KeyStore of type - JKS or JCEKS with specified passphrase
	 * and saves it to the specified path on file system. 
	 * 
	 * @param type
	 * @param passphrase
	 * @param pathToKeyStore
	 * @throws KeyStoreException 
	 * @throws IOException 
	 * @throws CertificateException 
	 * @throws NoSuchAlgorithmException 
	 */
	public void createKeyStore(String type, String passphrase, String pathToKeyStore) 
			throws KeyStoreException, NoSuchAlgorithmException, 
			CertificateException, IOException;
	
	/**
	 * Checks if any Keystore is already present. If Keystore is present it returns true.
	 * @return
	 */
	
	public Boolean isAvailable();
}