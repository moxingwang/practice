package com.mo.debezium;

import io.debezium.config.Configuration;
import io.debezium.embedded.EmbeddedEngine;
import org.apache.kafka.connect.source.SourceRecord;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * 代码集成的方式监听binlog change事件
 * https://debezium.io/docs/install/
 *
 * @description: https://issues.jboss.org/browse/DBZ-477
 * @author: MoXingwang 2018-08-01 20:46
 **/
public class DebeziumInstalling {

    public static void main(String[] args) {
        Configuration config = Configuration.create()
                .with("connector.class",
                        "io.debezium.connector.mysql.MySqlConnector")
                .with("offset.storage",
                        "org.apache.kafka.connect.storage.FileOffsetBackingStore")
                .with("offset.storage.file.filename",
                        "path/to/storage/offset.dat")
                .with("offset.flush.interval.ms", 60000)
                .with("name", "my-sql-connector")
                .with("database.hostname", "localhost")
                .with("database.port", 3306)
                .with("database.user", "root")
                .with("database.password", "debezium")
                .with("server.id", 85744)
                .with("database.server.name", "my-app-connector-test")
                .with("database.history",
                        "io.debezium.relational.history.FileDatabaseHistory")
                .with("database.history.file.filename",
                        "path/to/storage/dbhistory.dat")
                .build();


        EmbeddedEngine engine = EmbeddedEngine.create().using(config).notifying(new Consumer<SourceRecord>() {
            @Override
            public void accept(SourceRecord sourceRecord) {
                System.out.println("-------" + sourceRecord.value());
                System.out.println("Got record for topic:" + sourceRecord.topic().toString());
            }
        }).build();
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            engine.run();
        });
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
