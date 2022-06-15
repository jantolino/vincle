package com.vincle.ejercicio_dos.service;

import java.util.List;

import com.vincle.ejercicio_dos.dto.ActualizarItem;
import com.vincle.ejercicio_dos.dto.ConsultarItem;
import com.vincle.ejercicio_dos.dto.CrearItem;

public interface ItemService {
	
	Boolean crearItem(CrearItem crearItem);
	
	List<ConsultarItem> consultarTodosLosItems();
	
	ConsultarItem consultarItem(Integer id);
	
	Boolean actualizarItem(ActualizarItem actualizarItem);
	
	Boolean borrarItem(Integer id);
}
