package com.shangrila.socio.torcedor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the Clubes.")
@Entity
public class Clubes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(message = "Soccer team id can not be empty or null")
	@ApiModelProperty(notes = "Soccer team id can not be empty or null")
	private Integer idSoccerTeam;;

	@ApiModelProperty(notes = "Name od Clube")
	private String nomeClube;

	@ApiModelProperty(notes = "Apelido do Clube")
	private String descUsuario;

	public Clubes() {

	}

	public Integer getIdSoccerTeam() {
		return idSoccerTeam;
	}

	public void setIdSoccerTeam(Integer idSoccerTeam) {
		this.idSoccerTeam = idSoccerTeam;
	}

	public String getNomeClube() {
		return nomeClube;
	}

	public void setNomeClube(String nomeClube) {
		this.nomeClube = nomeClube;
	}

	public String getDescUsuario() {
		return descUsuario;
	}

	public void setDescUsuario(String descUsuario) {
		this.descUsuario = descUsuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Clubes [idSoccerTeam=" + idSoccerTeam + ", nomeClube=" + nomeClube + ", descUsuario=" + descUsuario
				+ "]";
	}

}
