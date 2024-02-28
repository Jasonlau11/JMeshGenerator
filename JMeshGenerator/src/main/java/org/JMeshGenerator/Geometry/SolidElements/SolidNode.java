package org.JMeshGenerator.Geometry.SolidElements;

import lombok.Data;
import org.JMeshGenerator.Exception.CalculationException;
import org.JMeshGenerator.Geometry.AbstractNode;
import org.JMeshGenerator.Geometry.PlanarElements.PlanePosition;

import java.util.List;

@Data
public class SolidNode extends AbstractNode {
    private PlanePosition position;
    private List<SolidNode> adjacentNodes;
    @Override
    public double distanceTo(AbstractNode other) {
        if (!(other instanceof SolidNode)) {
            throw new CalculationException("Incompatible node types.");
        }
        return this.position.distanceTo(((SolidNode) other).position);
    }
}
