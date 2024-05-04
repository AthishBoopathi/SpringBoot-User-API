package com.example.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	

}
