package demo

import com.agileorbit.schwartz.SchwartzJob
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.quartz.JobExecutionContext
import org.quartz.JobExecutionException

@CompileStatic
@Slf4j
class HelloWorldJobService implements SchwartzJob {

    //tag::helloWorldJob[]
    void execute(JobExecutionContext context) throws JobExecutionException {
        println "${context.trigger.key} -> ${new Date()}" // <1>
    }

    void buildTriggers() {
        // <2>
        triggers <<
            factory('Simple Job every 10 seconds')
            .intervalInSeconds(10)
            .build()

        // <3>
        triggers <<
            factory('Simple Job every 45 seconds')
            .startDelay(5000)
            .intervalInSeconds(45)
            .build()
    }
    //end::helloWorldJob[]
}
