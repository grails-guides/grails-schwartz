package demo

import com.agileorbit.schwartz.SchwartzJob
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.quartz.JobExecutionContext
import org.quartz.JobExecutionException

@CompileStatic
@Slf4j
class DailyEmailJobService implements SchwartzJob {

    EmailService emailService

    void execute(JobExecutionContext context) throws JobExecutionException {
        emailService.send('john.doe@example.com')
    }

    void buildTriggers() {

//        triggers << factory('Daily email job')
//            .startAt(DateBuilder.todayAt(4, 30, 0))
//            .intervalInDays(1)
//            .misfireHandling(MisfireHandling.IgnoreMisfires)
//            .build()

        triggers << factory('Daily email job')
            .cronSchedule("0 30 4 1/1 * ? *")
            .build()
    }
}
