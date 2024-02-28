package org.JMeshGenerator.Exception;

import lombok.Data;

@Data
public class CalculationException extends RuntimeException {
    private String msg;
    public CalculationException(String msg) {
        this.msg = msg;
    }
}
