package tn.enis.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.enis.entity.ClientBanque;

@Singleton
public class ClientBanqueDao implements ClientBanqueDaoLocal {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(ClientBanque client) {
		entityManager.persist(client);

	}

	@Override
	public void update(ClientBanque client) {
		entityManager.merge(client);

	}

	@Override
	public void delete(Long cin) {
		entityManager.remove(getById(cin));

	}

	@Override
	public ClientBanque getById(Long cin) {
		return entityManager.find(ClientBanque.class, cin);
	}

	@Override
	public List<ClientBanque> getAll() {
		return entityManager.createQuery("from ClientBanque", ClientBanque.class).getResultList();
	}

}
