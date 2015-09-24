package org.foreni.sms.core;

import java.util.Date;

import org.foreni.sms.model.SecretKey;
import org.foreni.sms.model.SecretKey.SecretKeyAlgorithm;
import org.foreni.sms.model.SecretKey.SecretKeyStatus;
import org.foreni.sms.model.SecretKey.SecretKeyStrength;

public interface SecretKeyManager {

	/**
	 * Creates a Secret based on the parameters you provide. 
	 * Key Algorithms supported are - AES, DES, TDES, RSA
	 * Key Strength supported are - 56, 128, 256, 512, 1024
	 * Key Status supported are - ACTIVE, SUSPENDED, TERMINATED
	 * 
	 * @param keyId
	 * @param keyAlias
	 * @param keyStatus
	 * @param keyAlgorithm
	 * @param keyStrength
	 * @param isExtractable
	 * @param keyCreationTime
	 * @param keyExpirationTime
	 * @param keyOwner
	 * @return Key Object
	 */
	public SecretKey createKey(String keyId, String keyAlias, SecretKeyStatus keyStatus,
			SecretKeyAlgorithm keyAlgorithm, SecretKeyStrength keyStrength, boolean isExtractable,
			Date keyCreationTime, Date keyExpirationTime, String keyOwner);
	
}