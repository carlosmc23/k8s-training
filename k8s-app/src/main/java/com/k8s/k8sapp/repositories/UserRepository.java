package com.k8s.k8sapp.repositories;

import com.k8s.k8sapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
