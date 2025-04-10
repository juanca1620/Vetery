package com.vetery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetery.dto.MascotaCreateDto;
import com.vetery.dto.MascotaResponseDto;
import com.vetery.dto.MascotaUpdateDto;
import com.vetery.entity.Cliente;
import com.vetery.entity.Mascota;
import com.vetery.exceptions.RecursoNoEncontradoException;
import com.vetery.mapper.MascotaMapper;
import com.vetery.repository.ClienteRepository;
import com.vetery.repository.MascotaRepository;

@Service
public class MascotaServiceImp implements MascotaService{

	@Autowired
	private MascotaRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private MascotaMapper mapper;
	
	public MascotaServiceImp(MascotaRepository repository, ClienteRepository clienteRepository, MascotaMapper mapper) {
		super();
		this.repository = repository;
		this.clienteRepository = clienteRepository;
		this.mapper = mapper;
	}

	@Override
	public MascotaResponseDto crearMascota(MascotaCreateDto dto) {
		
		Cliente cliente = clienteRepository.findById(dto.getClienteId()).
				orElseThrow(()-> new RecursoNoEncontradoException("El cliente con el id " + dto.getClienteId() + " no fue encontrada"));
		
		Mascota mascota = mapper.createDtoToMascota(dto);
		
		mascota.setCliente(cliente);
		
		mascota = repository.save(mascota);
		
		MascotaResponseDto resp = mapper.mascotaToResponseDto(mascota);
		
		return resp;
	}

	@Override
	public List<MascotaResponseDto> obtenerMascotasPorClienteId(Long id) {
		
		Cliente cliente = obtenerEntidadCliente(id);
		
		List<Mascota> mascotas = cliente.getMascotas();
		
		List<MascotaResponseDto> resp = mascotas.stream().
				map(mascota->mapper.mascotaToResponseDto(mascota)).collect(Collectors.toList());
		
		return resp;
	}

	@Override
	public MascotaResponseDto actualizarMascota(MascotaUpdateDto dto) {
		Mascota mascota = obtenerEntidadMascota(dto.getId());
		
		mascota.setFechaNacimiento(dto.getFechaNacimiento());
		
		mascota.setNombre(dto.getNombre());
		
		mascota = repository.save(mascota);
		
		MascotaResponseDto resp =  mapper.mascotaToResponseDto(mascota);
		return resp;
	}

	@Override
	public MascotaResponseDto eliminarMascota(Long id) {
		
		Mascota mascota = obtenerEntidadMascota(id);
		
		MascotaResponseDto resp =  mapper.mascotaToResponseDto(mascota);
		
		repository.delete(mascota);
		
		return resp;
	}

	@Override
	public MascotaResponseDto obtenerMascotaPorId(Long id) {
		Mascota mascota = obtenerEntidadMascota(id);
		
		MascotaResponseDto resp =  mapper.mascotaToResponseDto(mascota);
		
		return resp;
	}
	
	private Cliente obtenerEntidadCliente (Long id) {
		Cliente cliente = clienteRepository.findById(id).
				orElseThrow(()-> new RecursoNoEncontradoException("El cliente con el id " + id + " no fue encontrada"));
		
		return cliente;
	}
	
	private Mascota obtenerEntidadMascota (Long id) {
		Mascota mascota = repository.findById(id).
				orElseThrow(()-> new RecursoNoEncontradoException("La mascota con el id " + id + " no fue encontrada"));
		
		return mascota;
	}

}
