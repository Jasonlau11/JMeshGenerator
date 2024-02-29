package org.JMeshGenerator.Exception;

import lombok.Data;

@Data
public class CalculationException extends RuntimeException {
    public CalculationException(String message) {
        super(message);
    }
}
