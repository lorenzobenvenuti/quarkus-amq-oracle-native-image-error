package it.lorenzobenvenuti.quarkus.routes;

import it.lorenzobenvenuti.quarkus.entities.Foo;
import javax.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class SimpleRouteBuilder extends RouteBuilder {

    private static final String ROUTE_ID = "simpleRoute";

    @Override
    public void configure() throws Exception {
        from("file:my-dir").routeId(ROUTE_ID)
            .process(exchange -> Foo.findById(123L));
    }

}
