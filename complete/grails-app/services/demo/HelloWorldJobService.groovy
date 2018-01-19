package demo

import com.agileorbit.schwartz.SchwartzJob
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.quartz.JobExecutionContext
import org.quartz.JobExecutionException

@CompileStatic
@Slf4j
class HelloWorldJobService implements SchwartzJob {

    void execute(JobExecutionContext context) throws JobExecutionException {
        println new Date()
    }

    void buildTriggers() {
        triggers <<
            factory('Simple Job')
            .intervalInSeconds(10)
            .build()
    }
}
