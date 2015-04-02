package de.cpgaertner.seeme.guttag.resources.v1;

import de.cpgaertner.seeme.guttag.core.User;
import de.cpgaertner.seeme.guttag.db.UserDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import lombok.AllArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/user/{userId}")
@Produces(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class UserResource {

    private final UserDAO userDAO;

    @GET
    @UnitOfWork
    public User getUser(@PathParam("userId") LongParam userId) {
        return find(userId.get());
    }

    private User find(Long id) {
        final Optional<User> user = userDAO.findById(id);

        if (!user.isPresent()) {
            throw new NotFoundException("No such user.");
        }

        return user.get();
    }

}
