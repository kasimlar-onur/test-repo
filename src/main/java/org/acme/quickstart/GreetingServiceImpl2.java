package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingServiceImpl2 implements GreetingService {

    @Override
    public String sayHello(String messageß) {
        return "hello World";
    }
}
