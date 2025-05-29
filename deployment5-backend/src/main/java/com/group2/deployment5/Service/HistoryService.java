package com.group2.deployment5.Service;

import com.group2.deployment5.Entity.History;

import java.time.LocalDateTime;
import java.util.List;

public interface HistoryService {
    List<History> getHistoryForTarget(Long targetId, LocalDateTime since);
    History saveHistory(History history);
}

