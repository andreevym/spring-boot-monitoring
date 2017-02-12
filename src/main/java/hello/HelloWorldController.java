package hello;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {

    private static final String template = "Hello, %s!";

    InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086", "admin", "admin");

    private static final String DATABASE_NAME = "hyperledger";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Greeting sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
        long startTime = System.currentTimeMillis();
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        Point point = Point.measurement("seconds")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .addField("duration", duration)
                .build();

        influxDB.write(DATABASE_NAME, "autogen", point);
        return greeting;
    }

}
