package com.maxplus1.demo.config.flyway;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationVersion;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class FlywayInitializer {

    @Resource(name = "masterDataSource")
    private DataSource masterDataSource;
    @Resource(name = "slaveDataSource")
    private DataSource slaveDataSource;


    @PostConstruct
    public void migrateFlyway() {

        Flyway flywayFinancial = new Flyway();
        flywayFinancial.setDataSource(masterDataSource);
        flywayFinancial.setLocations("db.migration.master");
        flywayFinancial.setTarget(MigrationVersion.LATEST);
        flywayFinancial.migrate();


        Flyway flywayFactory = new Flyway();
        flywayFactory.setDataSource(slaveDataSource);
        flywayFactory.setLocations("db.migration.slave");
        flywayFactory.setTarget(MigrationVersion.LATEST);
        flywayFactory.migrate();
    }

}