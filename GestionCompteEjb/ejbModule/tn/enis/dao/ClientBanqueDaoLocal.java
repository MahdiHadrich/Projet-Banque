package tn.enis.dao;

import java.util.List;

import javax.ejb.Local;

import tn.enis.entity.ClientBanque;

@Local
public interface ClientBanqueDaoLocal {
	void save(ClientBanque client);

	void update(ClientBanque client);

	void delete(Long cin);

	ClientBanque getById(Long cin);

	List<ClientBanque> getAll();
}
