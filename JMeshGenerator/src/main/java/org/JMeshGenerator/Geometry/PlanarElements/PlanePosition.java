package org.JMeshGenerator.Geometry.PlanarElements;

import lombok.Data;
import org.JMeshGenerator.Exception.CalculationException;
import org.JMeshGenerator.Geometry.AbstractPosition;

@Data
public class PlanePosition extends AbstractPosition {
    private double x;
    private double y;

    @Override
    public double distanceTo(AbstractPosition other) {
        if (!(other instanceof PlanePosition)) {
            throw new CalculationException("Incompatible position types.");
        }
        PlanePosition otherPos = (PlanePosition) other;
        return Math.sqrt(Math.pow(this.x - otherPos.x, 2) + Math.pow(this.y - otherPos.y, 2));
    }
}
