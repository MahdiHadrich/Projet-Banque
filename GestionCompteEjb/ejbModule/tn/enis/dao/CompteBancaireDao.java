package tn.enis.dao;


import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.enis.entity.CompteBancaire;


@Singleton
public class CompteBancaireDao implements CompteBancaireDaoLocal {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(CompteBancaire compteBancaire) {
		entityManager.merge(compteBancaire);
	}

	@Override
	public void update(CompteBancaire compte) {
		entityManager.merge(compte);
	}

	@Override
	public void delete(Long rib) {
		entityManager.remove(getById(rib));

	}

	@Override
	public CompteBancaire getById(Long rib) {
		return entityManager.find(CompteBancaire.class, rib);
	}

	@Override
	public List<CompteBancaire> getAll() {
		return entityManager.createQuery("from CompteBancaire", CompteBancaire.class).getResultList();
	}

}
