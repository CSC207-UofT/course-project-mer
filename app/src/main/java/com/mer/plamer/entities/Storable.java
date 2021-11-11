package com.mer.plamer.entities;

public interface Storable<T> {
    void add(T s);
    void remove();
    void read();
    void isEmpty();
}
