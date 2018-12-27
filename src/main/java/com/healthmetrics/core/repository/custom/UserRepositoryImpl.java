package com.healthmetrics.core.repository.custom;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public boolean savePasswordRecoveryToken(String email, String token) {
		//@formatter:off
		String sql = "UPDATE user SET recovery_token = ? WHERE email = ?";
		//@formatter:on

		Query query = em.createNativeQuery(sql);
		query.setParameter(1, token);
		query.setParameter(2, email);

		return (query.executeUpdate() == 1);
	}

	@Override
	public boolean checkPasswordRecoveryToken(Long idUser, String token) {
		// @formatter:off
		String sql = "SELECT COUNT(*) FROM user WHERE id = ? AND recovery_token = ?";
		// @formatter:on

		Query query = em.createNativeQuery(sql);
		query.setParameter(1, idUser);
		query.setParameter(2, token);

		BigInteger count = (BigInteger) query.getSingleResult();

		return (count.intValue() > 0);
	}

	@Override
	@Transactional
	public void saveNewPasswordAndClearToken(String email, String password) {
		//@formatter:off
		 String sql = "UPDATE user SET password = ?, recovery_token = NULL WHERE email = ?";
		 //@formatter:on

		Query query = em.createNativeQuery(sql);
		query.setParameter(1, password);
		query.setParameter(2, email);

		query.executeUpdate();
	}

}
