package de.cpgaertner.seeme.guttag.resources.v1;

import com.google.inject.Inject;
import de.cpgaertner.seeme.guttag.core.TimeFrame;
import de.cpgaertner.seeme.guttag.db.TimeFrameDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

@Path("/timeframe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimeFrameResource {


    private final TimeFrameDAO timeFrameDAO;

    @Inject
    public TimeFrameResource(TimeFrameDAO timeFrameDAO) {
        this.timeFrameDAO = timeFrameDAO;
    }

    @GET
    @UnitOfWork
    public Response get() {
        List<TimeFrame> tfs = timeFrameDAO.findAll();
        return Response.ok(tfs).build();
    }

    @POST
    @UnitOfWork
    public Response create(@Valid TimeFrame tf) {
        tf = timeFrameDAO.create(tf);

        return Response.created(
                UriBuilder.fromResource(TimeFrameResource.class).build(tf.getId())
        ).build();
    }

}
