package org.example.model;

import lombok.Getter;

public class QualityDTO {

    @Getter
    private String o3;

    public QualityDTO(String o3) {
        this.o3 = o3;
    }
}
