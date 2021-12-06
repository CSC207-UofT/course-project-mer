package com.mer.plamer.entities;


public interface Storable<T> {
    void add(T name);
    boolean remove(String id);
    boolean isEmpty();
    T get(String id);
}
