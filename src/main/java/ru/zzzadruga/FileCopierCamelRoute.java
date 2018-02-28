package ru.zzzadruga;

import org.apache.camel.builder.RouteBuilder;

public class FileCopierCamelRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("file:data/inbox?noop=true")
                .to("file:data/outbox");
    }
}
