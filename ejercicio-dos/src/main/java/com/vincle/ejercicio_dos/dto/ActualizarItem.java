package com.vincle.ejercicio_dos.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vincle.ejercicio_dos.enume.ItemType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ActualizarItem {
	
	@Schema(required = true, description = "identificador del item", type = "Integer")
	@NotNull(message = "id is required")
	private Integer id;
	
	@Schema(required = true, maxLength = 50, description = "Nombre del item", type = "String")
	@NotEmpty(message = "nombre is required")
	@Size(max = 100)
	private String nombre;
	
	@Schema(required = true, description = "Tipo de Item", type = "ItemType")
	@NotNull(message = "tipoItem is required")
	private ItemType tipoItem;
	
	@Schema(required = true, description = "Indicador sobre si amerita refrigerio", type = "Boolean")
	@NotNull(message = "nevera is required")
	private Boolean nevera;
	
	@Schema(required = true, description = "peso en gramos del item", type = "List<Capacidad>")
	@NotNull(message = "capacidad is required")
	private List<Capacidad> capacidad = new ArrayList<>();
	
	@Schema(required = true, description = "tipo de envase del item", type = "List<Envase>")
	@NotNull(message = "envase is required")
	private List<Envase> envase  = new ArrayList<>();
}
