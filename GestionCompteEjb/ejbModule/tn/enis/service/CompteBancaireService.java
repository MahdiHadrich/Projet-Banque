package tn.enis.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.enis.dao.ClientBanqueDaoLocal;
import tn.enis.dao.CompteBancaireDaoLocal;
import tn.enis.entity.ClientBanque;
import tn.enis.entity.CompteBancaire;


@Stateless
public class CompteBancaireService implements CompteBancaireServiceLocal {

	@EJB
	private CompteBancaireDaoLocal compteDao;

	@EJB
	private ClientBanqueDaoLocal clientDao;

	@Override
	public void save(CompteBancaire compteBancaire) {
		compteDao.save(compteBancaire);
	}

	@Override
	public void update(CompteBancaire compte) {
		
		CompteBancaire old = getById(compte.getRib());
		old.setClient(compte.getClient());
		old.setSolde(compte.getSolde());
		
		compteDao.update(compte);
	}

	@Override
	public void delete(Long rib) {
		compteDao.delete(rib);
	}

	@Override
	public CompteBancaire getById(Long rib) {
		return compteDao.getById(rib);
	}

	@Override
	public List<CompteBancaire> getAll() {
		return compteDao.getAll();
	}

	@Override
	public void save(float solde, Long cin) {

		ClientBanque client = clientDao.getById(cin);
		CompteBancaire compte = new CompteBancaire(client, solde);
		clientDao.update(client);
		compteDao.update(compte);

	}
}


