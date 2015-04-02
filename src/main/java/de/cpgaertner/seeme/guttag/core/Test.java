package de.cpgaertner.seeme.guttag.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Test {

    @JsonProperty
    private long id;

    @Length(max = 3)
    private String content;
}
