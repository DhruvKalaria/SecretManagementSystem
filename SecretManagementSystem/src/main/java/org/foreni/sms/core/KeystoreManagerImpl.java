package org.foreni.sms.core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Date;

import javax.persistence.EntityManagerFactory;

import org.foreni.sms.model.KeystoreProfile;
import org.foreni.sms.model.KeystoreProfile.KeystoreType;
import org.foreni.sms.repo.KeystoreRepo;
import org.foreni.sms.utils.KeystoreUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * An implementation of {@link KeystoreManager}
 * 
 * @author ForenI.org
 * @version 1.0.0
 */

@Component
public class KeystoreManagerImpl implements KeystoreManager {
	
	@Autowired
	private KeystoreRepo keystoreRepo;
	
	public KeystoreRepo getKeystoreRepo() {
		return keystoreRepo;
	}

	public void setKeystoreRepo(KeystoreRepo keystoreRepo) {
		this.keystoreRepo = keystoreRepo;
	}

	public void createKeyStore(KeystoreProfile keystoreProfile)  {
		try {
			KeystoreUtils.addKeystore(keystoreProfile);
			getKeystoreRepo().saveKeystoreProfile(keystoreProfile);
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Boolean isAvailable() {
		//return keystoreRepo.isKeystoreCreated();
		return null;
	}

}