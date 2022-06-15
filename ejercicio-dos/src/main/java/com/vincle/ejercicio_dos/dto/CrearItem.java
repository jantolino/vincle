package com.vincle.ejercicio_dos.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vincle.ejercicio_dos.enume.EnvaseType;
import com.vincle.ejercicio_dos.enume.ItemType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearItem {

	@Schema(required = true, maxLength = 100, description = "Nombre del item", type = "String")
	@NotEmpty(message = "nombre is required")
	@Size(min= 5, max = 100)
	private String nombre;
	
	@Schema(required = true, description = "Tipo de Item", type = "ItemType")
	@NotNull(message = "tipoItem is required")
	private ItemType tipoItem;
	
	@Schema(required = true, description = "Indicador sobre si amerita refrigerio", type = "Boolean")
	@NotNull(message = "nevera is required")
	private Boolean nevera;
	
	@Schema(required = true, description = "Nombre del usuario que crea el item", type = "String")
	@NotEmpty(message = "usuarioCreador is required")	
	@Size(max = 50)
	private String usuarioCreador;
	
	@Schema(required = true, description = "peso en gramos del item", type = "List<Double>")
	@NotNull(message = "capacidad is required")
	private List<Double> capacidad = new ArrayList<>();
	
	@Schema(required = true, description = "tipo de envase del item", type = "List<EnvaseType>")
	@NotNull(message = "envase is required")
	private List<EnvaseType> envase  = new ArrayList<>();
}
