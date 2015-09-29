package org.foreni.sms.core;

import java.security.KeyStore;
import java.util.Date;

import javax.crypto.KeyGenerator;

import org.foreni.sms.model.KeystoreProfile;
import org.foreni.sms.model.SecretKey;
import org.foreni.sms.model.SecretKey.SecretKeyAlgorithm;
import org.foreni.sms.model.SecretKey.SecretKeyStatus;
import org.foreni.sms.model.SecretKey.SecretKeyStrength;
import org.foreni.sms.repo.KeystoreRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class SecretKeyManagerImpl implements SecretKeyManager {

	@Autowired
	private KeystoreRepo keystoreRepo;
	
	@Autowired
	private KeystoreProfile keystore;

	public SecretKey createKey(String keyId, String keyAlias,
			SecretKeyStatus keyStatus, SecretKeyAlgorithm keyAlgorithm,
			SecretKeyStrength keyStrength, boolean isExtractable,
			Date keyCreationTime, Date keyExpirationTime, String keyOwner) {
		
		javax.crypto.SecretKey secretKey;
		KeyStore.SecretKeyEntry secretKeyEntry;
		KeyStore.ProtectionParameter protectionParameter;
		
		KeyGenerator keyGenerator = KeyGenerator.getInstance(keyAlgorithm.toString());
		keyGenerator.init(keyStrength.getSecretKeyStrength());
		secretKey = keyGenerator.generateKey();
		protectionParameter = new KeyStore.PasswordProtection(keystore.getPassphrase().toCharArray());
		secretKeyEntry = new KeyStore.SecretKeyEntry(secretKey);
		keystore.setEntry("xyz", secretKeyEntry,protectionParameter);
		
		return null;
	}
	
	
}
