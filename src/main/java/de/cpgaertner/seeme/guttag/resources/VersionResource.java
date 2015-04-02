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

    private final String version;
    private final long id = 0;

    public VersionResource(String version) {
        this.version = version;
    }

    @GET
    @Timed
    public Version test() {
        return new Version(getId(), getVersion());
    }

}
