package net.bloodbanking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bloodbanking.dao.LocationDao;
import net.bloodbanking.dto.StateMstDTO;
import net.bloodbanking.entity.StateMst;
import net.bloodbanking.service.LocationService;

@Service("locationService")
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationDao locationDao;
	
	@Override
	public StateMstDTO loadStateById(StateMstDTO stateMstDTO) {
		locationDao.loadStateById(stateMstDTO);
		return stateMstDTO;
	}
}
