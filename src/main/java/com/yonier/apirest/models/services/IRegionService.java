package com.yonier.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yonier.apirest.models.entity.Region;

public interface IRegionService {
	
	public Page<Region> findAll(Pageable pageable);
	
	public List<Region> findAll();
	
	public Region findById(Long id);
	
	public Region saveRegion(Region region);
	
	public void delete(Long id);
}
