package org.JMeshGenerator.Geometry;

import lombok.Data;
import org.JMeshGenerator.Exception.ElementIncompatibleException;

@Data
public abstract class AbstractNode extends AbstractGeometryElement {
    public AbstractNode() {
    }

    public AbstractNode(AbstractPosition position) {
        this.position = position;
    }

    private AbstractPosition position;
    public double distanceTo(AbstractNode other) {
        if (!this.getClass().equals(other.getClass())) {
            throw new ElementIncompatibleException("Incompatible node types.");
        }
        return this.getPosition().distanceTo(other.getPosition());
    };

    public boolean equals(AbstractNode other) {
        if (!this.getClass().equals(other.getClass())) {
            throw new ElementIncompatibleException("Incompatible node types.");
        }
        return this.getPosition().same(other.getPosition());
    };
}
