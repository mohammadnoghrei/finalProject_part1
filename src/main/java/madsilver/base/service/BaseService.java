package madsilver.base.service;

import madsilver.base.entity.BaseEntity;

import java.io.Serializable;

public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> {

    boolean validate(T entity);
    T saveOrUpdate(T entity);

    T findById(ID id);

    void delete(T t);
}