package de.cpgaertner.seeme.guttag.resources.v1;

import de.cpgaertner.seeme.guttag.core.User;
import de.cpgaertner.seeme.guttag.db.UserDAO;
import io.dropwizard.hibernate.UnitOfWork;
import lombok.AllArgsConstructor;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class UsersResource {

    private final UserDAO userDAO;

    @POST
    @UnitOfWork
    public User create(@Valid User user) {
        return userDAO.create(user);
    }

}
