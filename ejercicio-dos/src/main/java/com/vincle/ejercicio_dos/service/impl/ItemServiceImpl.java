package com.vincle.ejercicio_dos.service.impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vincle.ejercicio_dos.dto.ActualizarItem;
import com.vincle.ejercicio_dos.dto.Capacidad;
import com.vincle.ejercicio_dos.dto.ConsultarItem;
import com.vincle.ejercicio_dos.dto.CrearItem;
import com.vincle.ejercicio_dos.dto.Envase;
import com.vincle.ejercicio_dos.entity.CapacidadEntity;
import com.vincle.ejercicio_dos.entity.EnvaseEntity;
import com.vincle.ejercicio_dos.entity.ItemEntity;
import com.vincle.ejercicio_dos.enume.EnvaseType;
import com.vincle.ejercicio_dos.enume.StatusType;
import com.vincle.ejercicio_dos.exception.InternalServerException;
import com.vincle.ejercicio_dos.exception.ResourceNotFoundException;
import com.vincle.ejercicio_dos.mapper.ItemMapper;
import com.vincle.ejercicio_dos.repository.CapacidadRepository;
import com.vincle.ejercicio_dos.repository.EnvaseRepository;
import com.vincle.ejercicio_dos.repository.ItemRepository;
import com.vincle.ejercicio_dos.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper mapper;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private EnvaseRepository envaseRepository;

	@Autowired
	private CapacidadRepository capacidadRepository;

	@Override
	@Transactional
	public Boolean crearItem(CrearItem crearItem) {

		ItemEntity itemEntity = null;
		EnvaseEntity envaseEntity = null;
		CapacidadEntity capacidadEntity = null;

		try {
			itemEntity = mapper.convertirCrearItemEnItemEntity(crearItem);
			itemEntity = itemRepository.save(itemEntity);

			for (EnvaseType envaseType : crearItem.getEnvase()) {
				envaseEntity = mapper.convertirEnvaseTypeEnEnvaseEntity(itemEntity.getId(), envaseType);
				envaseRepository.save(envaseEntity);
			}

			for (Double capacidadInput : crearItem.getCapacidad()) {
				capacidadEntity = mapper.convertirCapacidadEnCapacidadEntity(itemEntity.getId(), capacidadInput);
				capacidadRepository.save(capacidadEntity);
			}

			return true;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@Override
	public List<ConsultarItem> consultarTodosLosItems() {

		List<ItemEntity> itemEntities = null;
		List<ConsultarItem> listConsultarItem = null;

		try {
			itemEntities = itemRepository.findAll().stream().filter(i -> !i.getStatusType().equals(StatusType.DELETED))
					.collect(Collectors.toList());
			listConsultarItem = mapper.convertirListItemEntityEnListConsultarItem(itemEntities);
			return listConsultarItem;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@Override
	public ConsultarItem consultarItem(Integer id) {
		
		ConsultarItem consultarItem = null;

		ItemEntity itemEntity = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(
						MessageFormat.format("No se encontaron resultados por el id: {0}", id)));
		
		try {
			consultarItem = mapper.convertirItemEntityEnConsultarItem(itemEntity);
			return consultarItem;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Boolean actualizarItem(ActualizarItem actualizarItem) {
		
		EnvaseEntity envaseEntity = null;
		CapacidadEntity capacidadEntity = null;

		ItemEntity itemEntity = itemRepository.findById(actualizarItem.getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						MessageFormat.format("No se encontaron resultados por el id: {0}", actualizarItem.getId())));
		
		try {
			itemEntity.setNombre(actualizarItem.getNombre());
			itemEntity.setTipoItem(actualizarItem.getTipoItem());
			itemEntity.setNevera(actualizarItem.getNevera());
			itemRepository.save(itemEntity);

			for (Envase envase : actualizarItem.getEnvase()) {
				envaseEntity = mapper.convertirEnvaseEnEnvaseEntity(actualizarItem.getId(), envase);
				envaseRepository.save(envaseEntity);
			}

			for (Capacidad capacidad : actualizarItem.getCapacidad()) {
				capacidadEntity = mapper.convertirCapacidadEnCapacidadEntity(actualizarItem.getId(), capacidad);
				capacidadRepository.save(capacidadEntity);
			}

			return true;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

	}

	@Override
	public Boolean borrarItem(Integer id) {

		ItemEntity itemEntity = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(
						MessageFormat.format("No se encontaron resultados por el id: {0}", id)));

		try {
			itemEntity.setStatusType(StatusType.DELETED);
			itemRepository.save(itemEntity);

			return true;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

	}

}
