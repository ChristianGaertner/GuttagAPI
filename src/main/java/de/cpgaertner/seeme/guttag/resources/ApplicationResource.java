package de.cpgaertner.seeme.guttag.resources;

import lombok.AccessLevel;
import lombok.Getter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
@Getter(AccessLevel.PRIVATE)
public class ApplicationResource {


    @GET
    public String index() {
        return "(c) 2014 SeeMe (Christian Gärtner);\n" +
                "John Guttag API\n" +
                "hit /version to get the implementation version currently running";
    }

}
