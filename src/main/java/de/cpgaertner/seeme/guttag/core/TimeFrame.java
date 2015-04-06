package de.cpgaertner.seeme.guttag.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "de.cpgaertner.seeme.guttag.core.TimeFrame.findAll",
                query = "SELECT tf FROM TimeFrame tf"
        )
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimeFrame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne
    private User owner;

    @NotNull
    private long start;

    @NotNull
    private long end;
}
