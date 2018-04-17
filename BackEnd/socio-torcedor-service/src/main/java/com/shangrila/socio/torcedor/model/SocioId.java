package com.shangrila.socio.torcedor.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the SocioId.")
public class SocioId implements Serializable {

	private static final long serialVersionUID = 7361349463510850651L;

	@ApiModelProperty(notes = "id can not be empty or null")
	private Integer idSoccerTeam;

	@ApiModelProperty(notes = "Soccer team id can not be empty or null")
	private String email;

	public Integer getIdSocio() {
		return idSoccerTeam;
	}

	public void setidSoccerTeam(Integer idSoccerTeam) {
		this.idSoccerTeam = idSoccerTeam;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		SocioId other = (SocioId) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idSoccerTeam == null) {
			if (other.idSoccerTeam != null)
				return false;
		} else if (!idSoccerTeam.equals(other.idSoccerTeam))
			return false;
		return true;
	}

}
