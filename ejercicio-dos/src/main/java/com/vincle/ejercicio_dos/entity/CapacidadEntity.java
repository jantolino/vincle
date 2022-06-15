package com.vincle.ejercicio_dos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CAPACIDAD")
public class CapacidadEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="CAPACIDAD_GR")
	private Double capacidadGr;
	
	@ManyToOne
	@JoinColumn(name = "ID_ITEM", updatable = false)
	private ItemEntity itemEntity;
}
