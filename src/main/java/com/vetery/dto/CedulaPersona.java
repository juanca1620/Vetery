package com.vetery.dto;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable  
@Table(name = "cedulas_personas")  // 
@Data
public class CedulaPersona {
    
    @Id
    @Column(name = "cedula")
    private Long cedula;
}