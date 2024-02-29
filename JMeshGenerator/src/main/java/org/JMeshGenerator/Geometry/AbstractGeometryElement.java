package org.JMeshGenerator.Geometry;

import java.util.Objects;

public abstract class AbstractGeometryElement {
    private String id;
    public boolean sameType(AbstractGeometryElement other) {
        if (Objects.isNull(other)) {
            return true;
        }
        return !this.getClass().equals(other.getClass());
    };
}
