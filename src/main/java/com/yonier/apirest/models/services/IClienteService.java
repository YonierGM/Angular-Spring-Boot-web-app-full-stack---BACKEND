package com.yonier.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yonier.apirest.models.entity.Cliente;

public interface IClienteService {
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente saveCliente(Cliente cliente);
	
	public void delete(Long id); 

}
