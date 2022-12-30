package com.yonier.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yonier.apirest.models.entity.Region;

import com.yonier.apirest.models.services.IRegionService;


@CrossOrigin(origins =  {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class RegionController {
	
	@Autowired
	private IRegionService regionService;
	
	@GetMapping("/regiones")
	public List<Region> index(){
		return regionService.findAll();	
	}
	
	@GetMapping("/regiones/page/{page}")
	public Page<Region> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 5);
		return regionService.findAll(pageable);
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@SuppressWarnings("unused")
	@GetMapping("/regiones/{id}")
	public ResponseEntity<?>showRegion(@PathVariable Long id) {
		
		Region region = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			region = regionService.findById(id);
			
		} catch (DataAccessException e) {
			
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		if (region == null) {
			
			response.put("mensaje", "La región con el ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Region>(region, HttpStatus.OK);		
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/regiones")
	//RequestBody ya que la respuesta es en formato json
	public ResponseEntity<?> createRegion(@Valid @RequestBody Region region, BindingResult result) {
		
		Region regionNew = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField()+"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
					
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			regionNew = regionService.saveRegion(region);
			
		} catch (DataAccessException e) {
			
			response.put("mensaje", "Error al guardar los datos en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La región se ha creado con exito");
		response.put("region", regionNew);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@PutMapping("/regiones/{id}")
	public ResponseEntity<?> updateRegion(@Valid @RequestBody Region region, BindingResult result, @PathVariable Long id) {
		
		Region regionActual = regionService.findById(id);
		Region regionUpdate = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			
			/*
			List<String> errors = new ArrayList<>();
			
			for(FieldError err: result.getFieldErrors()) {
				errors.add("El campo "+err.getField()+" "+err.getDefaultMessage());
			}
			*/
			
			//Errores, validaciones de los campos
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField()+"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
					
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (regionActual == null) {
			
			response.put("mensaje", "No se pudo editar: La region con el ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			
			regionActual.setNombre(region.getNombre());

			regionUpdate = regionService.saveRegion(regionActual);
			
		} catch (DataAccessException e) {
			
			response.put("mensaje", "Error al actualizar la región en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		response.put("mensaje", "La región se ha actualizado con exito");
		response.put("region", regionUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/regiones/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		 
		Map<String, Object> response = new HashMap<>();
		Region region = regionService.findById(id);
		
		if (region == null) {
			
			response.put("mensaje", "No se pudo eliminar: La región con el ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			
		}else {
			try {
				
				regionService.delete(id);
				
			} catch (DataAccessException e) {
				
				response.put("mensaje", "Error al emiminar la región de la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		response.put("mensaje", "Registro eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
