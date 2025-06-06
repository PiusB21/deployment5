package com.group2.deployment5.Repo;

import com.group2.deployment5.Entity.Status;
import com.group2.deployment5.Entity.Target;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findTopByTargetIdOrderByCheckedAtDesc(Long targetId);
    Status findTop1ByTargetOrderByCheckedAtDesc(Target target);
}
