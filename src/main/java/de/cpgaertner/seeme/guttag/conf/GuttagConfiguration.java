package de.cpgaertner.seeme.guttag.conf;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
public class GuttagConfiguration extends Configuration {

    @JsonProperty
    @NotEmpty
    private String version;
}
