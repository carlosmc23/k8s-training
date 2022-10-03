/**
 * @author: Edson A. Terceros T.
 */

package com.k8s.k8sapp.services;

import java.util.List;

public interface GenericService<T> {
    List<T> findAll();
    T findById(Long id);
    boolean findByIdB(Long id);
    T save(T model);
    void deleteById(Long id);
}