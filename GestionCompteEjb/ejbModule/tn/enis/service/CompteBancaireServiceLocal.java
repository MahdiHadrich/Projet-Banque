package tn.enis.service;

import java.util.List;

import javax.ejb.Local;

import tn.enis.entity.CompteBancaire;

@Local
public interface CompteBancaireServiceLocal {
	void save(CompteBancaire compteBancaire);

	void update(CompteBancaire compte);

	void delete(Long rib);

	CompteBancaire getById(Long rib);

	List<CompteBancaire> getAll();

	void save(float solde, Long cin);
}
