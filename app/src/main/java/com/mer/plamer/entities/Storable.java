package com.mer.plamer.entities;

import java.util.List;

public interface Storable<T> {
    void add(T name);
    boolean remove(String id);
    boolean isEmpty();
    T contain(String id);
}
