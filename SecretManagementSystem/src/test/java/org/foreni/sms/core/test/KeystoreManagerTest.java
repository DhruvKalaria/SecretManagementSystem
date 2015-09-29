package org.foreni.sms.core.test;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Date;

import org.foreni.sms.core.KeystoreManager;
import org.foreni.sms.core.KeystoreManagerImpl;
import org.foreni.sms.model.KeystoreProfile;
import org.foreni.sms.model.KeystoreProfile.KeystoreType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class KeystoreManagerTest {

	KeystoreManager keyStore = new KeystoreManagerImpl();
	String keyStoreType = "JKS";
	String passphrase = "abcde";
	String pathToKeyStore = "D:\\Keystore";
	
	
	@Test
	public void createKeyStoreTest() {
		
			AbstractApplicationContext cxt = new ClassPathXmlApplicationContext("spring-config.xml");
			KeystoreManager km = (KeystoreManager)cxt.getBean("keystoreManagerImpl");
			
			KeystoreProfile keystoreProfile = new KeystoreProfile();
			keystoreProfile.setKeystoreType(KeystoreType.JKS);
			keystoreProfile.setPassphrase(passphrase);
			keystoreProfile.setCreationDate(new Date());
			
			km.createKeyStore(keystoreProfile);
	}
	
	/*@Test
	public void isKeystoreAvailableTest()	{
		AbstractApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		KeystoreManager km = (KeystoreManager)cxt.getBean("keystoreManagerImpl");
		Assert.assertTrue("Keystore not available", km.isAvailable());
	}*/
}