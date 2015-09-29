package org.foreni.sms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="keystore_profile")
public class KeystoreProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "keystore_type")
	@Enumerated(EnumType.STRING)
	//@Lob - Used for large data hold String - CLOB and Byte[] it is BLOB
	private KeystoreType keystoreType;
	
	@Column(name = "creation_time")
	//@Temporal(TemporalType.DATE) - Used if either ts/date/time is required
	private Date creationDate;
	
	@Column(name = "passphrase")
	private String passphrase;
	
	public String getPassphrase() {
		return passphrase;
	}
	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public KeystoreType getKeystoreType() {
		return keystoreType;
	}
	public void setKeystoreType(KeystoreType keystoreType) {
		this.keystoreType = keystoreType;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public enum KeystoreType	{
		JKS("JKS"), JCEKS("JCEKS");
		
		String type;
		
		KeystoreType(String type)	{
			this.type = type;
		}
		
		String getKeystoreType()	{
			return type;
		}
		
	}
	
	public KeystoreProfile() {
		super();
	}
	public KeystoreProfile(long id, KeystoreType keystoreType, Date creationDate,
			String passphrase) {
		super();
		this.id = id;
		this.keystoreType = keystoreType;
		this.creationDate = creationDate;
		this.passphrase = passphrase;
	}
	
	@Override
	public String toString() {
		return "Keystore [getPassphrase()=" + getPassphrase() + ", getId()="
				+ getId() + ", getKeystoreType()=" + getKeystoreType()
				+ ", getCreationDate()=" + getCreationDate() + "]";
	}

}