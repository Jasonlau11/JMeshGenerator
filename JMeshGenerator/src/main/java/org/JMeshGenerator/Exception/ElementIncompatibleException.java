package org.JMeshGenerator.Exception;

import lombok.Data;

@Data
public class ElementIncompatibleException extends RuntimeException {
    public ElementIncompatibleException(String message) {
        super(message);
    }
}
