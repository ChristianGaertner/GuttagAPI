package de.cpgaertner.seeme.guttag.resources.v1;

import de.cpgaertner.seeme.guttag.core.TimeFrame;
import de.cpgaertner.seeme.guttag.db.TimeFrameDAO;
import io.dropwizard.hibernate.UnitOfWork;
import lombok.AllArgsConstructor;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/timeframe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class TimeFrameResource {


    private final TimeFrameDAO timeFrameDAO;

    @GET
    @UnitOfWork
    public Response get() {
        List<TimeFrame> tfs = timeFrameDAO.findAll();
        return Response.ok(tfs).build();
    }

}
