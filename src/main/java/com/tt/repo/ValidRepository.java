package com.tt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tt.model.User;

public interface ValidRepository extends JpaRepository<User, Integer> {

}
