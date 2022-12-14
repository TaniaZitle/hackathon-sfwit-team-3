package com.hackathonteam3.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathonteam3.api.models.Student;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Long>{


}
