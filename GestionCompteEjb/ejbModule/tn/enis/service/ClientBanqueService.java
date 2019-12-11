package tn.enis.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.enis.dao.ClientBanqueDaoLocal;
import tn.enis.entity.ClientBanque;


@Stateless
public class ClientBanqueService implements ClientBanqueServiceLocal {

	@EJB
	private ClientBanqueDaoLocal clientDao;

	@Override
	public void save(ClientBanque client) {
		clientDao.save(client);

	}

	@Override
	public void update(ClientBanque client) {
		
		ClientBanque old = getById(client.getCin());
		old.setNom(client.getNom());
		old.setPrenom(client.getPrenom());
		old.setAdresse(client.getAdresse());
		
		clientDao.update(client);

	}

	@Override
	public void delete(Long cin) {
		clientDao.delete(cin);

	}

	@Override
	public ClientBanque getById(Long cin) {
		return clientDao.getById(cin);
	}

	@Override
	public List<ClientBanque> getAll() {
		return clientDao.getAll();
	}

	public String clientAutoComplete() {
		StringBuilder clientDto = new StringBuilder("");
		for (ClientBanque entity : getAll()) {
			clientDto.append("{ \"value\" : \"" + entity.getNom() + " " + entity.getPrenom() + "\",");
			clientDto.append("\"label\" : \"" + entity.getNom() + " " + entity.getPrenom() + "\",");
			clientDto.append("\"id\" : \"" + entity.getCin() + "\"},");
		}
		clientDto.deleteCharAt(clientDto.length() - 1);
		return clientDto.toString();
	}

}
