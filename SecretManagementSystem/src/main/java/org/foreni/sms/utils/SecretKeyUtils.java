package org.foreni.sms.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.foreni.sms.model.KeystoreProfile;
import org.foreni.sms.model.SecretKeyProfile;

public class SecretKeyUtils {

	public static SecretKey addSecretKey(SecretKeyProfile secretKeyProfile) throws 
		NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException	{
		
		javax.crypto.SecretKey secretKey;
		KeyGenerator keyGenerator = KeyGenerator.getInstance(secretKeyProfile.getKeyAlgorithm().toString());
		keyGenerator.init(secretKeyProfile.getKeyStrength().getSecretKeyStrength());
		secretKey = keyGenerator.generateKey();
		return secretKey;
	}
}
