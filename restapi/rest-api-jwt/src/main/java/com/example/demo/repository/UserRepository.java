package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, String>
{
	
}
