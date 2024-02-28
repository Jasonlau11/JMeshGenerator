package org.JMeshGenerator.Geometry.PlanarElements;

import lombok.Data;
import org.JMeshGenerator.Exception.CalculationException;
import org.JMeshGenerator.Geometry.AbstractNode;

import java.util.List;

@Data
public class PlanarNode extends AbstractNode {
    private PlanePosition position;
    private List<PlanarNode> adjacentNodes;

    @Override
    public double distanceTo(AbstractNode other) {
        if (!(other instanceof PlanarNode)) {
            throw new CalculationException("Incompatible node types.");
        }
        return this.position.distanceTo(((PlanarNode) other).position);
    }
}
