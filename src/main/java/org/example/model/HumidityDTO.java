package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HumidityDTO {

    private String skyText;
    private Integer humidity;
    private String windText;

}
