package com.group2.deployment5.Repo;

import com.group2.deployment5.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Optional<Subject> findBySubjectCode(String regNo);

}
