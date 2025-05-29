package com.group2.deployment5.ServiceImpl;

import com.group2.deployment5.Entity.History;
import com.group2.deployment5.Repo.HistoryRepository;
import com.group2.deployment5.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public List<History> getHistoryForTarget(Long targetId, LocalDateTime since) {
        return List.of();
    }

    @Override
    public History saveHistory(History history) {
        return null;
    }
}
