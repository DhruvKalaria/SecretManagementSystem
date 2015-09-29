package org.foreni.sms.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import org.foreni.sms.model.KeystoreProfile;

public class KeystoreUtils {

	public static void addKeystore(KeystoreProfile keystoreProfile) throws 
		KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException	{		
		KeyStore keyStore;
		keyStore = KeyStore.getInstance(keystoreProfile.getKeystoreType().toString());
		char[] password = keystoreProfile.getPassphrase().toCharArray();
		keyStore.load(null,password);
		FileOutputStream fos = new FileOutputStream("D:\\Keystore");
		keyStore.store(fos, password);
		fos.close();
	}
}