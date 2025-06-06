package com.group2.deployment5.Repo;

import com.group2.deployment5.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByRegNo(String regNo);
}
