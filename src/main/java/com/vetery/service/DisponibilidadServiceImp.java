package com.vetery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetery.dto.DisponibilidadCreateDto;
import com.vetery.dto.DisponibilidadResponseDto;
import com.vetery.entity.Disponibilidad;
import com.vetery.entity.Veterinario;
import com.vetery.exceptions.DisponibilidadCruzadaException;
import com.vetery.exceptions.RecursoNoEncontradoException;
import com.vetery.mapper.DisponibilidadMapper;
import com.vetery.repository.DisponibilidadRepository;
import com.vetery.repository.VeterinarioRepository;

@Service
public class DisponibilidadServiceImp implements DisponibilidadService{

	@Autowired
	private DisponibilidadRepository repository;
	
	@Autowired
	private VeterinarioRepository veterinarioRepository;
	
	@Autowired
	private DisponibilidadMapper mapper;
	
	public DisponibilidadServiceImp(DisponibilidadRepository repository, VeterinarioRepository veterinarioRepository,
			DisponibilidadMapper mapper) {
		super();
		this.repository = repository;
		this.veterinarioRepository = veterinarioRepository;
		this.mapper = mapper;
	}

	@Override
	public DisponibilidadResponseDto crearDisponibilidad(DisponibilidadCreateDto dto) {
		
		Veterinario veterinario = obtenerEntidadVeterinarioPorId(dto.getVeterinarioId());
		
		Disponibilidad disponibilidadCruzada = repository.
				findCrossedDisponibilidad(dto.getVeterinarioId(),dto.getDiaSemana(), dto.getHoraInicio(), dto.getHoraFin()).
				orElse(null);
		
		if(disponibilidadCruzada != null) {
			throw new DisponibilidadCruzadaException();	
		}
		
		Disponibilidad disponibilidad = mapper.createDtoToDisponibilidad(dto);
		
		disponibilidad.setVeterinario(veterinario);
		
		disponibilidad = repository.save(disponibilidad);
		
		DisponibilidadResponseDto resp = mapper.disponibilidadToResponseDto(disponibilidad);
		
		return resp;
	}

	@Override
	public DisponibilidadResponseDto eliminarDisponibilidadPorId(Long id) {
		Disponibilidad disponibilidad = repository.findById(id).
				orElseThrow(()-> new RecursoNoEncontradoException("Disponibilidad con el id " + id + " no fue encontrado"));
		
		DisponibilidadResponseDto resp = mapper.disponibilidadToResponseDto(disponibilidad);
		
		return resp;
	}

	@Override
	public List<DisponibilidadResponseDto> disponibilidadesVeterinarioId (Long id) {
		Veterinario veterinario = obtenerEntidadVeterinarioPorId(id);
		
		List<Disponibilidad> disponibilidades = veterinario.getDisponibilidades();
		
		List<DisponibilidadResponseDto> resp = disponibilidades.stream().
				map(disponibilidad-> mapper.disponibilidadToResponseDto(disponibilidad)).collect(Collectors.toList());
		
		return resp;
	}
	
	private Veterinario obtenerEntidadVeterinarioPorId(Long id) {
		
		Veterinario veterinario = veterinarioRepository.findById(id).
				orElseThrow(()-> new RecursoNoEncontradoException("Veterinario con el id " + id + " no fue encontrado"));
		
		return veterinario;
	}
}
