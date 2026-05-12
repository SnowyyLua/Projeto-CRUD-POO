package com.example;

import java.util.List;
import java.util.Optional;

public interface IDAO<T> {
    public void create (T t);
    public void delete (T t);
    public void update (T t);
    public List<T> listAll();

    public Optional<T> getById(int id);
}
