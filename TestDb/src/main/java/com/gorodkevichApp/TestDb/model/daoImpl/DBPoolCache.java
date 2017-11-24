package com.gorodkevichApp.TestDb.model.daoImpl;

import org.postgresql.ds.PGPoolingDataSource;

public class DBPoolCache {
    private PGPoolingDataSource source;
    DBPoolCache(String host, String database, String user, String password){
        source = new PGPoolingDataSource();
        source.setDataSourceName("org.postgresql.Driver");
        source.setServerName("jdbc:postgresql://localhost:5432");
        source.setDatabaseName("ATM");
        source.setUser("postgres");
        source.setPassword("city1992");
        source.setMaxConnections(20);//Максимальное значение
        source.setInitialConnections(20);
    }
}
