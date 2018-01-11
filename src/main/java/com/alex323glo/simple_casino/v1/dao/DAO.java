package com.alex323glo.simple_casino.v1.dao;

import com.alex323glo.simple_casino.v1.exception.DAOException;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * General DAO interface.
 *
 * @author alex323glo
 * @version 0.1.0
 *
 * @see K type of key.
 * @see V type of stored value.
 */
public interface DAO<K, V> {

    void create(K key, V value) throws DAOException;

    K create(V value) throws DAOException;      // TODO could be removed

    V read(K key) throws DAOException;

    V update(K key, V value) throws DAOException;

    V delete(K key) throws DAOException;

    List<V> getValues() throws DAOException;    // TODO could be removed

    Set<K> getKeys() throws DAOException;       // TODO could be removed

    Map<K, V> getAll() throws DAOException;     // TODO could be removed

}
