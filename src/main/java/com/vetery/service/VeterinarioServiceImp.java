package com.vetery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetery.dto.LoginDto;
import com.vetery.dto.VeterinariaCreateDto;
import com.vetery.dto.VeterinariaResponseDto;
import com.vetery.dto.VeterinarioCreateDto;
import com.vetery.dto.VeterinarioResponseDto;
import com.vetery.dto.VeterinarioUpdateDto;
import com.vetery.entity.Veterinaria;
import com.vetery.entity.Veterinario;
import com.vetery.exceptions.RecursoExistenteException;
import com.vetery.exceptions.RecursoNoEncontradoException;
import com.vetery.mapper.VeterinarioMapper;
import com.vetery.repository.CedulaRepository;
import com.vetery.repository.VeterinariaRepository;
import com.vetery.repository.VeterinarioRepository;

@Service
public class VeterinarioServiceImp implements VeterinarioService {

	@Autowired
	private VeterinarioRepository repository;
	
	@Autowired
	private VeterinariaRepository veterinariaRepository;
	
	@Autowired
	private CedulaRepository cedulaRepository;
	
	@Autowired
	private VeterinarioMapper mapper;
	
	
	
	public VeterinarioServiceImp(VeterinarioRepository repository, VeterinariaRepository veterinariaRepository,CedulaRepository cedulaRepository,
			VeterinarioMapper mapper) {
		super();
		this.repository = repository;
		this.veterinariaRepository = veterinariaRepository;
		this.cedulaRepository = cedulaRepository;
		this.mapper = mapper;
	}

	@Override
	public VeterinarioResponseDto crearVeterinario(VeterinarioCreateDto dto) {
		
		List<Long> cedulas = cedulaRepository.findAllCedulas();
		
		if(cedulas.contains(dto.getCedula())) {
			throw new RecursoExistenteException("Cedula ya registrada");
		}
		
		Veterinaria veterinaria = veterinariaRepository.findById(dto.getVeterinariaId()).
				orElseThrow(()-> new RecursoNoEncontradoException("Veterinaria con el id " + dto.getVeterinariaId() + " no fue encontrada"));
		
		Veterinario veterinario = mapper.createDtoToVeterinario(dto);
		
		veterinario.setVeterinaria(veterinaria);
		veterinario = repository.save(veterinario);
		
		VeterinarioResponseDto resp = mapper.veterinarioToResponseDto(veterinario);
		
		return resp;
	}

	@Override
	public List<VeterinarioResponseDto> obtenerVeterinariosPorVeterinariaId(Long id) {
		
		Veterinaria veterinaria = veterinariaRepository.findById(id).
				orElseThrow(()-> new RecursoNoEncontradoException("La veterinaria con el id " + id + " no fue encontrada"));
		
		List<Veterinario> veterinarios = veterinaria.getVeterinarios();	
		
		List<VeterinarioResponseDto> resp = veterinarios.stream().
				map((veterinario)-> mapper.veterinarioToResponseDto(veterinario)).collect(Collectors.toList());
		
		return resp;
	}

	@Override
	public VeterinarioResponseDto actualizarVeterinario(VeterinarioUpdateDto dto) {

		Veterinario veterinario = repository.findById(dto.getId()).orElseThrow(
				() -> new RecursoNoEncontradoException("Veterinario con el id " + dto.getId() + " no fue encontrado"));
		
		veterinario.setApellido(dto.getApellido());
		veterinario.setFechaNacimiento(dto.getFechaNacimiento());
		veterinario.setNombre(dto.getNombre());
		
		veterinario = repository.save(veterinario);
		
		VeterinarioResponseDto resp = mapper.veterinarioToResponseDto(veterinario);
		
		return resp;
	}

	@Override
	public VeterinarioResponseDto eliminarVeterinario(Long id) {
		Veterinario veterinario = repository.findById(id).
				orElseThrow(() -> new RecursoNoEncontradoException("Veterinario con el id " + id + " no fue encontrado"));
		VeterinarioResponseDto resp = mapper.veterinarioToResponseDto(veterinario);
		repository.delete(veterinario);
		return resp;
	}

	@Override
	public VeterinarioResponseDto obtenerVeterinarioPorId(Long id) {
		Veterinario veterinario = repository.findById(id).
				orElseThrow(() -> new RecursoNoEncontradoException("Veterinario con el id " + id + " no fue encontrado"));
		VeterinarioResponseDto resp = mapper.veterinarioToResponseDto(veterinario);
		
		return resp;
	}

}
