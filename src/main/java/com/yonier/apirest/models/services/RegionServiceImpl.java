package com.yonier.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yonier.apirest.models.dao.IRegionDao;
import com.yonier.apirest.models.entity.Region;

@Service
public class RegionServiceImpl implements IRegionService{
	
	@Autowired
	private IRegionDao serviceDao;
	
	@Override
	public Page<Region> findAll(Pageable pageable) {
		
		return serviceDao.findAll(pageable);
	}

	@Override
	public List<Region> findAll() {
		
		return serviceDao.findAll();
	}

	@Override
	public Region findById(Long id) {
		
		return serviceDao.findById(id).orElse(null);
	}

	@Override
	public Region saveRegion(Region region) {

		return serviceDao.save(region);
	}

	@Override
	public void delete(Long id) {
		
		serviceDao.deleteById(id);
		
	}

}
