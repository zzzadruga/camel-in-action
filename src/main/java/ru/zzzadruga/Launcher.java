package ru.zzzadruga;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class Launcher {
    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616");
        connectionFactory.setUserName("admin");
        connectionFactory.setPassword("admin");
        camelContext.addComponent("activemq", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        camelContext.addRoutes(new FtpToJmsCamelRoute());
        camelContext.start();
        Thread.sleep(10000);
        camelContext.stop();
    }
}
