package net.bloodbanking.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao {
	
    public abstract Serializable save(Object obj);
    
    public abstract void saveOrUpdate(Object obj);

    public abstract void update(Object obj);

    public abstract void delete(Object obj);
    
    public abstract void saveList(@SuppressWarnings("rawtypes") List list);

    public abstract void flush();
}