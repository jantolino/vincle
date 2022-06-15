package com.vincle.ejercicio_dos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vincle.ejercicio_dos.enume.EnvaseType;

import lombok.Data;

@Data
@Entity
@Table(name = "ENVASE")
public class EnvaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_ENVASE", length = 10)
	private EnvaseType envaseType;
	
	@ManyToOne
	@JoinColumn(name = "ID_ITEM", updatable = false)
	private ItemEntity itemEntity;
}
