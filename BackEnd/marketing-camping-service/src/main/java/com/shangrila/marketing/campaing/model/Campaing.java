package com.shangrila.marketing.campaing.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the Campaing.")
@Entity
public class Campaing  extends ResourceSupport{

	@Id
	@GeneratedValue
	@ApiModelProperty(notes = "Id da Campanha")
	@JsonFormat
	private Integer idCampaing;
	@JsonFormat
	private String porta;

	@NotNull(message = "Soccer team id can not be empty or null")
	@ApiModelProperty(notes = "Soccer team id can not be empty or null")
	@JsonFormat
	private Integer idSoccerTeam;
	
	@ApiModelProperty(notes = "Descrição da Campanha")
	@JsonFormat
	private String nomeCampanha;

	@ApiModelProperty(notes = "Campaign start date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate  dateStartCampaing;

	@ApiModelProperty(notes = "Campaign end date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate  dateEndCampaing;
	
	public Campaing() {
		super();
	}

	public Campaing(Integer idCampaing, Integer idSoccerTeam, LocalDate  dateStartCampaing, LocalDate  dateEndCampaing) {
		super();
		this.idCampaing = idCampaing;
		this.idSoccerTeam = idSoccerTeam;
		this.dateStartCampaing = dateStartCampaing;
		this.dateEndCampaing = dateEndCampaing;
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

	public LocalDate  getDateStartCampaing() {
		return dateStartCampaing;
	}

	public void setDateStartCampaing(LocalDate  dateStartCampaing) {
		this.dateStartCampaing = dateStartCampaing;
	}

	public LocalDate  getDateEndCampaing() {
		return dateEndCampaing;
	}

	public void setDateEndCampaing(LocalDate  dateEndCampaing) {
		this.dateEndCampaing = dateEndCampaing;
	}

	@Override
	public String toString() {
		return "Campaing [idCampaing=" + idCampaing + ", idSoccerTeam=" + idSoccerTeam + ", dateStartCampaing="
				+ dateStartCampaing + ", dateEndCampaing=" + dateEndCampaing + "]";
	}

	public String getNomeCampanha() {
		return nomeCampanha;
	}

	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}
}
