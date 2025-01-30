package com.example.routes;

import org.apache.camel.builder.RouteBuilder;
import static org.apache.camel.LoggingLevel.INFO;

public class ConsumerRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("paho-mqtt5:{{topic}}"
                +"?brokerUrl={{mqtt-servers}}"
                +"&clientId={{clientId}}"
                +"&qos=1")
            .id("paho-consumer")
            .log(INFO, "Received: ${body}");
    }
}
