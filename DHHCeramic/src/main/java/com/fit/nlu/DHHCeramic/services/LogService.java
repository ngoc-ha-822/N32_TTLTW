package com.fit.nlu.DHHCeramic.services;

import com.fit.nlu.DHHCeramic.model.Log;
import com.fit.nlu.DHHCeramic.model.Product;

import java.util.List;

public interface LogService {
    void insert(Log log);

    void update(Log log);

    void delete(int id);

    List<Log> loadAllLog();

    Log getLogById(int id);

    void checked(int id);

}
