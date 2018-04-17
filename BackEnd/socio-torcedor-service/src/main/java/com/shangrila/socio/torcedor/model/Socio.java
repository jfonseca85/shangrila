package com.shangrila.socio.torcedor.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.Email;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the Socio.")
@Entity
@IdClass(value = SocioId.class)
public class Socio extends ResourceSupport {
	
	@Id
	@Email(message = "Please enter a Valid Email")
	@ApiModelProperty(notes = "Soccer team id can not be empty or null")
	@JsonFormat
	private String email;

	@Id
	@ApiModelProperty(notes = "Soccer team id can not be empty or null")
	@JsonFormat
	private Integer idSoccerTeam;

	@ApiModelProperty(notes = "Name of the football team")
	@JsonFormat
	private String nameSoccer;

	@ApiModelProperty(notes = "Birthday date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateBirthday;

	public Socio() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdSoccerTeam() {
		return idSoccerTeam;
	}

	public void setIdSoccerTeam(Integer idSoccerTeam) {
		this.idSoccerTeam = idSoccerTeam;
	}

	public String getNameSoccer() {
		return nameSoccer;
	}

	public void setNameSoccer(String nameSoccer) {
		this.nameSoccer = nameSoccer;
	}

	public LocalDate getDateBirthday() {
		return dateBirthday;
	}

	public void setDateBirthday(LocalDate dateBirthday) {
		this.dateBirthday = dateBirthday;
	}

	@Override
	public String toString() {
		return "Socio [email=" + email + ", idSoccerTeam=" + idSoccerTeam + ", nameSoccer=" + nameSoccer
				  + ", dateBirthday=" + dateBirthday + "]";
	}

	
}
