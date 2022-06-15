package com.vincle.ejercicio_dos.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vincle.ejercicio_dos.dto.Capacidad;
import com.vincle.ejercicio_dos.dto.ConsultarItem;
import com.vincle.ejercicio_dos.dto.CrearItem;
import com.vincle.ejercicio_dos.dto.Envase;
import com.vincle.ejercicio_dos.entity.CapacidadEntity;
import com.vincle.ejercicio_dos.entity.EnvaseEntity;
import com.vincle.ejercicio_dos.entity.ItemEntity;
import com.vincle.ejercicio_dos.enume.EnvaseType;
import com.vincle.ejercicio_dos.enume.StatusType;

@Component
public class ItemMapper {

	public ItemEntity convertirCrearItemEnItemEntity(CrearItem input) {

		ItemEntity output = new ItemEntity();
		output.setNombre(input.getNombre());
		output.setTipoItem(input.getTipoItem());
		output.setNevera(input.getNevera());
		output.setUsuarioCreador(input.getUsuarioCreador());
		output.setStatusType(StatusType.CREATED);
		output.setFechaRegistro(LocalDateTime.now());

		return output;
	}

	public EnvaseEntity convertirEnvaseTypeEnEnvaseEntity(Integer idItem, EnvaseType input) {

		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setId(idItem);

		EnvaseEntity output = new EnvaseEntity();
		output.setEnvaseType(input);
		output.setItemEntity(itemEntity);

		return output;
	}

	public CapacidadEntity convertirCapacidadEnCapacidadEntity(Integer idItem, Double input) {

		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setId(idItem);

		CapacidadEntity output = new CapacidadEntity();
		output.setCapacidadGr(input);
		output.setItemEntity(itemEntity);

		return output;
	}

	public List<ConsultarItem> convertirListItemEntityEnListConsultarItem(List<ItemEntity> input) {

		List<ConsultarItem> output = new ArrayList<>();
		ConsultarItem consultarItem = null;
		Capacidad capacidad = null;
		Envase envase = null;

		for (ItemEntity itemEntity : input) {
			
			List<Capacidad> capacidadList = new ArrayList<>();
			List<Envase> envaseList = new ArrayList<>();

			consultarItem = new ConsultarItem();
			consultarItem.setId(itemEntity.getId());
			consultarItem.setNevera(itemEntity.getNevera());
			consultarItem.setNombre(itemEntity.getNombre());
			consultarItem.setTipoItem(itemEntity.getTipoItem());
			consultarItem.setStatus(itemEntity.getStatusType());
			consultarItem.setUsuarioCreador(itemEntity.getUsuarioCreador());
			consultarItem.setFechaRegistro(itemEntity.getFechaRegistro());

			for (CapacidadEntity capacidadEntity : itemEntity.getCapacidad()) {
				capacidad = new Capacidad();
				capacidad.setId(capacidadEntity.getId());
				capacidad.setCapacidadGr(capacidadEntity.getCapacidadGr());

				capacidadList.add(capacidad);
			}

			for (EnvaseEntity envaseEntity : itemEntity.getEnvase()) {
				envase = new Envase();
				envase.setId(envaseEntity.getId());
				envase.setEnvaseType(envaseEntity.getEnvaseType());

				envaseList.add(envase);
			}

			consultarItem.setCapacidad(capacidadList);
			consultarItem.setEnvase(envaseList);			

			output.add(consultarItem);			
		}

		return output;
	}

	public ConsultarItem convertirItemEntityEnConsultarItem(ItemEntity input) {

		ConsultarItem output = null;
		List<Capacidad> capacidadList = new ArrayList<>();
		Capacidad capacidad = null;
		List<Envase> envaseList = new ArrayList<>();
		Envase envase = null;

		output = new ConsultarItem();
		output.setId(input.getId());
		output.setNevera(input.getNevera());
		output.setNombre(input.getNombre());
		output.setTipoItem(input.getTipoItem());
		output.setStatus(input.getStatusType());
		output.setUsuarioCreador(input.getUsuarioCreador());
		output.setFechaRegistro(input.getFechaRegistro());

		for (CapacidadEntity capacidadEntity : input.getCapacidad()) {
			capacidad = new Capacidad();
			capacidad.setId(capacidadEntity.getId());
			capacidad.setCapacidadGr(capacidadEntity.getCapacidadGr());

			capacidadList.add(capacidad);
		}

		for (EnvaseEntity envaseEntity : input.getEnvase()) {
			envase = new Envase();
			envase.setId(envaseEntity.getId());
			envase.setEnvaseType(envaseEntity.getEnvaseType());

			envaseList.add(envase);
		}

		output.setCapacidad(capacidadList);
		output.setEnvase(envaseList);

		return output;
	}	

	public EnvaseEntity convertirEnvaseEnEnvaseEntity(Integer idItem, Envase input) {

		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setId(idItem);

		EnvaseEntity output = new EnvaseEntity();
		output.setId(input.getId());
		output.setEnvaseType(input.getEnvaseType());
		output.setItemEntity(itemEntity);

		return output;
	}

	public CapacidadEntity convertirCapacidadEnCapacidadEntity(Integer idItem, Capacidad input) {

		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setId(idItem);

		CapacidadEntity output = new CapacidadEntity();
		output.setId(input.getId());
		output.setCapacidadGr(input.getCapacidadGr());
		output.setItemEntity(itemEntity);

		return output;
	}

}
