package org.acme.quickstart;

import org.acme.quickstart.interceptor.ServiceMethodLog;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ServiceMethodLog
public class GreetingServiceImpl implements GreetingService {

    @ConfigProperty(name = "message")
    private String message;

    @Override
    public String sayHello(String helloß) {
        return message;
    }

    public void foo() {
        
    }
}
