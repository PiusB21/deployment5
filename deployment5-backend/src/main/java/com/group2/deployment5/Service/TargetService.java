package com.group2.deployment5.Service;

import com.group2.deployment5.DTO.TargetDTO;
import com.group2.deployment5.Entity.Target;

import java.util.List;

public interface TargetService {
    List<Target> getAll();
    Target getById(Long id);
    Target create(TargetDTO target);
    Target update(Long id, TargetDTO target);
    void delete(Long id);
}
