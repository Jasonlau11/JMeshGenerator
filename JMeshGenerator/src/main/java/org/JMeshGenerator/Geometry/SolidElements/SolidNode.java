package org.JMeshGenerator.Geometry.SolidElements;

import lombok.Data;
import org.JMeshGenerator.Exception.ElementIncompatibleException;
import org.JMeshGenerator.Geometry.AbstractNode;

import java.util.List;

@Data
public class SolidNode extends AbstractNode {
    private List<SolidNode> adjacentNodes;
    @Override
    public double distanceTo(AbstractNode other) {
        if (!sameType(other)) {
            throw new ElementIncompatibleException("Incompatible node types.");
        }
        return this.getPosition().distanceTo(other.getPosition());
    }
}
