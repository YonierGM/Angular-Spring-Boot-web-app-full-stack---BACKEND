package com.yonier.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yonier.apirest.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{
	
}
