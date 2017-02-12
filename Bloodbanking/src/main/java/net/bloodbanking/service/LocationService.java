package net.bloodbanking.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.bloodbanking.dto.StateMstDTO;
import net.bloodbanking.entity.StateMst;

public interface LocationService {
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public StateMstDTO loadStateById(StateMstDTO stateMstDTO);
	
}
