package com.vincle.ejercicio_dos.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.vincle.ejercicio_dos.enume.ItemType;
import com.vincle.ejercicio_dos.enume.StatusType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ConsultarItem {

	@Schema(description = "identificador del item", type = "Integer")	
	private Integer id;
	
	@Schema(maxLength = 50, description = "Nombre del item", type = "String")	
	private String nombre;
	
	@Schema(description = "Tipo de Item", type = "ItemType")	
	private ItemType tipoItem;
	
	@Schema(description = "Indicador sobre si amerita refrigerio", type = "Boolean")	
	private Boolean nevera;
	
	@Schema(description = "Status del producto en la base de datos", type = "StatusType")
	private StatusType status;
	
	@Schema(description = "Nombre del usuario que crea el item", type = "String")	
	private String usuarioCreador;
	
	@Schema(description = "Fecha en que se crea el item", type = "LocalDateTime")
	private LocalDateTime fechaRegistro;
	
	@Schema(description = "peso en gramos del item", type = "List<Capacidad>")	
	private List<Capacidad> capacidad = new ArrayList<>();
	
	@Schema(description = "tipo de envase del item", type = "List<Envase>")	
	private List<Envase> envase  = new ArrayList<>();
}
