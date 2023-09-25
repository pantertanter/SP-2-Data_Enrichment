package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class HumidityDTO {

    private String locationName;
    private String skyText;
    private Integer humidity;
    private String windText;

}
