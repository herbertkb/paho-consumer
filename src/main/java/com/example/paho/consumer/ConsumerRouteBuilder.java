package com.example.paho.consumer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import static org.apache.camel.LoggingLevel.INFO;

@Component
public class ConsumerRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("paho-mqtt5:{{topic}}"
                +"?brokerUrl={{broker.url}}"
                +"&clientId={{client.id}}"
                +"&qos=1")
            .id("paho-consumer")
            .log(INFO, "Received: ${body}");
    }
}
