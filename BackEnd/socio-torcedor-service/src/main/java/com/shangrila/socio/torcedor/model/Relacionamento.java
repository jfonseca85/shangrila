package com.shangrila.socio.torcedor.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the Campaing.")
@Entity
@IdClass(value=IdRelacionamento.class)
public class Relacionamento extends ResourceSupport  {
	
	@Id
	@NotNull(message = "Soccer team id can not be empty or null")
	private Integer idCampaing;
	
	@Id
	@NotNull(message = "Soccer team id can not be empty or null")
	@ApiModelProperty(notes = "Soccer team id can not be empty or null")
	private Integer idSoccerTeam;

	@ApiModelProperty(notes = "Campaign start date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateStartCampaing;

	@ApiModelProperty(notes = "Campaign end date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateEndCampaing;
	
	@ApiModelProperty(notes = "Nome da Campanha")
	private String nomeCampanha;


	public Relacionamento() {
		super();
	}


	public String getNomeCampanha() {
		return nomeCampanha;
	}


	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha =  nomeCampanha;
	}



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

	public LocalDate getDateStartCampaing() {
		return dateStartCampaing;
	}


	public void setDateStartCampaing(LocalDate dateStartCampaing) {
		this.dateStartCampaing = dateStartCampaing;
	}


	public LocalDate getDateEndCampaing() {
		return dateEndCampaing;
	}


	public void setDateEndCampaing(LocalDate dateEndCampaing) {
		this.dateEndCampaing = dateEndCampaing;
	}
	
	
	@Override
	public String toString() {
		return "Relacionamento [idCampaing=" + idCampaing + ", idSoccerTeam=" + idSoccerTeam +  ", dateStartCampaing=" + dateStartCampaing + ", dateEndCampaing=" + dateEndCampaing
				+ ", nomeCampanha=" + nomeCampanha + "]";
	}
	

}
