package com.cda.jee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address",
	uniqueConstraints = @UniqueConstraint(columnNames = "code_postal") 
		)
public class Adresse {
	@Id
	private String rue;
	
	@Column(name = "code_postal", nullable = false)
	private String codePostal;
	
	private String ville;
	@ManyToOne
	@JoinColumn(name="personne_id")
	private Personne personne;
}
