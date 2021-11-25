package com.mer.plamer.usecases;

import java.util.ArrayList;

public interface LibraryAction<T> {
    boolean delete(String id);
    ArrayList<T> search(String keyword);
    void add(String name);

}
