package com.vetery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vetery.dto.AdministradorCreateDto;
import com.vetery.dto.LoginDto;
import com.vetery.dto.VeterinariaCreateDto;
import com.vetery.dto.VeterinariaResponseDto;
import com.vetery.entity.Administrador;
import com.vetery.entity.Veterinaria;
import com.vetery.exceptions.AcesoNoAutorizadoException;
import com.vetery.exceptions.RecursoExistenteException;
import com.vetery.mapper.AdministradorMapper;
import com.vetery.mapper.VeterinariaMapper;
import com.vetery.repository.AdministradorRepository;
import com.vetery.repository.CedulaRepository;
import com.vetery.repository.VeterinariaRepository;

import lombok.AllArgsConstructor;

@Service
public class VeterinariaServiceImp implements VeterinariaService{

	@Autowired
	private VeterinariaMapper mapper;
	
	private AdministradorMapper administradorMapper;
	
	@Autowired
	private VeterinariaRepository repository;
	
	@Autowired
	private AdministradorRepository administradorRepository;
	
	@Autowired
	private CedulaRepository cedulaRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	

	public VeterinariaServiceImp(VeterinariaMapper mapper, AdministradorMapper administradorMapper,
			VeterinariaRepository repository, AdministradorRepository administradorRepository,
			CedulaRepository cedulaRepository, BCryptPasswordEncoder encoder) {
		super();
		this.mapper = mapper;
		this.administradorMapper = administradorMapper;
		this.repository = repository;
		this.administradorRepository = administradorRepository;
		this.cedulaRepository = cedulaRepository;
		this.encoder = encoder;
	}

	@Override
	public VeterinariaResponseDto registrarVeterinaria(VeterinariaCreateDto dto) {
		
		AdministradorCreateDto administradorDto = dto.getAdministrador();
		
		Administrador adminComprobaciones = administradorRepository.
				findByCorreo(administradorDto.getCorreo()).orElse(null);
		
		if(adminComprobaciones != null) {
			throw new RecursoExistenteException("Correo ya registrado");
		}
		
		List<Long> cedulas = cedulaRepository.findAllCedulas();
		
		if(cedulas.contains(administradorDto.getCedula())) {
			throw new RecursoExistenteException("Cedula ya registrada");
		}
		
		Administrador administrador = administradorMapper.createDtoToAdministrador(administradorDto);
		
		administrador.setContrasenna(encoder.encode(administrador.getContrasenna()));
		
		administrador = administradorRepository.save(administrador);
		
		Veterinaria veterinaria = mapper.createDtoToVeterinaria(dto);
		
		veterinaria.setAdministrador(administrador);
		
		veterinaria = repository.save(veterinaria);
		
		VeterinariaResponseDto responseDto = mapper.veterinariaToResponseDto(veterinaria);
		
		return responseDto;
	}

	@Override
	public VeterinariaResponseDto login(LoginDto dto) {
		
		Administrador administrador = administradorRepository.findByCorreo(dto.getCorreo()).orElse(null);
		
		if(administrador == null) {
			throw new AcesoNoAutorizadoException();
		}
		
		boolean resp = encoder.matches(dto.getContrasenna(), administrador.getContrasenna());
		
		if(!resp) {
			throw new AcesoNoAutorizadoException();
		}
		
		Veterinaria veterinaria = administrador.getVeterinaria();
		
		VeterinariaResponseDto respJson = mapper.veterinariaToResponseDto(veterinaria);
		
		return respJson;
	}

}
