package org.foreni.sms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="secretkey_profile")
public class SecretKey {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String keyId;
	
	@Column(unique=true)
	private String keyAlias;
	
	@Enumerated(EnumType.STRING)
	private SecretKeyStatus keyStatus;
	
	@Enumerated(EnumType.STRING)
	private SecretKeyAlgorithm keyAlgorithm;
	
	@Enumerated(EnumType.STRING)
	private SecretKeyStrength keyStrength;
	
	private boolean isExtractable;
	
	private Date keyCreationTime;
	
	private Date keyExpirationTime;
	
	private String keyOwner;
	
	public SecretKey(String keyId, String keyAlias, SecretKeyStatus keyStatus,
			SecretKeyAlgorithm keyAlgorithm, SecretKeyStrength keyStrength, boolean isExtractable,
			Date keyCreationTime, Date keyExpirationTime, String keyOwner) {
		super();
		this.keyId = keyId;
		this.keyAlias = keyAlias;
		this.keyStatus = keyStatus;
		this.keyAlgorithm = keyAlgorithm;
		this.keyStrength = keyStrength;
		this.isExtractable = isExtractable;
		this.keyCreationTime = keyCreationTime;
		this.keyExpirationTime = keyExpirationTime;
		this.keyOwner = keyOwner;
	}
	
	public SecretKey() {
		super();
	}
	public String getKeyId() {
		return keyId;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
	public String getKeyAlias() {
		return keyAlias;
	}
	public void setKeyAlias(String keyAlias) {
		this.keyAlias = keyAlias;
	}
	public SecretKeyStatus getKeyStatus() {
		return keyStatus;
	}
	public void setKeyStatus(SecretKeyStatus keyStatus) {
		this.keyStatus = keyStatus;
	}
	public SecretKeyAlgorithm getKeyAlgorithm() {
		return keyAlgorithm;
	}
	public void setKeyAlgorithm(SecretKeyAlgorithm keyAlgorithm) {
		this.keyAlgorithm = keyAlgorithm;
	}
	public SecretKeyStrength getKeyStrength() {
		return keyStrength;
	}
	public void setKeyStrength(SecretKeyStrength keyStrength) {
		this.keyStrength = keyStrength;
	}
	public boolean isExtractable() {
		return isExtractable;
	}
	public void setExtractable(boolean isExtractable) {
		this.isExtractable = isExtractable;
	}
	public Date getKeyCreationTime() {
		return keyCreationTime;
	}
	public void setKeyCreationTime(Date keyCreationTime) {
		this.keyCreationTime = keyCreationTime;
	}
	public Date getKeyExpirationTime() {
		return keyExpirationTime;
	}
	public void setKeyExpirationTime(Date keyExpirationTime) {
		this.keyExpirationTime = keyExpirationTime;
	}
	public String getKeyOwner() {
		return keyOwner;
	}
	public void setKeyOwner(String keyOwner) {
		this.keyOwner = keyOwner;
	}

	public enum SecretKeyStatus {
		ACTIVE, SUSPENDED, EXPIRED;
	}
	
	public enum SecretKeyAlgorithm {
		DES, RSA, AES, TDES;
	}

	public enum SecretKeyStrength {
		
		BITS_56 (56) , BITS_128 (128), BITS_256(256), BITS_512(512) , BITS_1024(1024);
		
		int SecretKeyStrength;

		private SecretKeyStrength(int keyStrength) {
			this.SecretKeyStrength = keyStrength;
		}
		public int getSecretKeyStrength() {
			return this.SecretKeyStrength;
		}
	}
	
	@Override
	public String toString() {
		return "SecretKey [getKeyId()=" + getKeyId() + ", getKeyAlias()="
				+ getKeyAlias() + ", getKeyStatus()=" + getKeyStatus()
				+ ", getKeyAlgorithm()=" + getKeyAlgorithm()
				+ ", getKeyStrength()=" + getKeyStrength()
				+ ", isExtractable()=" + isExtractable()
				+ ", getKeyCreationTime()=" + getKeyCreationTime()
				+ ", getKeyExpirationTime()=" + getKeyExpirationTime()
				+ ", getKeyOwner()=" + getKeyOwner() + "]";
	}
}
