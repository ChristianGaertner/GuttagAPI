package de.cpgaertner.seeme.guttag.resources;

import com.codahale.metrics.annotation.Timed;
import de.cpgaertner.seeme.guttag.core.Test;
import lombok.AccessLevel;
import lombok.Getter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Getter(AccessLevel.PRIVATE)
public class TestResource {

    private final String test;
    private final AtomicLong counter;

    public TestResource(String test) {
        this.test = test;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Test test() {
        return new Test(counter.incrementAndGet(), test);
    }

}
