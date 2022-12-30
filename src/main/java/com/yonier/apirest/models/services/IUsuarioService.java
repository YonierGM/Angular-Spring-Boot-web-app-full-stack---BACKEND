package com.yonier.apirest.models.services;

import com.yonier.apirest.models.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}
