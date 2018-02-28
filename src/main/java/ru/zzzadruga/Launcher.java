package ru.zzzadruga;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Launcher {
    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new FileCopierCamelRoute());
        camelContext.start();
        Thread.sleep(1000);
        camelContext.stop();
    }
}
