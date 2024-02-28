package org.JMeshGenerator.Geometry;

import lombok.Data;
import org.JMeshGenerator.Exception.CalculationException;

import java.util.List;

@Data
public class SpatialNode extends AbstractNode {
    private SpatialPosition position;
    private List<SpatialNode> adjacentNodes;

    @Override
    public double distanceTo(AbstractNode other) {
        if (!(other instanceof SpatialNode)) {
            throw new CalculationException("Incompatible node types.");
        }
        return this.position.distanceTo(((SpatialNode) other).position);
    }
}
