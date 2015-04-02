package de.cpgaertner.seeme.guttag.resources;

import com.codahale.metrics.annotation.Timed;
import de.cpgaertner.seeme.guttag.core.Version;
import lombok.AccessLevel;
import lombok.Getter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/version")
@Produces(MediaType.APPLICATION_JSON)
@Getter(AccessLevel.PRIVATE)
public class VersionResource {

    private final String test;
    private final long id = 0;

    public VersionResource(String test) {
        this.test = test;
    }

    @GET
    @Timed
    public Version test() {
        return new Version(0, test);
    }

}
