package org.acme.quickstart.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.profiler.Profiler;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.Map;

@Interceptor
@Priority(1)
@ServiceMethodLog
public class LogInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
    //private static Profiler profiler = new Profiler("LIDO");

    static {
  //      profiler.setLogger(logger);
    }

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        String calssname = context.getMethod().getDeclaringClass().getName();
        String method = context.getMethod().getName();
        java.util.logging.Logger.getGlobal().entering(calssname, method, context.getParameters());
        for (Parameter parameter : context.getMethod().getParameters()) {
            logger.info("Parameter: " + parameter.toString());
        }

        logger.info("Entering method: {}#{}", context.getMethod().getDeclaringClass().getCanonicalName(), context.getMethod().getName());
        startProfile(context);
        // Execute method
        Object result = context.proceed();
        java.util.logging.Logger.getGlobal().exiting(calssname, method, result);
        stopProfile();
        logger.info("Leaving method: {}#{}", context.getMethod().getDeclaringClass().getCanonicalName(), context.getMethod().getName() );
        return result;
    }


    private void startProfile(InvocationContext context) {
        //if (logger.isInfoEnabled()) {
            //profiler.start(String.format("%1$s#%2$s", context.getMethod().getDeclaringClass().getCanonicalName(), context.getMethod().getName()));
        //}
    }

    private void stopProfile() {
        //if (logger.isInfoEnabled()) {
           // profiler.stop().log();
        //}
    }


}
