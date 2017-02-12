package hello.monitoring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DurationMonitoringAspect {

    @Autowired
    MonitoringDB monitoringDB;

    @Around(value = "@annotation(annotation)")
    public Object DurationMonitoringAspect(final ProceedingJoinPoint joinPoint, final DurationMonitoring annotation) throws Throwable {
        final long startTime = System.currentTimeMillis();
        try {
            final Object retVal = joinPoint.proceed();
            return retVal;
        } finally {
            final long endTime = System.currentTimeMillis();
            final long durationTime = endTime - startTime;
            monitoringDB.write(annotation.measurement(), durationTime);
        }
    }
}
