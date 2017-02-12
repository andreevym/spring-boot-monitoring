package hello.monitoring;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MonitoringDB {

    private static final InfluxDB INFLUX_DB = InfluxDBFactory.connect("http://localhost:8086", "admin", "admin");
    private static final String DATABASE_NAME = "hyperledger";
    private static final String RETENTION_POLICY_AUTOGEN = "autogen";
    private static final String FIELD_DURATION = "duration";

    public void write(String measurement, long duration) {
        Point point = Point.measurement(measurement)
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .addField(FIELD_DURATION, duration)
                .build();

        INFLUX_DB.write(DATABASE_NAME, RETENTION_POLICY_AUTOGEN, point);
    }
}
