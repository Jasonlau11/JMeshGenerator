package org.JMeshGenerator.Geometry.PlanarElements;

import lombok.Data;
import org.JMeshGenerator.Exception.ElementIncompatibleException;
import org.JMeshGenerator.Geometry.AbstractNode;

import java.util.List;

@Data
public class PlanarNode extends AbstractNode {
    private List<PlanarNode> adjacentNodes;

    @Override
    public double distanceTo(AbstractNode other) {
        if (sameType(other)) {
            throw new ElementIncompatibleException("Incompatible node types.");
        }
        return this.getPosition().distanceTo(other.getPosition());
    }
}
