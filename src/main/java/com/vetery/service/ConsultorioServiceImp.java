package com.vetery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetery.dto.ConsultorioCreateDto;
import com.vetery.dto.ConsultorioResponseDto;
import com.vetery.entity.Agenda;
import com.vetery.entity.Consultorio;
import com.vetery.entity.Veterinaria;
import com.vetery.entity.Veterinario;
import com.vetery.exceptions.NoConsultorioRepetidoException;
import com.vetery.exceptions.RecursoNoEncontradoException;
import com.vetery.exceptions.VeterinarioConConsultorioException;
import com.vetery.exceptions.VeterinarioIncorrectoException;
import com.vetery.mapper.ConsultorioMapper;
import com.vetery.repository.AgendaRepository;
import com.vetery.repository.ConsultorioRepository;
import com.vetery.repository.VeterinariaRepository;
import com.vetery.repository.VeterinarioRepository;

@Service
public class ConsultorioServiceImp implements ConsultorioService{

	@Autowired
	private ConsultorioRepository repository;
	
	@Autowired
	private VeterinariaRepository veterinariaRepository;
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Autowired
	private VeterinarioRepository veterinarioRepository;
	
	@Autowired
	private ConsultorioMapper mapper;
	
	

	public ConsultorioServiceImp(ConsultorioRepository repository, VeterinariaRepository veterinariaRepository,
			AgendaRepository agendaRepository, VeterinarioRepository veterinarioRepository, ConsultorioMapper mapper) {
		super();
		this.repository = repository;
		this.veterinariaRepository = veterinariaRepository;
		this.agendaRepository = agendaRepository;
		this.veterinarioRepository = veterinarioRepository;
		this.mapper = mapper;
	}

	@Override
	public ConsultorioResponseDto crearConsultorio(ConsultorioCreateDto dto,Long veterinariaId) {
		
		Veterinaria veterinaria = obtenerEntidadVeterinariaPorId(veterinariaId);
		
		Veterinario veterinario = obtenerEntidadVeterinarioPorId(dto.getVeterinarioId());
				
		Consultorio consultorioVerificacion = repository.findByVeterinario(veterinario).orElse(null);
		
		if(consultorioVerificacion != null) {
			throw new VeterinarioConConsultorioException();
		}
		
		if(veterinario.getVeterinaria().getId() != veterinariaId) {
			throw new VeterinarioIncorrectoException();
		}
		
		consultorioVerificacion = repository.findByVeterinariaAndNoConsultorio(veterinaria, dto.getNoConsultorio()).orElse(null);
		
		if(consultorioVerificacion != null) {
			throw new NoConsultorioRepetidoException();
		}
		
		Consultorio consultorio = mapper.CreateDtoToConsultorio(dto);
		
		Agenda agenda = new Agenda();
		
		agenda = agendaRepository.save(agenda);
		
		consultorio.setAgenda(agenda);
		consultorio.setVeterinaria(veterinaria);
		consultorio.setVeterinario(veterinario);
		
		consultorio = repository.save(consultorio);
		
		ConsultorioResponseDto resp = mapper.consultorioToResponseDto(consultorio);
		return resp;
	}

	@Override
	public ConsultorioResponseDto eliminarConsultorio(Long id) {
		
		Consultorio consultorio = obtenerEntidadConsultorioPorId(id);
		
		ConsultorioResponseDto resp = mapper.consultorioToResponseDto(consultorio);
		
		repository.delete(consultorio);
		
		return resp;
	}

	@Override
	public ConsultorioResponseDto obtenerConsultorioPorId(Long id) {
		Consultorio consultorio = obtenerEntidadConsultorioPorId(id);
		
		ConsultorioResponseDto resp = mapper.consultorioToResponseDto(consultorio);
		
		return resp;
	}

	@Override
	public List<ConsultorioResponseDto> obtenerConsultoriosPorVeterinaria(Long id) {
		Veterinaria veterinaria = obtenerEntidadVeterinariaPorId(id);
		
		List<Consultorio> consultorios = veterinaria.getConsultorios();
		
		List<ConsultorioResponseDto> resp = consultorios.stream().
				map(consultorio-> mapper.consultorioToResponseDto(consultorio)).collect(Collectors.toList());
		
		return resp;
	}
	
	private Veterinaria obtenerEntidadVeterinariaPorId (Long id) {
		Veterinaria veterinaria = veterinariaRepository.findById(id).
				orElseThrow(()-> new RecursoNoEncontradoException("Veterinaria con el id " + id + " no fue encontrada"));
		
		return veterinaria;
	}
	
	private Consultorio obtenerEntidadConsultorioPorId (Long id) {
		Consultorio consultorio = repository.findById(id).
				orElseThrow(()-> new RecursoNoEncontradoException("Consultorio con el id " + id + " no fue encontrado"));
		
		return consultorio;
	}
	
	private Veterinario obtenerEntidadVeterinarioPorId(Long id) {
		
		Veterinario veterinario = veterinarioRepository.findById(id).
				orElseThrow(()-> new RecursoNoEncontradoException("Veterinario con el id " + id + " no fue encontrado"));
		
		return veterinario;
	}

}
