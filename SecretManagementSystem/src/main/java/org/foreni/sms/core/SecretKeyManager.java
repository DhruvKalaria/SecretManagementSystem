package org.foreni.sms.core;

import javax.crypto.SecretKey;

import org.foreni.sms.model.SecretKeyProfile;

public interface SecretKeyManager {

	/**
	 * Creates a Secret based on the parameters you provide. 
	 * Key Algorithms supported are - AES, DES, TDES, RSA
	 * Key Strength supported are - 56, 128, 256, 512, 1024
	 * Key Status supported are - ACTIVE, SUSPENDED, TERMINATED
	 * 
	 * @return Key Object
	 */
	public SecretKey createKey(SecretKeyProfile secretKey);
	
}