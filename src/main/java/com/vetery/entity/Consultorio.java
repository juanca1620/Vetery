package com.vetery.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "consultorio")
@Data
public class Consultorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "no_consultorio",nullable = false)
	private Byte bnoConsultorio;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "veterinaria_id",nullable = false)
	private Veterinaria veterinaria;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "veterinario_id")
	private Veterinario veterinario;
	
	@OneToOne(cascade = CascadeType.ALL,fetch =  FetchType.LAZY)
	@JoinColumn(name = "agenda_id")
	private Agenda agenda;
}
