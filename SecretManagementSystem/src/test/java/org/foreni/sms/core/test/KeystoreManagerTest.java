package org.foreni.sms.core.test;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import org.foreni.sms.core.KeystoreManager;
import org.foreni.sms.core.KeystoreManagerImpl;
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
		try {
			AbstractApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
			KeystoreManager km = (KeystoreManager)cxt.getBean("keystoreManagerImpl");
			km.createKeyStore(keyStoreType, passphrase, pathToKeyStore);
			//keyStore.createKeyStore(keyStoreType, passphrase, pathToKeyStore);
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
	
	/*@Test
	public void isKeystoreAvailableTest()	{
		AbstractApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		KeystoreManager km = (KeystoreManager)cxt.getBean("keystoreManagerImpl");
		Assert.assertTrue("Keystore not available", km.isAvailable());
	}*/
}