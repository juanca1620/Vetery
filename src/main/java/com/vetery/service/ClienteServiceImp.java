package com.vetery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vetery.dto.ClienteCreateDto;
import com.vetery.dto.ClienteResponseDto;
import com.vetery.dto.ClienteUpdateDto;
import com.vetery.entity.Cliente;
import com.vetery.entity.Veterinaria;
import com.vetery.exceptions.RecursoExistenteException;
import com.vetery.exceptions.RecursoNoEncontradoException;
import com.vetery.mapper.ClienteMapper;
import com.vetery.repository.CedulaRepository;
import com.vetery.repository.ClienteRepository;
import com.vetery.repository.VeterinariaRepository;

public class ClienteServiceImp implements ClienteService{

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private VeterinariaRepository veterinariaRepository;
	
	@Autowired
	private CedulaRepository cedulaRepository;
	
	@Autowired
	private ClienteMapper mapper;
	
	
	public ClienteServiceImp(ClienteRepository repository, VeterinariaRepository veterinariaRepository,
			CedulaRepository cedulaRepository, ClienteMapper mapper) {
		super();
		this.repository = repository;
		this.veterinariaRepository = veterinariaRepository;
		this.cedulaRepository = cedulaRepository;
		this.mapper = mapper;
	}

	@Override
	public ClienteResponseDto crearCliente(ClienteCreateDto dto) {
		
		List<Long> cedulas = cedulaRepository.findAllCedulas();
		
		if(cedulas.contains(dto.getCedula())) {
			throw new RecursoExistenteException("Cedula ya registrada");
		}
		
		Veterinaria veterinaria = veterinariaRepository.findById(dto.getVeterinariaId()).
				orElseThrow(()-> new RecursoNoEncontradoException("Veterinaria con el id " + dto.getVeterinariaId() + " no fue encontrada"));
		
		Cliente cliente = mapper.createDtoToCliente(dto);
		
		cliente.setVeterinaria(veterinaria);
		
		cliente = repository.save(cliente);
		
		ClienteResponseDto resp = mapper.clienteToResponseDto(cliente);
		
		return resp;
	}

	@Override
	public List<ClienteResponseDto> obtenerClientesPorVeterinariaId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteResponseDto actualizarCliente(ClienteUpdateDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteResponseDto eliminarCliente(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteResponseDto obtenerClientePorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
