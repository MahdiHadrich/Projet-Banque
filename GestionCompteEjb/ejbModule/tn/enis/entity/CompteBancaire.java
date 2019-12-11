package tn.enis.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_compte")

public class CompteBancaire implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rib;
	private String client;
	private float solde;

	public CompteBancaire(Long rib, String client, float solde) {
		super();
		this.rib = rib;
		this.client = client;
		this.solde = solde;
	}

	public CompteBancaire(String client, float solde) {
		super();
		this.client = client;
		this.solde = solde;
	}

	public CompteBancaire() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rib == null) ? 0 : rib.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CompteBancaire other = (CompteBancaire) obj;
		if (rib == null) {
			if (other.rib != null) {
				return false;
			}
		} else if (!rib.equals(other.rib)) {
			return false;
		}
		return true;
	}

	public Long getRib() {
		return rib;
	}

	public void setRib(Long rib) {
		this.rib = rib;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}
}
