package com.mer.plamer.entities;

public interface Storable<T> {
    void add(T name);
    boolean remove(String name);
    boolean isEmpty();
    T contain(String name);
}
