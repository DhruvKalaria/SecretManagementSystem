package org.foreni.sms.core;

import java.io.IOException;

import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.crypto.SecretKey;
import org.foreni.sms.model.SecretKeyProfile;
import org.foreni.sms.repo.SecretKeyRepo;
import org.foreni.sms.utils.SecretKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecretKeyManagerImpl implements SecretKeyManager {

	@Autowired
	SecretKeyRepo secretKeyRepo;
	
	public SecretKeyRepo getSecretKeyRepo() {
		return secretKeyRepo;
	}

	public void setSecretKeyRepo(SecretKeyRepo secretKeyRepo) {
		this.secretKeyRepo = secretKeyRepo;
	}

	public SecretKey createKey(SecretKeyProfile secretKeyProfile) {
		
		SecretKey secretKey;
		try {
			secretKey = SecretKeyUtils.addSecretKey(secretKeyProfile);
			getSecretKeyRepo().saveSecretKeyProfile(secretKeyProfile);
			return secretKey;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
}
