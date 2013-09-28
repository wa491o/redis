package com.zhaiyz.redis.repository;

import java.util.List;

import com.zhaiyz.redis.domain.DomainObject;

public interface Repository<V extends DomainObject> {

    void put(V obj);

    V get(V key);

    void delete(V key);

    List<V> getObjects();
}
