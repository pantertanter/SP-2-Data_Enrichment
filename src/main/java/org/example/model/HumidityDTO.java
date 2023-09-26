package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class HumidityDTO {

    private String LocationName;
    private CurrentData CurrentData;


    @Getter
    static class CurrentData {

        private int temperature;
        private String skyText;
        private int humidity;
        private String windText;
    }

}
