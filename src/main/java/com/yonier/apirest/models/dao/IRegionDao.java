package com.yonier.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yonier.apirest.models.entity.Region;

public interface IRegionDao extends JpaRepository<Region, Long>{

}
