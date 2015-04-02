package de.cpgaertner.seeme.guttag.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "de.cpgaertner.seeme.guttag.core.User.findAll",
                query = "SELECT u FROM User u"
        )
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 3, max = 250)
    private String username;

    @Email
    @NotNull
    @Size(min = 3, max = 250)
    private String email;

    @NotNull
    @Size(min = 3, max = 250)
    private String firstname;

    @NotNull
    @Size(min = 3, max = 250)
    private String lastname;

}
