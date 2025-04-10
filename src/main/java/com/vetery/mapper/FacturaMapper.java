package com.vetery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vetery.dto.FacturaCreateDto;
import com.vetery.dto.FacturaResponseDto;
import com.vetery.entity.Factura;

@Mapper(componentModel = "spring")
public interface FacturaMapper {
	
	Factura createDtoToFactura (FacturaCreateDto dto);
	
	@Mapping (source = "cliente.id" , target = "clienteId")
	@Mapping (source = "consulta.id" , target = "consultaId")
	@Mapping (source = "veterinaria.id" , target = "veterinariaId")
	FacturaResponseDto facturaToResponseDto (Factura factura);
}
