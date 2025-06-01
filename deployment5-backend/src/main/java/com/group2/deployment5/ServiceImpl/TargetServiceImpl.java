package com.group2.deployment5.ServiceImpl;

import com.group2.deployment5.DTO.TargetDTO;
import com.group2.deployment5.Entity.Target;
import com.group2.deployment5.Repo.TargetRepository;
import com.group2.deployment5.Service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TargetServiceImpl implements TargetService {
    @Autowired
    private TargetRepository targetRepository;

    @Override
    public List<Target> getAll() {
        return targetRepository.findAll();
    }

    @Override
    public Target getById(Long id) {
        return targetRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public Target create(TargetDTO targetDTO) {
        var target = Target.builder()
                .url(targetDTO.getUrl())
                .name(targetDTO.getName())
                .createdAt(LocalDateTime.now())
                .frontendNode(targetDTO.getFrontendNode())
                .enabled(targetDTO.isEnabled())
                .build();
        return targetRepository.save(target);
    }

    @Override
    public Target update(Long id, TargetDTO target) {
        Target updatedTarget = getById(id);
        updatedTarget.setUrl(target.getUrl());
        updatedTarget.setName(target.getName());
        updatedTarget.setFrontendNode(target.getFrontendNode());
        updatedTarget.setEnabled(target.isEnabled());
        return targetRepository.save(updatedTarget);
    }

    @Override
    public void delete(Long id) {
        targetRepository.deleteById(id);
    }
}
