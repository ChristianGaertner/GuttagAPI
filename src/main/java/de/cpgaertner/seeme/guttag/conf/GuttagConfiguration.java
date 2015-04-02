package de.cpgaertner.seeme.guttag.conf;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GuttagConfiguration extends Configuration {

    @JsonProperty
    @NotEmpty
    private String version;

    @JsonProperty
    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();
}
