package com.mer.plamer.entities;

/**
 * Interface that defines methods which are common between libraries
 * @param <T> the object we are storing
 */
public interface Storable<T> {
    /**
     * Add the object to the library
     * @param name the name/id of such object
     */
    void add(T name);

    /**
     * Remove the object from the library
     * @param id the name/id of such object
     * @return true if removed, false otherwise
     */
    boolean remove(String id);

    /**
     * Return true if the library contains no object
     * @return true if the library is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Fetch the object from the library
     * @param id the id/name of such object
     * @return the object matching such id/name
     */
    T get(String id);
}
