package de.cpgaertner.seeme.guttag.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    private String username;

    private String email;

    private String firstname;

    private String lastname;

}
