package de.cpgaertner.seeme.guttag.resources.v1;

import de.cpgaertner.seeme.guttag.core.User;
import de.cpgaertner.seeme.guttag.db.UserDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import lombok.AllArgsConstructor;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;
import java.util.Optional;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class UserResource {

    private final UserDAO userDAO;


    @GET
    @UnitOfWork
    public Response get() {
        List<User> users = userDAO.findAll();
        return Response.ok(users).build();
    }

    @POST
    @UnitOfWork
    public User create(@Valid User user) {
        return userDAO.create(user);
    }

    @Path("/{userId}")
    @GET
    @UnitOfWork
    public User get(@PathParam("userId") LongParam userId) {
        return find(userId.get());
    }

    @Path("/{userId}")
    @PUT
    @UnitOfWork
    public Response update(@PathParam("userId") LongParam userId, @Valid User user) {
        find(userId.get());

        user.setId(userId.get());
        userDAO.update(user);
        return Response.created(
                UriBuilder.fromResource(UserResource.class)
                        .build(user.getId())
        ).build();
    }

    private User find(Long id) {
        final Optional<User> user = userDAO.findById(id);

        if (!user.isPresent()) {
            throw new NotFoundException("No such user.");
        }

        return user.get();
    }

}
