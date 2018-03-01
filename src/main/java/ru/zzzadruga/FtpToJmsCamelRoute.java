package ru.zzzadruga;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class FtpToJmsCamelRoute extends RouteBuilder{
    public void configure() throws Exception {
        from("ftp://s102.sdserver.net/orders?username=ftpuser3514&password=9tZyiTaD1a&passiveMode=true&ftpClient.dataTimeout=30000&move=/done")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("We read a message: " +
                                exchange.getIn().getBody());
                    }
                })
                .to("activemq:queue:incomingOrders");
    }
}
