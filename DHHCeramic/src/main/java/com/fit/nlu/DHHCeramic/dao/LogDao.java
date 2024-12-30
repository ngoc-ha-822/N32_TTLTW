package com.fit.nlu.DHHCeramic.dao;

import com.fit.nlu.DHHCeramic.model.Log;

import java.util.List;

public interface LogDao {
    void insert(Log log);

    void update(Log log);

    void delete(int id);

    List<Log> loadAllLog();

    Log getLogById(int id);

    void checked(int id);

}
