package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class QualityDTO {

    @Getter
    @Setter
    @JsonProperty("o3")
    private Integer o3;

    public QualityDTO(Integer o3) {
        this.o3 = o3;
    }
}
