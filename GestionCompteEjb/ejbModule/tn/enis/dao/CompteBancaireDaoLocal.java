package tn.enis.dao;

import java.util.List;

import javax.ejb.Local;

import tn.enis.entity.CompteBancaire;

@Local
public interface CompteBancaireDaoLocal {

	void save(CompteBancaire compteBancaire);

	void update(CompteBancaire compte);

	void delete(Long rib);

	CompteBancaire getById(Long rib);

	List<CompteBancaire> getAll();

}
