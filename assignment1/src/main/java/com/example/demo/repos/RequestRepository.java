package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.sqldb.Request;


@Repository
public interface RequestRepository extends JpaRepository<Request, Long>  {

}
