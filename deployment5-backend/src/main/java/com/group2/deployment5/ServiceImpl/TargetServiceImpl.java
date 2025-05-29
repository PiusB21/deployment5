package com.group2.deployment5.ServiceImpl;

import com.group2.deployment5.Entity.Target;
import com.group2.deployment5.Repo.TargetRepository;
import com.group2.deployment5.Service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetServiceImpl implements TargetService {
    @Autowired
    private TargetRepository targetRepository;

    @Override
    public List<Target> getAll() {
        return List.of();
    }

    @Override
    public Target getById(Long id) {
        return null;
    }

    @Override
    public Target create(Target target) {
        return null;
    }

    @Override
    public Target update(Long id, Target target) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
