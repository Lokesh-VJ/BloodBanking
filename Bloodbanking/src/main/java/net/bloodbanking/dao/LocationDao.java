package net.bloodbanking.dao;

import net.bloodbanking.dto.StateMstDTO;
import net.bloodbanking.entity.StateMst;

public interface LocationDao extends BaseDao{

	StateMst loadStateById(StateMstDTO stateMstDTO);

}