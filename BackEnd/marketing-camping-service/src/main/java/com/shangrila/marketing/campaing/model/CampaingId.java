package com.shangrila.marketing.campaing.model;

import java.io.Serializable;

public class CampaingId implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer idCampaing;

	private Integer idSoccerTeam;

	public Integer getIdCampaing() {
		return idCampaing;
	}

	public void setIdCampaing(Integer idCampaing) {
		this.idCampaing = idCampaing;
	}

	public Integer getIdSoccerTeam() {
		return idSoccerTeam;
	}

	public void setIdSoccerTeam(Integer idSoccerTeam) {
		this.idSoccerTeam = idSoccerTeam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCampaing == null) ? 0 : idCampaing.hashCode());
		result = prime * result + ((idSoccerTeam == null) ? 0 : idSoccerTeam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampaingId other = (CampaingId) obj;
		if (idCampaing == null) {
			if (other.idCampaing != null)
				return false;
		} else if (!idCampaing.equals(other.idCampaing))
			return false;
		if (idSoccerTeam == null) {
			if (other.idSoccerTeam != null)
				return false;
		} else if (!idSoccerTeam.equals(other.idSoccerTeam))
			return false;
		return true;
	}
	
	
}
