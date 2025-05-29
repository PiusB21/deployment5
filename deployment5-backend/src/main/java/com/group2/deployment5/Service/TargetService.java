package com.group2.deployment5.Service;

import com.group2.deployment5.Entity.Target;

import java.util.List;

public interface TargetService {
    List<Target> getAll();
    Target getById(Long id);
    Target create(Target target);
    Target update(Long id, Target target);
    void delete(Long id);
}
