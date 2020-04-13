package com.nosbielc;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.MySQLContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 12/04/2020
 * @project Quarkus-Examples
 */
public class DataBaseLifecycle implements QuarkusTestResourceLifecycleManager {

    private static MySQLContainer<?> MYSQL = new MySQLContainer<>("mysql:5.5");

    @Override
    public Map<String, String> start() {
        MYSQL.start();

        Map<String, String> properts = new HashMap<>();
        properts.put("quarkus.datasource.url", MYSQL.getJdbcUrl());
        properts.put("quarkus.datasource.username", MYSQL.getUsername());
        properts.put("quarkus.datasource.password", MYSQL.getPassword());

        return properts;
    }

    @Override
    public void stop() {
        if (MYSQL != null) {
            MYSQL.stop();
        }
    }

}
