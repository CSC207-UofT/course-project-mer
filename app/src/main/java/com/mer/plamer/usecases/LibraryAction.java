package com.mer.plamer.usecases;

public interface LibraryAction<T> {
    boolean delete(String id);
    T search(String id);
    void add(String name);

}
