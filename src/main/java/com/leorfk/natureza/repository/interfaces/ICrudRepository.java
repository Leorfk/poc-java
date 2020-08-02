package com.leorfk.natureza.repository.interfaces;

import java.util.List;

public interface ICrudRepository<T> {
    List<T> getAll();
    void add(T obj);
    T getById(String id);
    void update(String id, T obj);
    void delete(String id);
}
