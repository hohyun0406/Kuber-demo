package com.rod.api.common.service;



public interface CommandService<T> {
    T save (T t);
    void deleteById (Long id);
}