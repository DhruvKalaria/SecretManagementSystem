package org.foreni.sms.core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Date;

import javax.persistence.EntityManagerFactory;

import org.foreni.sms.model.Keystore;
import org.foreni.sms.repo.KeystoreRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * An implementation of {@link KeystoreManager}
 * 
 * @author ForenI.org
 * @version 1.0.0
 */

@Service
public class KeystoreManagerImpl implements KeystoreManager {
	
	@Autowired
	private KeystoreRepo keystoreRepo;
	
	public void createKeyStore(String type, String passphrase,
			String pathToKeyStore) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {

		KeyStore keyStore;
		keyStore = KeyStore.getInstance(type.toString());
		char[] password = passphrase.toCharArray();
		keyStore.load(null,password);
		FileOutputStream fos = new FileOutputStream(pathToKeyStore);
		keyStore.store(fos, password);
		fos.close();
		Keystore keyStoreProfile = new Keystore();
		keyStoreProfile.setKeystoreType(type);
		keyStoreProfile.setCreationDate(new Date());
		keystoreRepo.createKeyStore(keyStoreProfile);
	}

	public Boolean isAvailable() {
		return keystoreRepo.isKeystoreCreated();
	}
}