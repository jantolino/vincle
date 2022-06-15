package com.vincle.ejercicio_dos.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vincle.ejercicio_dos.enume.ItemType;
import com.vincle.ejercicio_dos.enume.StatusType;

import lombok.Data;

@Data
@Entity
@Table(name = "ITEM")
public class ItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name = "NOMBRE", length = 100)
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_ITEM", length = 10)
	private ItemType tipoItem;
	
	@Column(name = "NEVERA")
	private Boolean nevera;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", length = 10)
	private StatusType statusType;
	
	@Column(name = "USUARIO_CREADOR", length = 50)
	private String usuarioCreador;
	
	@Column(name = "FECHA_REGISTRO")
	private LocalDateTime fechaRegistro;
	
	@OneToMany(mappedBy = "itemEntity", cascade = CascadeType.ALL)
	private List<CapacidadEntity> capacidad;
	
	@OneToMany(mappedBy = "itemEntity", cascade = CascadeType.ALL)
	private List<EnvaseEntity> envase;
	
	
}
