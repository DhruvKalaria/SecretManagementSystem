package org.foreni.sms.repo;

import org.foreni.sms.model.SecretKeyProfile;

public interface SecretKeyRepo {

	void saveSecretKeyProfile(SecretKeyProfile secretKeyProfile);
}