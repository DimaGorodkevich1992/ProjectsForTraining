package com.gorodkevichApp.TestDb.model.dao;

import com.gorodkevichApp.TestDb.model.domain.History;

public interface HistoryDao {
    History get();

    void setHistory();
}
