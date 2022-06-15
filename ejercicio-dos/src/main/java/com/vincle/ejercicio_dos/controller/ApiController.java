package com.vincle.ejercicio_dos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vincle.ejercicio_dos.dto.ActualizarItem;
import com.vincle.ejercicio_dos.dto.ConsultarItem;
import com.vincle.ejercicio_dos.dto.CrearItem;
import com.vincle.ejercicio_dos.service.ItemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Item API")
@RestController
@RequestMapping("item")
public class ApiController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping
	@Operation(description = "Crea un item")
	public Boolean crearItem(@Validated @RequestBody CrearItem crearItem) {
		return itemService.crearItem(crearItem);
	}
	
	@GetMapping
	@Operation(description = "Consulta todos los items")
	public List<ConsultarItem> consultarTodosLosItems() {
		return itemService.consultarTodosLosItems();
	}
	
	@GetMapping("/{id}")
	@Operation(description = "Consulta item por id")
	public ConsultarItem consultarItem(
			@Parameter(required = true, name = "id")
			@PathVariable("id") Integer id) {
		return itemService.consultarItem(id);
	}
	
	@PutMapping
	@Operation(description = "Actualiza un item")
	public Boolean actualizarItem(@Validated @RequestBody ActualizarItem actualizarItem) {
		return itemService.actualizarItem(actualizarItem);
	}
	
	@DeleteMapping("/{id}")
	@Operation(description = "Elimina un item a traves del id")
	public Boolean borrarItem(
			@Parameter(required = true, name = "id")
			@PathVariable("id") Integer id) {
		return itemService.borrarItem(id);
	}

}
